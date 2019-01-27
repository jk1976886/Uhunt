import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVA11389 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] ndr = reader.readLine().split(" ");
			int n = Integer.parseInt(ndr[0]);
			int d = Integer.parseInt(ndr[1]);
			int r = Integer.parseInt(ndr[2]);

			if (n == 0 && d == 0 && r == 0) {
				break;
			}

			String[] D = reader.readLine().split(" ");
			String[] N = reader.readLine().split(" ");
			int[] day = new int[n];
			int[] night = new int[n];

			for (int i = 0; i < n; i++) {
				day[i] = Integer.parseInt(D[i]);
				night[i] = Integer.parseInt(N[i]);
			}

			Arrays.sort(day);
			Arrays.sort(night);
			for (int i = 0; i < n / 2; i++) {
				int temp = night[i];
				night[i] = night[n - i - 1];
				night[n - i - 1] = temp;
			}

			int hour = 0;

			for (int i = 0; i < n; i++) {
				int temp = (day[i] + night[i]) - d;
				if (temp > 0) {
					hour += temp;
				}
			}

			System.out.println(hour * r);

		}

	}
}
