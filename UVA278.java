import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA278 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		// rook goes like a cross
		// queen goes like a spider :)

		int[] kr = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] kc = { -1, 1, -2, 2, -2, 2, -1, 1 };

		int[] Kr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] Kc = { -1, 1, 0, 1, -1, -1, 1, 0 };

		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			String hol = reader.readLine();
			while (hol.isEmpty()) {
				hol = reader.readLine();
			}
			String[] line = hol.split(" ");
			int r = Integer.parseInt(line[1]);
			int c = Integer.parseInt(line[2]);
			boolean[][] map = new boolean[r][c];
			int counter = 0;
			if (line[0].equals("r")) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (!map[i][j]) {
							map[i][j] = true;
							// up
							int tempR = i;
							int tempC = j - 1;
							while (tempC >= 0) {
								map[tempR][tempC] = true;
								tempC--;
							}

							// down
							tempR = i;
							tempC = j + 1;
							while (tempC < c) {
								map[tempR][tempC] = true;
								tempC++;
							}
							// left
							tempR = i - 1;
							tempC = j;
							while (tempR >= 0) {
								map[tempR][tempC] = true;
								tempR--;
							}
							// right
							tempR = i + 1;
							tempC = j;
							while (tempR < r) {
								map[tempR][tempC] = true;
								tempR++;
							}
							counter++;
						}
					}
				}
			} else if (line[0].equals("k")) {
				double estimate = r * (c / 2.0);
				int ans = (int) Math.round(estimate);
				counter = ans;

			} else if (line[0].equals("Q")) {
				counter = Math.min(r, c);
			} else if (line[0].equals("K")) {
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						if (!map[i][j]) {
							map[i][j] = true;

							for (int a = 0; a < 8; a++) {
								int tempR = i + Kr[a];
								int tempC = j + Kc[a];
								if (valid(tempR, tempC, r, c)) {
									map[tempR][tempC] = true;
								}
							}
							counter++;
						}
					}
				}
			}
			System.out.println(counter);

		}

	}

	public static boolean valid(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
