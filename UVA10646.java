import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UVA10646 {
	public static void main(String[] args) throws Exception {
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> num = new HashMap<>();
		Map<Integer, String> name = new HashMap<>();
		String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
		String[] suit = { "S", "H", "D", "C" };

		int counter = 0;
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				num.put((rank[i] + suit[j]), counter);
				name.put(counter, (rank[i] + suit[j]));
				counter++;
			}
		}

		int test = sc.nextInt();

		for (int p = 1; p <= test; p++) {
			Stack<String> original = new Stack<>();
			Queue<Integer> numOr = new LinkedList<>();

			for (int i = 0; i < 52; i++) {
				original.push(sc.next());
				numOr.add(num.get(original.pop()));
			}

			Stack<Integer> rest = new Stack<>();
			for (int i = 25; i < 52; i++) {
				rest.push(numOr.poll());
			}
			ArrayList<Integer> card = new ArrayList<>();
			// first 25 cards remain unchanged
			for (int i = 0; i < 25; i++) {
				card.add(0, numOr.poll());
			}

			int Y = 0;
			for (int a = 0; a < 3; a++) {

				int cur = rest.pop();
				int X = 0;
				if (cur >= 4 && cur <= 35) {
					X = Integer.parseInt(Character.toString(name.get(cur).charAt(0)));
				} else {
					X = 10;
				}
				Y += X;

				for (int j = 0; j < (10 - X) && !rest.isEmpty(); j++) {
					rest.pop();
				}

			}
			while (!rest.isEmpty()) {
				card.add(rest.pop());
			}
			// System.out.println(Y);
			System.out.println("Case " + p + ": " + name.get(card.get(card.size() - Y)));
		}

	}
}
