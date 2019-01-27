import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA12405 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {

			int N = Integer.parseInt(reader.readLine());
			boolean[] input = new boolean[N];
			String line = reader.readLine().trim();

			for (int i = 0; i < N; i++) {
				if (line.charAt(i) == '.') {
					input[i] = true;
				}
			}

			int counter = 0;

			for (int i = 0; i < N; i++) {
				if (input[i]) {
					// this is true
					counter++;
					i += 2;
				}
			}
			System.out.println("Case " + (p + 1) + ": " + counter);

		}

	}
}
