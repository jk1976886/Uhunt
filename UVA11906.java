import java.util.Scanner;

public class UVA11906 {

	public static int R, C, M, N;
	public static boolean[][] visited;
	public static int[][] mark;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int p = 0; p < T; p++) {
			R = sc.nextInt();
			C = sc.nextInt();
			M = sc.nextInt();
			N = sc.nextInt();

			visited = new boolean[R][C];
			mark = new int[R][C];

			int water = sc.nextInt();

			for (int i = 0; i < water; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				visited[r][c] = true;
				mark[r][c] = 3;
			}
			int[] dr = { M, M, -M, -M, N, N, -N, -N };
			int[] dc = { -N, N, -N, N, -M, M, -M, M };

			dfs(0, 0, dr, dc);
			int odd = 0;
			int even = 0;
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (mark[i][j] == 1) {
						odd++;
					} else if (mark[i][j] == 2) {
						even++;
					}
				}
			}

			System.out.println("Case " + (p + 1) + ": " + even + " " + odd);

		}

	}

	public static void dfs(int curX, int curY, int[] dr, int[] dc) {
		visited[curX][curY] = true;
		int counter = 0;
		boolean[][] temp = new boolean[R][C];

		for (int i = 0; i < 8; i++) {
			int tempX = curX + dr[i];
			int tempY = curY + dc[i];
			if (valid(tempX, tempY) && mark[tempX][tempY] != 3 && !temp[tempX][tempY]) {
				temp[tempX][tempY] = true;
				counter++;
			}
		}

		if (counter % 2 == 0) {
			mark[curX][curY] = 2;
		} else {
			mark[curX][curY] = 1;
		}

		for (int i = 0; i < 8; i++) {
			int tempX = curX + dr[i];
			int tempY = curY + dc[i];
			if (valid(tempX, tempY) && !visited[tempX][tempY]) {
				dfs(tempX, tempY, dr, dc);
			}
		}
	}

	public static boolean valid(int x, int y) {
		return x >= 0 && x < visited.length && y >= 0 && y < visited[0].length;
	}
}
