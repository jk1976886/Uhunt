import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UVA111 {
	public static int[] arr, ans, dp;
	public static HashMap<Integer, Integer> answer, response;

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<String> input = new ArrayList<String>();
		while (sc.hasNextLine()) {
			input.add(sc.nextLine());
		}
		int index = 0;
		while (index < input.size()) {
			int n = Integer.parseInt(input.get(index));
			index++;
			String[] temp = input.get(index).split(" ");
			index++;
			answer = new HashMap<>();
			ans = new int[n];
			for (int i = 0; i < n; i++) {
				answer.put(Integer.parseInt(temp[i]), i + 1);
			}
			for (int i = 0; i < n; i++) {
				ans[i] = answer.get(i + 1);
			}

			while (true) {
				if (index == input.size()) {
					break;
				}
				temp = input.get(index).split(" ");
				if (temp.length == 1) {
					break;
				} else {
					index++;
					response = new HashMap<>();
					arr = new int[n];
					dp = new int[n];

					for (int i = 0; i < n; i++) {
						response.put(Integer.parseInt(temp[i]), i + 1);
					}
					for (int i = 0; i < n; i++) {
						arr[i] = response.get(i + 1);
					}

					int max = 0;
					for (int i = 0; i < n; i++) {
						dp[i] = find(i);
						if (dp[i] > max) {
							max = dp[i];
						}
					}
					System.out.println(max);
				}

			}

		}

	}

	public static int find(int index) {
		if (index == 0) {
			return 1;
		}
		int max = 1;
		for (int i = index - 1; i >= 0; i--) {
			if (isAfter(arr[index], arr[i])) {
				if ((dp[i] + 1) > max) {
					max = dp[i] + 1;
				}
			}

		}
		return max;

	}

	public static boolean isAfter(int num1, int num2) {
		boolean after = false;
		int index = getIndex(num2);
		for (int i = index + 1; i < ans.length; i++) {
			if (ans[i] == num1) {
				after = true;
			}
		}

		return after;
	}

	public static int getIndex(int num) {
		for (int i = 0; i < ans.length; i++) {
			if (ans[i] == num) {
				return i;
			}
		}
		return 0;
	}
}