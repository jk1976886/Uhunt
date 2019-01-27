import java.util.Scanner;

public class UVA562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int p = 0; p < n; p++) {
			int m = sc.nextInt();
			int[] coin = new int[m];

			int sum = 0;

			for (int i = 0; i < m; i++) {
				coin[i] = sc.nextInt();
				sum += coin[i];
			}

			int[][] dp = new int[m + 1][sum / 2 + 1];

			for (int i = 0; i <= m; i++) {
				for (int ii = 0; ii <= sum / 2; ii++) {
					if (i == 0 || ii == 0) {
						dp[i][ii] = 0;
					} else if (ii < coin[i - 1]) {
						dp[i][ii] = dp[i - 1][ii];
					} else {
						dp[i][ii] = Math.max(dp[i - 1][ii], dp[i - 1][ii - coin[i - 1]] + coin[i - 1]);
					}
				}
			}

			System.out.println(sum - 2 * dp[m][sum / 2]);

		}

	}

}
