import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10895 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (reader.ready()) {
			String[] one = reader.readLine().split(" ");
			int r = Integer.parseInt(one[0]);
			int c = Integer.parseInt(one[1]);
			int[][] matrix = new int[r][c];
			int[][] ans = new int[c][r];
			ArrayList<ArrayList<Integer>> nonZeroIndex = new ArrayList<>();

			for (int i = 0; i < r; i++) {
				String[] a = reader.readLine().split(" ");
				String[] b = reader.readLine().split(" ");

				if (a[0].equals("0")) {
					for (int j = 0; j < c; j++) {
						matrix[i][j] = 0;
					}
				} else {
					int nonZero = Integer.parseInt(a[0]);
					for (int j = 1; j <= nonZero; j++) {
						int index = Integer.parseInt(a[j]);
						int val = Integer.parseInt(b[j - 1]);
						matrix[i][index - 1] = val;
					}
				}
			}

			for (int i = 0; i < c; i++) {
				nonZeroIndex.add(new ArrayList<>());
				for (int j = 0; j < r; j++) {
					ans[i][j] = matrix[j][i];
					if (ans[i][j] != 0) {
						nonZeroIndex.get(i).add(j + 1);
					}
				}
			}
			System.out.println(c + " " + r);
			for (int i = 0; i < c; i++) {
				// for each row
				System.out.print(nonZeroIndex.get(i).size());
				for (int hol : nonZeroIndex.get(i)) {
					System.out.print(" " + hol);
				}
				System.out.println();
				for (int j = 0; j < nonZeroIndex.get(i).size(); j++) {
					if (j == 0) {
						System.out.print(ans[i][nonZeroIndex.get(i).get(j) - 1]);
					} else {
						System.out.print(" " + ans[i][nonZeroIndex.get(i).get(j) - 1]);
					}
				}
				System.out.println();
			}
		}
	}
}
