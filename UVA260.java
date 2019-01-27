import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class UVA260 {
	public static pair[][] input;
	// public static boolean[][] visit;
	public static Stack<pair> stack;
	public static boolean foundBlack;
	public static int N;

	public static class pair {
		int row, col, value;
		boolean visit;

		public pair(int r, int c, int n, boolean v) {
			row = r;
			col = c;
			visit = v;
			value = n;
		}
	}

	public static void dfs() {
		while (!stack.isEmpty()) {
			pair p = stack.pop();
			input[p.row][p.col].visit = true;
			if (p.row == N - 1) {
				foundBlack = true;
				return;
			}
			if (p.row - 1 >= 0) {
				if (p.col - 1 >= 0) {
					if (!input[p.row - 1][p.col - 1].visit && input[p.row - 1][p.col - 1].value == 1) {
						stack.push(input[p.row - 1][p.col - 1]);
					}
					if (!input[p.row][p.col - 1].visit && input[p.row][p.col - 1].value == 1) {
						stack.push(input[p.row][p.col - 1]);
					}
				}
				if (!input[p.row - 1][p.col].visit && input[p.row - 1][p.col].value == 1) {
					stack.push(input[p.row - 1][p.col]);
				}
			} else if (p.col - 1 >= 0) {
				if (!input[p.row][p.col - 1].visit && input[p.row][p.col - 1].value == 1) {
					stack.push(input[p.row][p.col - 1]);
				}
			}

			if (p.row + 1 < N) {
				if (p.col + 1 < N) {
					if (!input[p.row + 1][p.col + 1].visit && input[p.row + 1][p.col + 1].value == 1) {
						stack.push(input[p.row + 1][p.col + 1]);
					}
					if (!input[p.row][p.col + 1].visit && input[p.row][p.col + 1].value == 1) {
						stack.push(input[p.row][p.col + 1]);
					}
				}
				if (!input[p.row + 1][p.col].visit && input[p.row + 1][p.col].value == 1) {
					stack.push(input[p.row + 1][p.col]);
				}
			} else if (p.col + 1 < N) {
				if (!input[p.row][p.col + 1].visit && input[p.row][p.col + 1].value == 1) {
					stack.push(input[p.row][p.col + 1]);
				}
			}
			// finish adding adj

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int counter = 1;
		while (true) {
			N = sc.nextInt();
			sc.nextLine();
			if (N == 0)
				break;

			input = new pair[N][N];
			// visit = new boolean[N][N];
			stack = new Stack<>();
			foundBlack = false;
			for (int i = 0; i < N; i++) {
				String temp = sc.nextLine();
				for (int ii = 0; ii < N; ii++) {
					if (temp.charAt(ii) == 'w') {
						input[i][ii] = new pair(i, ii, 0, false);
					} else {
						input[i][ii] = new pair(i, ii, 1, false);
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if (input[0][i].value == 1) {
					stack.push(input[0][i]);
				}
			}
			dfs();
			if (foundBlack) {
				System.out.println(counter + " B");
			} else {
				System.out.println(counter + " W");
			}
			counter++;

		}
	}
}
/*
 * 4 bbwb wwbw bbwb bwww 4 bbwb wwbw bwwb wwbb 0
 */