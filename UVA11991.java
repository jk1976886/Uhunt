import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UVA11991 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (reader.ready()) {
			String[] one = reader.readLine().split(" ");
			int n = Integer.parseInt(one[0]);
			int k = Integer.parseInt(one[1]);

			Map<Integer, ArrayList<Integer>> occur = new HashMap<>();
			String[] line = reader.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				int cur = Integer.parseInt(line[i]);
				if (!occur.containsKey(cur)) {
					occur.put(cur, new ArrayList<>());
				}
				occur.get(cur).add(i + 1);
			}

			for (int i = 0; i < k; i++) {
				String[] two = reader.readLine().split(" ");
				int oc = Integer.parseInt(two[0]);
				int index = Integer.parseInt(two[1]);
				if (occur.containsKey(index) && occur.get(index).size() >= oc) {
					System.out.println(occur.get(index).get(oc - 1));
				} else {
					System.out.println(0);
				}
			}
		}
	}
}
