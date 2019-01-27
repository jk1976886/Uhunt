import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UVA514 {
	public static void main(String[] args) throws Exception {
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		while (true) {
			int num = sc.nextInt();
			if (num == 0) {
				break;
			}

			while (true) {
				int first = sc.nextInt();
				if (first == 0) {
					System.out.println();
					break;
				}
				// int[] goal = new int[num];
				Queue<Integer> goal = new LinkedList<>();
				Queue<Integer> begin = new LinkedList<>();
				goal.add(first);
				begin.add(1);
				for (int i = 1; i < num; i++) {
					goal.add(sc.nextInt());
					begin.add(i + 1);
				}

				boolean doable = true;

				Stack<Integer> mid = new Stack<>();
				// int counter = 0;
				while (!goal.isEmpty()) {
					if (!mid.isEmpty() && !begin.isEmpty()) {
						if (mid.peek() == goal.peek()) {
							mid.pop();
							goal.poll();
						} else if (begin.peek() == goal.peek()) {
							begin.poll();
							goal.poll();
						} else {
							mid.push(begin.poll());
						}
					} else if (!mid.isEmpty() && begin.isEmpty()) {
						if (mid.peek() == goal.peek()) {
							mid.pop();
							goal.poll();
						} else {
							doable = false;
							break;
						}
					} else if (mid.isEmpty() && !begin.isEmpty()) {
						if (begin.peek() == goal.peek()) {
							begin.poll();
							goal.poll();
						} else {
							mid.push(begin.poll());
						}
					} else {

						doable = false;
						break;

					}
				}
				if (doable) {
					System.out.println("Yes");
				} else {
					System.out.println("No");
				}

			}
			// System.out.println();
		}

	}

}
