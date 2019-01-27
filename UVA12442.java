import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA12442 {

	public static int[] map;
	public static boolean[] visited;
	public static int[] checked;

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());

		for (int p = 0; p < T; p++) {
			int N = Integer.parseInt(reader.readLine());
			map = new int[N];
			checked = new int[N];
			for (int i = 0; i < N; i++) {
				String[] line = reader.readLine().split(" ");

				int a = Integer.parseInt(line[0]) - 1;
				int b = Integer.parseInt(line[1]) - 1;
				map[a] = b;
				checked[a] = -1;
			}

			int max = 0;
			int index = 1;
			visited = new boolean[N];
			// checked = new int[N];
			for (int i = 0; i < N; i++) {
				if (checked[i] == -1) {
					// visited = new boolean[N];

					dfs(i);
				}
				if (checked[i] > max) {
					max = checked[i];
					index = i;
				}

			}

			System.out.println("Case " + (p + 1) + ": " + (index + 1));

		}
	}

	public static int dfs(int cur) {
		visited[cur] = true;

		int ans = 0;

		if (!visited[map[cur]]) {
			ans = 1 + dfs(map[cur]);
		}
		visited[cur] = false;
		checked[cur] = ans;
		return ans;
	}

}
