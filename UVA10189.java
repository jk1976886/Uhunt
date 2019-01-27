import java.util.Scanner;

public class UVA10189 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = 1;
		while (true) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			if (r == 0 && c == 0) {
				break;
			}
			if (p > 1) {

				System.out.println();
			}
			char[][] orig = new char[r][c];
			sc.nextLine();
			for (int i = 0; i < r; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < c; j++) {
					orig[i][j] = line.charAt(j);
				}
			}

			int[][] ans = new int[r][c];
			int[] dr = { 0, 0, -1, -1, -1, 1, 1, 1 };
			int[] dc = { 1, -1, 0, 1, -1, 0, 1, -1 };

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					int counter = 0;
					for (int a = 0; a < 8; a++) {
						int tempR = i + dr[a];
						int tempC = j + dc[a];
						if (valid(tempR, tempC, r, c) && orig[tempR][tempC] == '*') {
							counter++;
						}
					}
					ans[i][j] = counter;
				}
			}
			System.out.println("Field #" + p + ":");
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (orig[i][j] == '*') {
						System.out.print("*");
					} else {
						System.out.print(ans[i][j]);
					}
				}
				System.out.println();
			}
			p++;
		}

	}

	public static boolean valid(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
