import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVA11242 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] line = reader.readLine().split(" ");
			int f = Integer.parseInt(line[0]);
			if (f == 0) {
				break;
			}

			int r = Integer.parseInt(line[1]);

			int[] front = new int[f];
			int[] rear = new int[r];

			line = reader.readLine().split(" ");
			for (int i = 0; i < f; i++) {
				front[i] = Integer.parseInt(line[i]);
			}

			line = reader.readLine().split(" ");
			for (int i = 0; i < r; i++) {
				rear[i] = Integer.parseInt(line[i]);
			}

			ArrayList<Double> d = new ArrayList<>();

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < f; j++) {
					d.add(rear[i] / (front[j] * 1.0));
				}
			}

			Collections.sort(d);

			double max = 0;

			for (int i = 0; i < d.size() - 1; i++) {
				double temp = d.get(i + 1) / d.get(i);
				if (temp > max) {
					max = temp;
				}
			}

			System.out.printf("%.2f\n", max);
		}

	}
}
