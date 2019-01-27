import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA927 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			String[] line = reader.readLine().split(" ");
			int degree = Integer.parseInt(line[0]);
			int[] coef = new int[degree + 1];

			for (int i = 0; i <= degree; i++) {
				coef[i] = Integer.parseInt(line[i + 1]);
			}

			int d = Integer.parseInt(reader.readLine());
			int k = Integer.parseInt(reader.readLine());

			int counter = 1;
			int termNumber = 0;

			while (true) {
				termNumber += counter * d;
				if (termNumber >= k) {
					break;
				} else {
					counter++;
				}
			}

			// find a_counter
			// counter++;
			long temp = 0;
			for (int i = 0; i < coef.length; i++) {
				// if (coef[i] != 0) {
				temp += coef[i] * Math.pow(counter, i);
				// }
			}

			System.out.println(temp);

		}

	}
}
