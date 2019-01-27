import java.util.*;

public class UVA10920 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int size = sc.nextInt();
			long p = sc.nextLong();

			if (size == 0 && p == 0) {
				break;
			}

			if (Math.sqrt(p) == size) {
				System.out.println("Line = " + size + ", column = " + size + ".");
			} else {
				int r = size / 2;
				int c = size / 2;
				boolean found = false;
				int foundR = 0;
				int foundC = 0;
				for (int i = 1; i <= size / 2 + 1 && !found; i++) {
					long temp = (long) ((2 * i - 1) * (2 * i - 1));
					long temp2 = (long) (2 * i - 2);
					int tempR = r;
					int tempC = c;

					if (temp < p) {
						r--;
						c++;
					} else {
						if (temp == p) {
							found = true;
							foundR = tempR;
							foundC = tempC;
							break;
						}

						for (int ii = 1; ii <= temp2 && !found; ii++) {

							tempR++;
							temp--;
							if (temp == p) {
								found = true;
								foundR = tempR;
								foundC = tempC;
								break;
							}
						}

						for (int ii = 1; ii <= temp2 && !found; ii++) {

							tempC--;
							temp--;
							if (temp == p) {
								found = true;
								foundR = tempR;
								foundC = tempC;
								break;
							}
						}

						for (int ii = 1; ii <= temp2 && !found; ii++) {
							tempR--;
							temp--;
							if (temp == p) {
								found = true;
								foundR = tempR;
								foundC = tempC;
								break;
							}
						}

						for (int ii = 1; ii <= temp2 - 1 && !found; ii++) {
							tempC++;
							temp--;
							if (temp == p) {
								found = true;
								foundR = tempR;
								foundC = tempC;
								break;
							}
						}
						r--;
						c++;

					}

				}
				System.out.println("Line = " + (size - foundR) + ", column = " + (foundC + 1) + ".");
			}

		}

	}

}
