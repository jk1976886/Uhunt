import java.util.Scanner;

public class UVA11831 {
	public static int[][] map;
	// 0 is normal
	// 1 is sticker
	// 2 is pillar
	// 3 is robot

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int S = sc.nextInt();

			if (N == 0 && M == 0 && S == 0) {
				break;
			}

			map = new int[N][M];
			sc.nextLine();
			int xPos = 0;
			int yPos = 0;
			char face = 'd';

			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < M; j++) {
					if (line.charAt(j) == '.') {
						// normal
						map[i][j] = 0;
					} else if (line.charAt(j) == '*') {
						// sticker
						map[i][j] = 1;
					} else if (line.charAt(j) == '#') {
						// pillar
						map[i][j] = 2;
					} else {
						map[i][j] = 3;
						xPos = i;
						yPos = j;
						if (line.charAt(j) == 'N') {
							face = 'N';
						} else if (line.charAt(j) == 'S') {
							face = 'S';
						} else if (line.charAt(j) == 'L') {
							face = 'E';
						} else if (line.charAt(j) == 'O') {
							face = 'W';
						}
					}
				}
			}

			String instruction = sc.nextLine();
			// input finished
			int sticker = 0;
			for (int i = 0; i < S; i++) {
				if (instruction.charAt(i) == 'D') {
					// 90 to the right
					if (face == 'N') {
						face = 'E';
					} else if (face == 'S') {
						face = 'W';
					} else if (face == 'E') {
						face = 'S';
					} else if (face == 'W') {
						face = 'N';
					}
				} else if (instruction.charAt(i) == 'E') {
					// 90 to the left
					if (face == 'N') {
						face = 'W';
					} else if (face == 'S') {
						face = 'E';
					} else if (face == 'E') {
						face = 'N';
					} else if (face == 'W') {
						face = 'S';
					}
				} else if (instruction.charAt(i) == 'F') {
					// forward

					map[xPos][yPos] = 0;

					if (face == 'N' && valid(xPos - 1, yPos)) {
						xPos--;
					} else if (face == 'S' && valid(xPos + 1, yPos)) {
						xPos++;
					} else if (face == 'E' && valid(xPos, yPos + 1)) {
						yPos++;
					} else if (face == 'W' && valid(xPos, yPos - 1)) {
						yPos--;
					}

					if (map[xPos][yPos] == 1) {
						map[xPos][yPos] = 0;
						sticker++;
					}

					map[xPos][yPos] = 3;
				}
			}
			System.out.println(sticker);

		}

	}

	public static boolean valid(int x, int y) {
		return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != 2;
	}
}
