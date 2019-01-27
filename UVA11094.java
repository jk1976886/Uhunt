import java.util.Scanner;

public class UVA11094 {

	public static char[][] map;
	public static int size, M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			M = sc.nextInt();

			N = sc.nextInt();

			sc.nextLine();
			map = new char[M][N];
			for (int i = 0; i < M; i++) {
				String line = sc.nextLine();
				for (int ii = 0; ii < N; ii++) {
					map[i][ii] = line.charAt(ii);
				}
			}

			int a = sc.nextInt();
			int b = sc.nextInt();
			sc.nextLine();
			char water = '?';
			char land = map[a][b];

			for (int i = 0; i < M; i++) {
				for (int ii = 0; ii < M; ii++) {
					if (map[i][ii] != land) {
						water = map[i][ii];
						break;
					}
				}
				if (water != '?') {
					break;
				}
			}

			dfs(a, b, water, land);

			int max = 0;

			for (int i = 0; i < M; i++) {
				for (int ii = 0; ii < N; ii++) {
					if (map[i][ii] == land) {
						size = 0;
						dfs(i, ii, water, land);
						if (size > max) {
							max = size;
						}
					}
				}
			}
			System.out.println(max);

			if (sc.hasNextLine()) {
				sc.nextLine();
			}

		}

	}

	public static int[] dr = { 0, 0, 1, -1 };
	public static int[] dc = { 1, -1, 0, 0 };

	public static void dfs(int r, int c, char water, char land) {
		size++;
		map[r][c] = 0;

		// check 4 directions
		for (int i = 0; i < 4; i++) {
			int tempR = r + dr[i];
			int tempC = c + dc[i];
			if (valid(tempR, tempC) && map[tempR][tempC] == land) {
				dfs(tempR, tempC, water, land);
			}
		}

		// special case: left right connected
		if (c == 0) {
			int tempR = r;
			int tempC = N - 1;
			if (valid(tempR, tempC) && map[tempR][tempC] == land) {
				dfs(tempR, tempC, water, land);
			}
		} else if (c == N - 1) {
			int tempR = r;
			int tempC = 0;
			if (valid(tempR, tempC) && map[tempR][tempC] == land) {
				dfs(tempR, tempC, water, land);
			}
		}

	}

	public static boolean valid(int r, int c) {
		return r >= 0 && r < M && c >= 0 && c < N;
	}
}
