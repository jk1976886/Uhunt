import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UVA1062 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		while (sc.hasNext()) {
			String line = sc.nextLine();
			if (line.equals("end")) {
				break;
			}
			Queue<Character> load = new LinkedList<>();

			for (int i = 0; i < line.length(); i++) {
				load.add(line.charAt(i));
			}

			ArrayList<Stack<Character>> stacks = new ArrayList<>();
			ArrayList<Character> top = new ArrayList<>();

			while (!load.isEmpty()) {
				char cur = load.poll();

				boolean done = false;
				for (int i = 0; i < top.size(); i++) {
					if (top.get(i) == cur) {
						stacks.get(i).push(cur);
						done = true;
						break;
					} else if (top.get(i) > cur) {
						stacks.get(i).push(cur);
						top.remove(i);
						top.add(i, cur);
						done = true;
						break;
					}
				}

				if (!done) {
					stacks.add(new Stack<>());
					stacks.get(stacks.size() - 1).add(cur);
					top.add(cur);
				}

			}

			System.out.println("Case " + counter + ": " + stacks.size());
			counter++;
		}

	}
}
