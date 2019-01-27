import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA11553 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {

			n = Integer.parseInt(reader.readLine());
			input = new int[n][n];
			used = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				String[] line = reader.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					input[i][j] = Integer.parseInt(line[j]);
				}
			}

			min = Integer.MAX_VALUE;
			find(0, 0);
			System.out.println(min);
		}

	}

	public static int min, n;
	public static int[][] input;
	public static boolean[][] used;

	public static void find(int curRow, int curSum) {
		if (curRow == n) {
			if (curSum < min) {
				min = curSum;
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!used[curRow][i]) {
				for (int a = 0; a < n; a++) {
					used[a][i] = true;
				}
				find(curRow + 1, curSum + input[curRow][i]);
				for (int a = 0; a < n; a++) {
					used[a][i] = false;
				}
			}
		}
	}
}
