import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10684 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String hol = reader.readLine();
			while (hol.isEmpty()) {
				hol = reader.readLine();
			}
			int n = Integer.parseInt(hol);
			if (n == 0) {
				break;
			}
			int counter = 0;
			int[] arr = new int[n];
			while (counter < n) {
				hol = reader.readLine();
				while (hol.isEmpty()) {
					hol = reader.readLine();
				}
				String[] line = hol.split(" ");
				for (String s : line) {
					arr[counter] = Integer.parseInt(s);
					counter++;
				}
			}

			// max sum at n
			int[] dp = new int[n];
			int max = Integer.MIN_VALUE;
			dp[0] = Math.max(0, arr[0]);
			for (int i = 1; i < n; i++) {
				dp[i] = Math.max(0, Math.max(arr[i], dp[i - 1] + arr[i]));
			}

			for (int i = 0; i < n; i++) {
				if (dp[i] > max) {
					max = dp[i];
				}
			}
			if (max <= 0) {
				System.out.println("Losing streak.");
			} else {
				System.out.println("The maximum winning streak is " + max + ".");
			}
		}

	}
}
