import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA11463 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());

		for (int p = 1; p <= test; p++) {
			int V = Integer.parseInt(reader.readLine());
			int E = Integer.parseInt(reader.readLine());
			int[][] map = new int[V][V];
			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					map[i][j] = 10000000;
				}
				map[i][i] = 0;
			}
			for (int i = 0; i < E; i++) {
				String[] line = reader.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				map[a][b] = 1;
				map[b][a] = 1;
			}
			String[] line = reader.readLine().split(" ");
			int start = Integer.parseInt(line[0]);
			int end = Integer.parseInt(line[1]);

			for (int i = 0; i < V; i++) {
				for (int j = 0; j < V; j++) {
					for (int k = 0; k < V; k++) {
						map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
					}
				}
			}

			int max = 0;
			for (int i = 0; i < V; i++) {
				max = Math.max(max, map[start][i] + map[i][end]);
			}
			System.out.println("Case " + p + ": " + max);
		}

	}
}
