import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10284 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int[] kr = { -2, -2, -1, -1, 1, 1, 2, 2 };
		int[] kc = { -1, 1, -2, 2, -2, 2, -1, 1 };

		int[] Kr = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] Kc = { -1, 1, 0, 1, -1, -1, 1, 0 };
		while (reader.ready()) {
			String[] line = reader.readLine().split("/");
			boolean[][] board = new boolean[8][8];
			int[][] b = new int[8][8];
			for (int i = 0; i < 8; i++) {
				int k = 0;
				for (int j = 0; j < line[i].length(); j++) {
					char c = Character.toLowerCase(line[i].charAt(j));

					if (c == 'p') {
						b[i][k] = 1;
						k++;
					} else if (c == 'n') {
						b[i][k] = 1;
						k++;
					} else if (c == 'b') {
						b[i][k] = 1;
						k++;
					} else if (c == 'r') {
						b[i][k] = 1;
						k++;
					} else if (c == 'q') {
						b[i][k] = 1;
						k++;
					} else if (c == 'k') {
						b[i][k] = 1;
						k++;
					} else {
						int hol = Integer.parseInt(Character.toString(c));
						for (int a = 0; a < hol; a++) {
							b[i][k] = 0;
							k++;
						}
					}

				}
			}

			for (int i = 0; i < 8; i++) {
				// line[i] = line[i].toLowerCase();
				int k = 0;
				for (int j = 0; j < line[i].length(); j++) {
					char c = line[i].charAt(j);
					if (c == 'P') {
						// white pawn
						board[i][k] = true;
						// if (valid(i - 1, k, 8, 8)) {
						// board[i - 1][k] = true;
						// }
						if (valid(i - 1, k - 1, 8, 8)) {
							board[i - 1][k - 1] = true;
						}
						if (valid(i - 1, k + 1, 8, 8)) {
							board[i - 1][k + 1] = true;
						}
					} else if (c == 'p') {
						// black pawn
						board[i][k] = true;
						// if (valid(i + 1, k, 8, 8)) {
						// board[i + 1][k] = true;
						// }
						if (valid(i + 1, k - 1, 8, 8)) {
							board[i + 1][k - 1] = true;
						}
						if (valid(i + 1, k + 1, 8, 8)) {
							board[i + 1][k + 1] = true;
						}
					} else {
						c = Character.toLowerCase(c);
						if (c == 'n') {
							// knight
							board[i][k] = true;
							for (int a = 0; a < 8; a++) {
								int tempR = i + kr[a];
								int tempC = k + kc[a];
								if (valid(tempR, tempC, 8, 8)) {

									board[tempR][tempC] = true;
								}
							}

						} else if (c == 'b') {
							// bishop
							board[i][k] = true;

							int tempR = i;
							int tempC = k;

							while (true) {
								tempR--;
								tempC--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

							tempR = i;
							tempC = k;

							while (true) {
								tempR--;
								tempC++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

							tempR = i;
							tempC = k;

							while (true) {
								tempR++;
								tempC--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

							tempR = i;
							tempC = k;

							while (true) {
								tempR++;
								tempC++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

						} else if (c == 'r') {
							// rook
							board[i][k] = true;

							// board[i][k] = true;

							int tempR = i;
							int tempC = k;

							while (true) {
								tempR++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempR--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempC++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempC--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
						} else if (c == 'q') {
							// queen
							board[i][k] = true;

							int tempR = i;
							int tempC = k;

							while (true) {
								tempR++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempR--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempC++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempC--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
							tempR = i;
							tempC = k;

							while (true) {
								tempR--;
								tempC--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

							tempR = i;
							tempC = k;

							while (true) {
								tempR--;
								tempC++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

							tempR = i;
							tempC = k;

							while (true) {
								tempR++;
								tempC--;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}

							tempR = i;
							tempC = k;

							while (true) {
								tempR++;
								tempC++;
								if (valid(tempR, tempC, 8, 8)) {
									if (b[tempR][tempC] == 1) {
										break;
									}
									board[tempR][tempC] = true;

								} else {
									break;
								}
							}
						} else if (c == 'k') {
							// king
							board[i][k] = true;

							for (int a = 0; a < 8; a++) {
								int tempR = i + Kr[a];
								int tempC = k + Kc[a];
								if (valid(tempR, tempC, 8, 8)) {
									board[tempR][tempC] = true;
								}
							}
						} else {
							k += Integer.parseInt(Character.toString(c)) - 1;
						}

					}
					k++;
				}
			}
			int counter = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (!board[i][j]) {
						counter++;

					}
					// System.out.print(board[i][j] + " ");
				}
				// System.out.println();
			}
			// System.out.println();
			System.out.println(counter);

		}

	}

	public static boolean valid(int r, int c, int R, int C) {
		return r >= 0 && c >= 0 && r < R && c < C;
	}
}
