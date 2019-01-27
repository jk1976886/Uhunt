import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class UVA872 {
	public static HashMap<Integer, String> names;
	public static HashMap<String, Integer> index;
	public static HashMap<Integer, TreeSet<Integer>> map;
	public static int[] indegree;
	public static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		reader.readLine();
		for (int p = 0; p < T; p++) {
			if (p > 0) {
				reader.readLine();
				System.out.println();
			}
			String[] variables = reader.readLine().split(" ");
			String[] relations = reader.readLine().split(" ");
			n = variables.length;
			// further split by "<"
			names = new HashMap<>();
			index = new HashMap<>();
			map = new HashMap<>();
			indegree = new int[n];

			for (int i = 0; i < n; i++) {
				index.put(variables[i], i);
				names.put(i, variables[i]);
				map.put(i, new TreeSet<>());
			}

			for (String re : relations) {
				String[] cur = re.split("<");
				// 0 before 1
				int a = index.get(cur[0]);
				int b = index.get(cur[1]);
				if (!map.get(a).contains(b)) {
					map.get(a).add(b);
					indegree[b]++;
				}
			}
			visited = new boolean[n];
			TreeSet<String> ans = new TreeSet<>();

			for (int i = 0; i < n; i++) {
				if (indegree[i] == 0) {
					ArrayList<String> path = dfs(i, names.get(i));
					// check is path is complete, add to ans if yes
					for (String s : path) {
						ans.add(s);
					}
				}
			}
			PriorityQueue<String> pq = new PriorityQueue<>();
			if (ans.size() == 0) {
				System.out.println("NO");
			} else {
				for (String s : ans) {
					pq.add(s.trim());
				}
				while (!pq.isEmpty()) {
					System.out.println(pq.poll());
				}
			}

		}
	}

	public static boolean[] visited;

	public static ArrayList<String> dfs(int cur, String path) {
		visited[cur] = true;
		ArrayList<String> paths = new ArrayList<>();
		for (int child : map.get(cur)) {
			indegree[child]--;

		}
		for (int child = 0; child < n; child++) {
			if (indegree[child] == 0 && !visited[child]) {
				paths.addAll(dfs(child, path + " " + names.get(child)));
			}

		}
		for (int child : map.get(cur)) {
			indegree[child]++;
		}

		visited[cur] = false;
		if (path.length() == 2 * n - 1) {
			paths.add(path);
		}
		return paths;

	}
}
