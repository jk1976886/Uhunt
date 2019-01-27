import java.util.Scanner;

public class UVA696 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r == 0 && c == 0) {
				break;
			}
			double hol = r * (c / 2.0);
			int ans = (int) Math.round(hol);
			if (r == 0 || c == 0) {
				ans = 0;
			} else if (r == 1 || c == 1) {
				ans = Math.max(r, c);
			} else if (r == 2 || c == 2) {
				// brute force
				boolean[][] map = new boolean[Math.max(r, c)][2];
				int[] kr = { -2, -2, -1, -1, 1, 1, 2, 2 };
				int[] kc = { -1, 1, -2, 2, -2, 2, -1, 1 };
				int counter = 0;
				for (int i = 0; i < map.length; i++) {
					for (int j = 0; j < 2; j++) {
						if (!map[i][j]) {
							map[i][j] = true;
							// System.out.println(i + " " + j);
							for (int a = 0; a < 8; a++) {
								int tempR = i + kr[a];
								int tempC = j + kc[a];
								if (valid(tempR, tempC, map.length, 2)) {
									map[tempR][tempC] = true;
								}
							}
							counter++;
						}
					}
				}
				ans = counter;
			}

			System.out.printf("%d knights may be placed on a %d row %d column board.\n", ans, r, c);

		}

	}

	public static boolean valid(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}

}
