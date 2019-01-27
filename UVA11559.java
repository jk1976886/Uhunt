import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA11559 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (reader.ready()) {
			String[] line = reader.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int budget = Integer.parseInt(line[1]);

			int hotel = Integer.parseInt(line[2]);
			int week = Integer.parseInt(line[3]);

			int[] price = new int[hotel];
			int[][] hw = new int[hotel][week];

			for (int i = 0; i < hotel; i++) {
				price[i] = Integer.parseInt(reader.readLine().split(" ")[0]);
				String[] l = reader.readLine().split(" ");
				int counter = 0;
				for (String s : l) {
					hw[i][counter] = Integer.parseInt(s);
					counter++;
				}
			}
			int min = budget + 1;
			for (int i = 0; i < hotel; i++) {
				for (int j = 0; j < week; j++) {
					if (hw[i][j] >= N) {
						int cost = N * price[i];
						if (cost < min) {
							min = cost;
						}
					}
				}
			}
			if (min <= budget) {
				System.out.println(min);
			} else {
				System.out.println("stay home");
			}

		}

	}
}
