import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10141 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int temp = 1;
		while (true) {

			String[] line = reader.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int p = Integer.parseInt(line[1]);
			if (n == 0 && p == 0) {
				break;
			}
			if (temp > 1) {
				System.out.println();
			}
			ArrayList<String> requirement = new ArrayList<>();

			String[] names = new String[p];
			int[] rating = new int[p];
			double[] price = new double[p];

			for (int i = 0; i < n; i++) {
				requirement.add(reader.readLine());
			}
			double maxR = 0;
			int index = 0;

			for (int i = 0; i < p; i++) {
				names[i] = reader.readLine();
				String[] l = reader.readLine().split(" ");
				price[i] = Double.parseDouble(l[0]);
				int hol = Integer.parseInt(l[1]);

				for (int j = 0; j < hol; j++) {
					reader.readLine();
				}
				rating[i] = hol;
				if (rating[i] > maxR) {
					maxR = rating[i];
					index = i;
				} else if (rating[i] == maxR) {
					if (price[i] < price[index]) {
						index = i;
					}
				}
			}
			System.out.println("RFP #" + temp);
			System.out.println(names[index]);

			temp++;

		}

	}
}
