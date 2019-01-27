import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA573 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] line = reader.readLine().split(" ");

			int h = Integer.parseInt(line[0]);
			int u = Integer.parseInt(line[1]);
			int d = Integer.parseInt(line[2]);
			int f = Integer.parseInt(line[3]);
			if (h == 0) {
				break;
			}

			double curHeight = 0;
			double decrement = u * (f / 100.0);
			double curClimb = u;
			int day = 1;

			boolean done = false;
			while (true) {
				if (curClimb > 0) {
					curHeight += curClimb;
					curClimb -= decrement;
				}
				if (curHeight > h) {
					done = true;
					break;
				}

				curHeight -= d;

				if (curHeight < 0) {
					break;
				}
				day++;
			}

			if (done) {
				System.out.println("success on day " + day);
			} else {
				System.out.println("failure on day " + day);
			}

		}

	}
}
