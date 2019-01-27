import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA12356 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] one = reader.readLine().split(" ");
			int S = Integer.parseInt(one[0]);
			int report = Integer.parseInt(one[1]);
			if (S == 0 && report == 0) {
				break;
			}
			boolean[] dead = new boolean[S];

			for (int p = 0; p < report; p++) {
				one = reader.readLine().split(" ");
				int L = Integer.parseInt(one[0]);
				int R = Integer.parseInt(one[1]);
				for (int i = L - 1; i < R; i++) {
					dead[i] = true;
				}
				int counter1 = L - 1;
				while (counter1 >= 0) {
					if (!dead[counter1]) {
						break;
					} else {
						counter1--;
					}
				}

				int counter2 = R;
				while (counter2 < S) {
					if (!dead[counter2]) {
						break;
					} else {
						counter2++;
					}
				}
				if (counter1 < 0 && counter2 >= S) {
					System.out.println("* *");
				} else if (counter1 < 0) {
					System.out.println("* " + (counter2 + 1));
				} else if (counter2 >= S) {
					System.out.println((counter1 + 1) + " *");
				} else {
					System.out.println((counter1 + 1) + " " + (counter2 + 1));
				}
			}
			System.out.println("-");

		}

	}

}
