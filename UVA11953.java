import java.util.Scanner;

public class UVA11953 {
	public static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int p = 1; p <= T; p++) {

			int N = sc.nextInt();
			map = new int[N][N];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for (int ii = 0; ii < N; ii++) {
					if (line.charAt(ii) == '.') {
						map[i][ii] = 0;
					} else if (line.charAt(ii) == '@') {
						map[i][ii] = 1;
					} else if (line.charAt(ii) == 'x') {
						map[i][ii] = 2;
					}
				}
			}

			int counter = 0;

			for (int i = 0; i < N; i++) {
				for (int ii = 0; ii < N; ii++) {
					if (map[i][ii] != 0) {
						if (dfs(i, ii, false)) {
							counter++;
						}
					}
				}
			}

			System.out.println("Case " + p + ": " + counter);
		}

	}

	public static boolean dfs(int r, int c, boolean ans) {

		if (map[r][c] == 2) {
			ans = true;
		}

		map[r][c] = 0;

		if (valid(r + 1, c) && map[r + 1][c] != 0) {
			if (dfs(r + 1, c, ans)) {
				ans = true;
			}
		}
		if (valid(r - 1, c) && map[r - 1][c] != 0) {
			if (dfs(r - 1, c, ans)) {
				ans = true;
			}
		}
		if (valid(r, c + 1) && map[r][c + 1] != 0) {
			if (dfs(r, c + 1, ans)) {
				ans = true;
			}
		}
		if (valid(r, c - 1) && map[r][c - 1] != 0) {
			if (dfs(r, c - 1, ans)) {
				ans = true;
			}
		}

		return ans;

	}

	public static boolean valid(int r, int c) {
		return r >= 0 && r < map.length && c >= 0 && c < map.length;
	}
}
