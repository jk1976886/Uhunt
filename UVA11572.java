import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class UVA11572 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine().split(" ")[0]);

		for (int p = 0; p < test; p++) {
			int flake = Integer.parseInt(reader.readLine().split(" ")[0]);

			ArrayList<Integer> arr = new ArrayList<>();

			for (int i = 0; i < flake; i++) {
				arr.add(Integer.parseInt(reader.readLine().split(" ")[0]));
			}

			Set<Integer> set = new HashSet<>();
			int max = 0;
			for (int i = 0; i < flake; i++) {
				int curSet = 0;
				for (int ii = i; ii < flake; ii++) {
					set.add(arr.get(ii));
					if (set.size() == curSet) {
						break;
					} else {
						curSet++;
					}
				}

				if (curSet > max) {
					max = curSet;
				}
				set.clear();
			}

			System.out.println(max);

		}
	}
}
