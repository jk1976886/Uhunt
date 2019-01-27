import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class UVA787 {
	public static long[] num;
	public static int length;
	public static BigInteger[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] line = reader.readLine().split(" ");
			length = line.length - 1;
			num = new long[length];
			dp = new BigInteger[length][2];

			BigInteger big = new BigInteger("123");

			// 0 is min, 1 is max
			long max = Integer.MIN_VALUE;
			for (int i = 0; i < length; i++) {
				num[i] = Long.parseLong(line[i]);
				if (num[i] > max) {
					max = num[i];
				}
			}

			for (int i = 0; i < length; i++) {
				findProduct(i);
			}
			BigInteger maxDp = dp[0][0];
			for (int i = 0; i < length; i++) {
				if (dp[i][1].compareTo(maxDp) >= 1) {
					maxDp = dp[i][1];
				}
			}

			System.out.println(maxDp.toString());

		}
	}

	public static void findProduct(int cur) {
		BigInteger temp = new BigInteger(Long.toString(num[cur]));
		if (cur == 0) {
			dp[cur][0] = temp;
			dp[cur][1] = temp;
		} else {
			BigInteger a = dp[cur - 1][0].multiply(temp);
			BigInteger b = dp[cur - 1][1].multiply(temp);

			if (a.compareTo(b) < 0) {
				if (b.compareTo(temp) < 0) {
					dp[cur][0] = a;
					dp[cur][1] = temp;
				} else {
					dp[cur][1] = b;
					if (a.compareTo(temp) < 0) {
						dp[cur][0] = a;
					} else {
						dp[cur][0] = temp;
					}
				}
			} else {
				if (a.compareTo(temp) < 0) {
					dp[cur][0] = b;
					dp[cur][1] = temp;
				} else {
					dp[cur][1] = a;
					if (b.compareTo(temp) < 0) {
						dp[cur][0] = b;
					} else {
						dp[cur][0] = temp;
					}
				}
			}

		}

	}
}
