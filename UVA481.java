import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class UVA481 {
	public static int[] input, dp, parent, tail;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		ArrayList<Integer> temp = new ArrayList<>();
		while (reader.ready()) {
			temp.add(Integer.parseInt(reader.readLine()));
		}

		input = new int[temp.size()];
		tail = new int[temp.size() + 1];
		dp = new int[temp.size()];
		parent = new int[temp.size()];

		for (int i = 0; i < temp.size(); i++) {
			input[i] = temp.get(i);
			tail[i] = Integer.MIN_VALUE;
		}
		tail[temp.size()] = Integer.MIN_VALUE;
		dp[0] = 1;
		tail[0] = input[0];

		int longest = 0;
		int longIndex = 0;
		for (int i = 0; i < input.length; i++) {
			// for (int j = 0; j < i; j++) {
			// if (input[j] < input[i] && dp[i] < dp[j] + 1) {
			// dp[i] = dp[j] + 1;
			// parent[i] = j;
			// }
			// }

			int left = 0;
			int right = input.length;
			while (left < right) {
				int mid = left + (left + right) / 2;
				if (tail[mid] >= input[i]) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}

			// use left
			dp[i] = left + 1;
			if (tail[left + 1] > input[i]) {
				tail[left + 1] = input[i];
			}

			if (dp[i] >= longest) {
				longest = dp[i];
				longIndex = i;
			}
		}

		Stack<Integer> q = new Stack<>();
		for (int i = 0; i < longest; i++) {
			q.push(input[longIndex]);
			longIndex = parent[longIndex];
		}

		System.out.println(longest);
		System.out.println("-");
		while (!q.isEmpty()) {
			System.out.println(q.pop());
		}

	}

}
