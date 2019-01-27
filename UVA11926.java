import java.util.*;

public class UVA11926 {
	public static int[] time;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean valid = true;

			if (n == 0 && m == 0) {
				break;
			}

			time = new int[1000000];
			for (int i = 0; i < 1000000; i++) {
				time[i] = 0;
			}

			for (int i = 0; i < n; i++) {
				int beg = sc.nextInt();
				int end = sc.nextInt();
				// System.out.println(beg + " : " + end);
				if (single(beg, end)) {
					valid = false;
				}

			}
			for (int i = 0; i < m; i++) {
				int beg = sc.nextInt();
				int end = sc.nextInt();
				int rep = sc.nextInt();

				if (repeat(beg, end, rep)) {
					valid = false;
				}

			}

			if (valid) {
				System.out.println("NO CONFLICT");
			} else {
				System.out.println("CONFLICT");
			}
		}

	}

	public static boolean single(int beg, int end) {

		for (int i = beg; i < end; i++) {

			if (time[i] != 0) {
				// System.out.println("afsjhdl");
				return true;
			} else {
				time[i]++;
				// System.out.println(i + " : " + time[i]);
			}
		}
		return false;
	}

	public static boolean repeat(int beg, int end, int rep) {
		int counter = 1;
		while (true) {

			if (beg < 1000000) {
				if (end < 1000000) {
					for (int i = beg; i < end; i++) {
						if (time[i] == 0) {
							time[i]++;
						} else {
							return true;
						}
					}
				} else {
					for (int i = beg; i < 1000000; i++) {
						if (time[i] == 0) {
							time[i]++;
						} else {
							return true;
						}
					}
				}
			} else {
				break;
			}

			beg = beg + rep * counter;
			end = end + rep * counter;

		}

		return false;
	}

}
