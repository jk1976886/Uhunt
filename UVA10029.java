import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10029 {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		// Scanner sc = new Scanner(new File("input.txt"));
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> dic = new ArrayList<>();

		while (reader.ready()) {
			dic.add(reader.readLine());
		}

		int[] dp = new int[dic.size()];
		int max = -1;

		for (int i = 0; i < dic.size(); i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (check(dic.get(i), dic.get(j)) && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}

		System.out.println(max);

	}

	public static boolean check(String a, String b) {
		if (Math.abs(a.length() - b.length()) > 1) {
			return false;
		}
		if (a.length() == b.length()) {
			int counter = 0;

			for (int i = 0; i < a.length(); i++) {
				if (a.charAt(i) == b.charAt(i)) {
					counter++;
				}
			}

			return counter + 1 == a.length();
		} else {
			if (a.length() > b.length()) {
				// b is shorter

				for (int i = 0; i < a.length(); i++) {
					String temp = a.substring(0, i) + a.substring(i + 1);
					if (temp.equals(b)) {
						return true;
					}
				}
				return false;
			} else {
				// a is shorter
				for (int i = 0; i < b.length(); i++) {
					String temp = b.substring(0, i) + b.substring(i + 1);
					if (temp.equals(a)) {
						return true;
					}
				}
				return false;
			}
		}

	}
}
