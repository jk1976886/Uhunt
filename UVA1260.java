import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA1260 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());
		for (int p = 0; p < test; p++) {
			int n = Integer.parseInt(reader.readLine());
			String[] line = reader.readLine().split(" ");
			int[] sales = new int[n];
			for (int i = 0; i < n; i++) {
				sales[i] = Integer.parseInt(line[i]);
			}

			int counter = 0;
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i; j++) {
					if (sales[j] <= sales[i]) {
						counter++;
					}
				}
			}
			System.out.println(counter);
		}

	}
}
