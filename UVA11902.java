import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA11902 {
	public static int N;
	public static int[][] map;
	public static boolean[][] domination;
	public static boolean[] visited1, visited2;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			N = Integer.parseInt(reader.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String[] line = reader.readLine().split(" ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(line[j]);
				}
			}

			domination = new boolean[N][N];
			visited1 = new boolean[N];
			dfs1(0);
			boolean[][] ans = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				visited2 = new boolean[N];
				dfs2(0, i);
				for (int j = 0; j < N; j++) {
					if (visited1[j] && !visited2[j]) {
						ans[i][j] = true;
					} else {
						ans[i][j] = false;
					}
				}
			}

			System.out.println("Case " + (p + 1) + ":");
			String format = "+";
			for (int i = 0; i < 2 * N - 1; i++) {
				format += "-";
			}
			format += "+";
			System.out.println(format);

			for (int i = 0; i < N; i++) {
				System.out.print("|");
				for (int j = 0; j < N; j++) {
					if (ans[i][j]) {
						System.out.print("Y|");
					} else {
						System.out.print("N|");
					}
				}
				System.out.println();
				System.out.println(format);
			}
		}
	}

	public static void dfs2(int cur, int off) {
		if (cur == off) {
			return;
		}
		visited2[cur] = true;
		for (int i = 0; i < N; i++) {
			if (i != off && map[cur][i] == 1 && !visited2[i]) {
				dfs2(i, off);
			}
		}
	}

	public static void dfs1(int cur) {

		visited1[cur] = true;
		for (int i = 0; i < N; i++) {
			if (map[cur][i] == 1 && !visited1[i]) {
				dfs1(i);
			}
		}
	}
}
