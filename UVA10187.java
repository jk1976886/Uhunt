import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UVA10187 {
	public static Map<String, ArrayList<String>> map;
	public static Map<String, ArrayList<train>> time;
	public static Set<String> begNames, visited;
	public static ArrayList<ArrayList<String>> route;
	public static ArrayList<Integer> d, depar;

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());

		for (int q = 0; q < test; q++) {

			// first, read input, remove all bad trains
			// then, find all paths from beg to end
			// lastly, figure out the time

			int edge = Integer.parseInt(reader.readLine());
			// sc.nextLine();
			map = new HashMap<>();
			begNames = new HashSet<>();
			visited = new HashSet<>();
			route = new ArrayList<>();
			time = new HashMap<>();
			d = new ArrayList<>();
			depar = new ArrayList<>();

			for (int i = 0; i < edge; i++) {
				String[] line = reader.readLine().split(" ");
				int dep = Integer.parseInt(line[2]);
				int dur = Integer.parseInt(line[3]);
				int arr = add(dep, dur);

				if ((dep >= 18) && dur <= 12 && (arr <= 6 || arr == 24)) {

					if (!map.containsKey(line[0])) {
						map.put(line[0], new ArrayList<>());
					}
					if (!time.containsKey(line[0])) {
						time.put(line[0], new ArrayList<>());
					}
					if (!begNames.contains(line[0])) {
						begNames.add(line[0]);
					}

					map.get(line[0]).add(line[1]);
					// HashMap<String departure name, ArrayList<train>>

					time.get(line[0]).add(new train(dep, arr, dur, line[1]));

				}
			}
			String[] line = reader.readLine().split(" ");
			String beg = line[0];
			String end = line[1];

			// for (int i = 0; i < begNames.size(); i++) {
			// for (train t : time.get(begNames.get(i))) {
			// System.out.println(begNames.get(i) + " to " + t.destination + " from " +
			// t.dep + " to " + t.arr);
			// }
			// }

			dfs(beg, end, beg, new ArrayList<String>(), 0, 0, 0);

			System.out.println("Test Case " + (q + 1) + ".");

			if (route.size() == 0) {
				System.out.println("There is no route Vladimir can take.");
			} else {
				int min = Integer.MAX_VALUE;
				int index = 0;

				for (int i = 0; i < route.size(); i++) {
					// int blood = 0;
					// calculate blood consumption
					// duration is the same index as path

					if (d.get(i) < min) {
						min = d.get(i);
						index = i;
					}
				}
				// System.out.println(min);
				int day = d.get(index) / 24;
				int left = d.get(index) % 24;
				if (depar.get(index) != 24 && depar.get(index) + left > 24) {
					day += (depar.get(index) + left) / 24;
				}
				System.out.println("Vladimir needs " + day + " litre(s) of blood.");
			}
		}

	}

	public static void dfs(String beg, String end, String cur, ArrayList<String> path, int origDep, int lastArr,
			int totalDur) {
		if (cur.equals(end)) {
			path.add(cur);
			route.add(path);
			// change duration djsakflsj
			d.add(totalDur);
			depar.add(origDep);
			return;
		}

		path.add(cur);
		visited.add(cur);
		if (begNames.contains(cur)) {
			for (int i = 0; i < map.get(cur).size(); i++) {
				if (!visited.contains(map.get(cur).get(i))) {
					ArrayList<String> hol = new ArrayList<>();
					for (String s : path) {
						hol.add(s);
					}
					// change duration dasfhjkaljlk
					int arrHol = time.get(cur).get(i).arr;
					int totalHol = totalDur + time.get(cur).get(i).dur;
					if (lastArr != 0) {
						// update gap
						totalHol += gap(time.get(cur).get(i).dep, lastArr);
					} else {
						origDep = time.get(cur).get(i).dep;
					}
					visited.add(map.get(cur).get(i));
					dfs(beg, end, map.get(cur).get(i), hol, origDep, arrHol, totalHol);
					visited.remove(map.get(cur).get(i));
				}
			}
		}

	}

	public static int gap(int dep, int arr) {
		int ans = 0;
		if (arr == 24) {
			arr = 0;
		}
		if (dep < arr) {
			ans = 24 - arr;
		} else {
			ans = dep - arr;
		}
		return ans;
	}

	public static class train {
		int dep, arr, dur;
		String destination;

		public train(int d, int a, int du, String des) {
			dep = d;
			arr = a;
			dur = du;
			destination = des;
		}

	}

	public static int add(int a, int b) {

		int ans = a + b;

		if (ans > 24) {
			ans -= 24;
		}

		return ans;
	}

}
