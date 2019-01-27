import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class UVA11264 {
	public static int[] coin;
	public static HashSet<Integer> coinCur;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine().trim());

		for (int p = 0; p < test; p++) {

			int c = Integer.parseInt(reader.readLine());
			String[] line = reader.readLine().split(" ");
			coin = new int[c];
			for (int i = 0; i < c; i++) {
				coin[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(coin);
			int max = 0;
			int sum = 0;
			for (int i = 0; i < c; i++) {
				coinCur = new HashSet<>();
				withdraw(sum + coin[i]);
				if (coinCur.size() > max) {
					max = coinCur.size();
					sum += coin[i];
				}
			}
			System.out.println(max);
		}

	}

	public static void withdraw(int val) {
		if (val == 0) {
			return;
		}

		int cur = -1;
		for (int i = coin.length - 1; i >= 0; i--) {
			if (coin[i] <= val) {
				cur = coin[i];
				break;
			}
		}
		if (cur == -1) {
			return;
		}
		coinCur.add(cur);
		withdraw(val - cur);
	}
}
