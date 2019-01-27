import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class UVA497 {
	// public static ArrayList<Integer> input;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// ArrayList<String> holder = new ArrayList<>();
		// // while (sc.hasNext()) {
		// // holder.add(sc.nextLine());
		// // }
		//
		// String[] word = { "3", "", "1", "6", "2", "3", "5", "", "1", "6", "2", "3",
		// "5", "", "1", "1", "2", "3" };
		// int counter = 0;
		// while (counter < word.length) {
		// holder.add(word[counter]);
		// counter++;
		// }

		int test = Integer.parseInt(sc.nextLine());
		// System.out.println("test is: " + test);
		sc.nextLine();
		// int index = 2;
		for (int p = 0; p < test && sc.hasNextInt(); p++) {

			ArrayList<Integer> input = new ArrayList<>();

			while (sc.hasNextInt()) {
				String line = sc.nextLine();
				if (line.equals("")) {
					break;
				}
				int temp = Integer.parseInt(line);
				input.add(temp);
			}
			// index++;
			int[] dp = new int[input.size()];

			int[] pointer = new int[input.size()];
			int max = -1;
			int ind = 0;

			for (int i = 0; i < input.size(); i++) {
				dp[i] = 1;
				pointer[i] = -1;
				for (int j = 0; j < i; j++) {
					if (input.get(i) > input.get(j) && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						pointer[i] = j;
					}
				}
				if (dp[i] > max) {
					ind = i;
				}
			}
			Stack<Integer> stack = new Stack<>();

			while (ind >= 0) {
				// System.out.println("index is: " + index);
				stack.push(input.get(ind));
				ind = pointer[ind];
			}

			System.out.println("Max hits: " + stack.size());
			while (!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
			if (p != test - 1) {
				System.out.println();
			}
		}

	}
}
