import java.util.*;

public class UVA10855 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();
			int n = sc.nextInt();

			if (N == 0 && n == 0) {
				break;
			}

			char[][] big = new char[N][N];
			char[][] small = new char[n][n];
			sc.nextLine();
			for (int i = 0; i < N; i++) {
				String temp = sc.nextLine();
				for (int ii = 0; ii < N; ii++) {
					big[i][ii] = temp.charAt(ii);
				}
			}

			for (int i = 0; i < n; i++) {
				String temp = sc.nextLine();
				for (int ii = 0; ii < n; ii++) {
					small[i][ii] = temp.charAt(ii);
				}
			}

			for (int v = 0; v < 4; v++) {
				int counter = 0;
				for (int i = 0; i <= N - n; i++) {
					for (int ii = 0; ii <= N - n; ii++) {
						boolean valid = true;
						for (int iii = 0; iii < n; iii++) {
							for (int iiii = 0; iiii < n; iiii++) {
								if (small[iii][iiii] != big[iii + i][iiii + ii]) {
									valid = false;
									break;
								}
							}
						}
						if (valid) {
							counter++;
						}

					}
				}
				if (v == 3) {
					System.out.print(counter);
				} else {
					System.out.print(counter + " ");
				}
				small = rotate(small);
			}
			System.out.println();
		}

	}

	public static char[][] rotate(char[][] input) {
		char[][] out = new char[input.length][input.length];
		for (int i = 0; i < input.length; i++) {
			for (int ii = 0; ii < input.length; ii++) {
				out[ii][input.length - 1 - i] = input[i][ii];
			}
		}
		return out;

	}

}
