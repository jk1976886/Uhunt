import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10102 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (reader.ready()) {
			int m = Integer.parseInt(reader.readLine());
			int[][] input = new int[m][m];
			ArrayList<pair> ones = new ArrayList<>();
			ArrayList<pair> threes = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				String line = reader.readLine();
				for (int j = 0; j < m; j++) {
					input[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
					if (input[i][j] == 1) {
						ones.add(new pair(i, j));
					} else if (input[i][j] == 3) {
						threes.add(new pair(i, j));
					}
				}
			}

			int max = Integer.MIN_VALUE;

			for (pair one : ones) {
				int min = Integer.MAX_VALUE;
				for (pair three : threes) {
					// find distance
					int distance = Math.abs(three.r - one.r) + Math.abs(three.c - one.c);
					if (distance < min) {
						min = distance;
					}
				}
				if (min > max) {
					max = min;
				}
			}
			System.out.println(max);

		}

	}

	public static class pair {
		int r, c;

		public pair(int one, int two) {
			r = one;
			c = two;
		}
	}
}
