import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10487 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int counter = 1;
		while (true) {
			int n = Integer.parseInt(reader.readLine());
			if (n == 0) {
				break;
			}

			int[] data = new int[n];

			for (int i = 0; i < n; i++) {
				data[i] = Integer.parseInt(reader.readLine());
			}

			int m = Integer.parseInt(reader.readLine());
			int[] ans = new int[m];
			int[] tar = new int[m];
			for (int a = 0; a < m; a++) {
				int target = Integer.parseInt(reader.readLine());
				int current = Integer.MIN_VALUE;
				for (int i = 0; i < n; i++) {
					for (int j = i + 1; j < n; j++) {
						if (Math.abs(data[i] + data[j] - target) < Math.abs(current - target)) {
							current = data[i] + data[j];
						}
					}
				}
				ans[a] = current;
				tar[a] = target;
			}
			System.out.println("Case " + counter + ":");
			for (int i = 0; i < m; i++) {
				System.out.println("Closest sum to " + tar[i] + " is " + ans[i] + ".");
			}
			counter++;
		}

	}
}
