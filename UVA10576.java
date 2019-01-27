import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10576 {
	public static int max, d, s;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (reader.ready()) {
			String[] line = reader.readLine().split(" ");
			s = Integer.parseInt(line[0]);
			d = Integer.parseInt(line[1]);
			max = Integer.MIN_VALUE;
			int[] temp = new int[12];

			find(0, temp);
			if (max < 0) {
				System.out.println("Deficit");
			} else {
				System.out.println(max);
			}
		}

	}

	public static void find(int curMonth, int[] path) {
		if (curMonth == 12) {
			// check if valid and such such
			boolean valid = true;
			int sum = 0;
			for (int i = 0; i < 8; i++) {
				sum = 0;
				for (int j = i; j < i + 5; j++) {
					sum += path[j];
				}
				if (sum > 0) {
					valid = false;
					break;
				}
			}
			sum = 0;
			for (int i = 0; i < 12; i++) {
				sum += path[i];
			}

			if (valid) {
				if (sum > max) {
					max = sum;
				}
			}

			return;
		}
		path[curMonth] = -d;
		find(curMonth + 1, path);
		path[curMonth] = s;
		find(curMonth + 1, path);
	}
}
