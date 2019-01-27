import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA1237 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());
		for (int p = 0; p < test; p++) {
			if (p != 0) {
				System.out.println();
			}
			int d = Integer.parseInt(reader.readLine());
			String[] name = new String[d];
			int[] low = new int[d];
			int[] high = new int[d];

			for (int i = 0; i < d; i++) {
				String[] line = reader.readLine().split(" ");
				name[i] = line[0];
				low[i] = Integer.parseInt(line[1]);
				high[i] = Integer.parseInt(line[2]);
			}
			int q = Integer.parseInt(reader.readLine());
			for (int i = 0; i < q; i++) {
				// boolean found = false;
				ArrayList<Integer> ans = new ArrayList<>();
				int price = Integer.parseInt(reader.readLine());
				for (int j = 0; j < d; j++) {
					if (low[j] <= price && price <= high[j]) {
						ans.add(j);
					}
				}

				if (ans.size() == 1) {
					System.out.println(name[ans.get(0)]);
				} else {
					System.out.println("UNDETERMINED");
				}

			}

		}

	}
}
