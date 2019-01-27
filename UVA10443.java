import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10443 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			String[] line = reader.readLine().split(" ");
			if (p > 0) {
				System.out.println();
			}

			int r = Integer.parseInt(line[0]);
			int c = Integer.parseInt(line[1]);
			int day = Integer.parseInt(line[2]);

			char[][] graph = new char[r][c];

			for (int i = 0; i < r; i++) {
				String l = reader.readLine();
				for (int j = 0; j < c; j++) {
					graph[i][j] = l.charAt(j);
				}
			}
			char[][] tmr = new char[r][c];
			for (int d = 0; d < day; d++) {

				for (int i = r - 1; i >= 0; i--) {
					for (int j = c - 1; j >= 0; j--) {
						boolean fight = false;
						int tempR = i;
						int tempC = j + 1;
						char change = graph[i][j];
						if (valid(tempR, tempC, r, c) && graph[i][j] != graph[tempR][tempC]) {
							if (graph[i][j] == 'R') {
								if (graph[tempR][tempC] == 'P') {
									change = 'P';
									fight = true;
								} else if (graph[tempR][tempC] == 'S') {
									tmr[tempR][tempC] = 'R';
									fight = true;
								}
							} else if (graph[i][j] == 'P') {
								if (graph[tempR][tempC] == 'R') {
									tmr[tempR][tempC] = 'P';
									fight = true;
								} else if (graph[tempR][tempC] == 'S') {
									change = 'S';
									fight = true;
								}
							} else if (graph[i][j] == 'S') {
								if (graph[tempR][tempC] == 'R') {
									change = 'R';
									fight = true;
								} else if (graph[tempR][tempC] == 'P') {
									tmr[tempR][tempC] = 'S';
									fight = true;
								}
							}
						}

						tempR = i + 1;
						tempC = j;
						if (valid(tempR, tempC, r, c) && graph[i][j] != graph[tempR][tempC]) {
							if (graph[i][j] == 'R') {
								if (graph[tempR][tempC] == 'P') {
									change = 'P';
									fight = true;
								} else if (graph[tempR][tempC] == 'S') {
									tmr[tempR][tempC] = 'R';
									fight = true;
								}
							} else if (graph[i][j] == 'P') {
								if (graph[tempR][tempC] == 'R') {
									tmr[tempR][tempC] = 'P';
									fight = true;
								} else if (graph[tempR][tempC] == 'S') {
									change = 'S';
									fight = true;
								}
							} else if (graph[i][j] == 'S') {
								if (graph[tempR][tempC] == 'R') {
									change = 'R';
									fight = true;
								} else if (graph[tempR][tempC] == 'P') {
									tmr[tempR][tempC] = 'S';
									fight = true;
								}
							}
						}
						tmr[i][j] = change;
					}
				}
				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						graph[i][j] = tmr[i][j];
					}
				}

			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					System.out.print(graph[i][j]);
				}
				System.out.println();
			}
		}

	}

	public static void debug(char[][] g) {
		for (int i = 0; i < g.length; i++) {
			for (int ii = 0; ii < g[i].length; ii++) {
				System.out.print(g[i][ii] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static boolean valid(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
