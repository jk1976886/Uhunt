import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class UVA11060 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
		int counter = 0;
		while (reader.ready()) {

			int N = Integer.parseInt(reader.readLine().trim());
			HashMap<String, Integer> names = new HashMap<>();
			HashMap<Integer, String> index = new HashMap<>();
			HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				index.put(i, reader.readLine());
				names.put(index.get(i), i);
				map.put(i, new TreeSet<>());
			}
			int M = Integer.parseInt(reader.readLine());
			int[] inorder = new int[N];
			for (int i = 0; i < M; i++) {
				String[] line = reader.readLine().trim().split(" ");
				int a = names.get(line[0]);
				int b = names.get(line[1]);
				if (!map.get(a).contains(b)) {
					map.get(a).add(b);
					inorder[b]++;
				}
			}
			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (int i = 0; i < N; i++) {

				if (inorder[i] == 0) {
					pq.add(i);
				}

			}
			ArrayList<String> ans = new ArrayList<>();
			while (!pq.isEmpty()) {
				int cur = pq.poll();
				for (int i : map.get(cur)) {
					inorder[i]--;
					if (inorder[i] == 0) {
						pq.add(i);
					}
				}
				ans.add(index.get(cur));
			}

			System.out.print("Case #" + (counter + 1) + ": Dilbert should drink beverages in this order:");
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(" " + ans.get(i));
			}
			System.out.print(".");
			System.out.println();
			System.out.println();

			counter++;
			reader.readLine();
			if (!reader.ready()) {
				break;
			}

		}

	}
}
