import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class UVA11136 {
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int n = Integer.parseInt(reader.readLine());

			if (n == 0) {
				break;
			}

			TreeSet<Integer> raf = new TreeSet<>();
			// ArrayList<Integer> arr = new ArrayList<>();
			// Map<Integer, Integer> map = new HashMap<>();
			int[] arr = new int[1000001];
			long total = 0;

			for (int i = 0; i < n; i++) {
				String[] line = reader.readLine().split(" ");

				for (int ii = 1; ii <= Integer.parseInt(line[0]); ii++) {
					int temp = Integer.parseInt(line[ii]);

					arr[temp]++;
					if (!raf.contains(temp)) {
						raf.add(temp);
					}
				}
				int min = raf.first();
				int max = raf.last();

				arr[min]--;
				arr[max]--;

				if (arr[max] == 0) {
					raf.remove(max);
				}

				if (arr[min] == 0) {
					raf.remove(min);
				}

				total += max - min;

			}
			System.out.println(total);

		}

	}
}
