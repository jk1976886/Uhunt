import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UVA11286 {
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			Map<ArrayList<Integer>, Integer> all = new HashMap<>();
			Set<ArrayList<Integer>> var = new HashSet<>();

			int stu = Integer.parseInt(reader.readLine());
			if (stu == 0) {
				break;
			}
			int max = 0;
			int rep = 0;
			for (int i = 0; i < stu; i++) {
				ArrayList<Integer> temp = new ArrayList<>();
				String[] line = reader.readLine().split(" ");

				for (int ii = 0; ii < 5; ii++) {
					temp.add(Integer.parseInt(line[ii]));
				}
				Collections.sort(temp);

				if (var.contains(temp)) {
					all.put(temp, all.get(temp) + 1);
				} else {
					var.add(temp);
					all.put(temp, 1);
				}

				if (all.get(temp) > max) {
					max = all.get(temp);

				}

				// System.out.println(temp);

			}

			for (ArrayList<Integer> arr : all.keySet()) {
				if (all.get(arr) == max) {
					rep++;
				}
			}
			System.out.println(max * rep);

		}

	}
}
