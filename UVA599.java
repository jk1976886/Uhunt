import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UVA599 {
	public static Map<String, ArrayList<String>> map;
	public static Set<String> visited;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			map = new HashMap<>();
			while (true) {
				String line = reader.readLine();
				if (line.charAt(0) == '*') {
					break;
				}
				String a = Character.toString(line.charAt(1));
				String b = Character.toString(line.charAt(3));

				if (!map.containsKey(a)) {
					map.put(a, new ArrayList<>());
				}
				if (!map.containsKey(b)) {
					map.put(b, new ArrayList<>());
				}

				map.get(a).add(b);
				map.get(b).add(a);

			}

			String[] line = reader.readLine().split(",");
			visited = new HashSet<>();
			int ana = 0;
			int tree = 0;
			for (String s : line) {
				if (!visited.contains(s)) {
					dfs(s);
					if (!map.containsKey(s)) {
						ana++;
					} else {
						tree++;
					}
				}
			}
			System.out.printf("There are %d tree(s) and %d acorn(s).\n", tree, ana);

		}

	}

	public static void dfs(String cur) {
		visited.add(cur);
		if (map.containsKey(cur)) {
			for (String s : map.get(cur)) {
				if (!visited.contains(s)) {
					dfs(s);
				}
			}
		}
	}

}
