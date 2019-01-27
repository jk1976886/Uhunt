import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA10976 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (reader.ready()) {
			int k = Integer.parseInt(reader.readLine());

			ArrayList<Integer> X = new ArrayList<>();
			ArrayList<Integer> Y = new ArrayList<>();

			int curX = k + 1;
			int curY = 0;

			while (true) {
				curY = (int) (k * curX / ((curX - k) * 1.0));
				// System.out.println(curX + " " + curY);
				if (curX > 2 * k) {
					break;
				}
				if (k * (curX + curY) == curX * curY) {
					X.add(curX);
					Y.add(curY);

				}
				curX++;

			}

			System.out.println(X.size());

			for (int i = 0; i < X.size(); i++) {
				System.out.printf("1/%d = 1/%d + 1/%d\n", k, Y.get(i), X.get(i));
			}

		}
	}
}
