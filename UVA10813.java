import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class UVA10813 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		for (int p = 0; p < test; p++) {
			Set<Integer> have = new HashSet<>();
			int[][] num = new int[5][5];
			boolean[][] check = new boolean[5][5];
			check[2][2] = true;

			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {

					num[i][j] = sc.nextInt();
					have.add(num[i][j]);

					if (i == 2 && j == 1) {
						j++;
					}
				}
			}

			Queue<Integer> q = new LinkedList<>();

			for (int i = 0; i < 75; i++) {
				q.add(sc.nextInt());
			}

			for (int a = 0; a < 75; a++) {
				int cur = q.poll();
				if (have.contains(cur)) {
					boolean done = false;
					for (int i = 0; i < 5 && !done; i++) {
						for (int j = 0; j < 5 && !done; j++) {
							if (num[i][j] == cur) {
								check[i][j] = true;
								done = true;
								break;
							}
						}
					}

					// check if win
					boolean win = false;
					// row
					for (int i = 0; i < 5 && !win; i++) {
						boolean w = true;
						for (int j = 0; j < 5; j++) {
							if (!check[i][j]) {
								w = false;
								break;
							}
						}
						if (w) {
							win = true;
							break;
						}
					}
					// col
					for (int i = 0; i < 5 && !win; i++) {
						boolean w = true;
						for (int j = 0; j < 5; j++) {
							if (!check[j][i]) {
								w = false;
								break;
							}
						}
						if (w) {
							win = true;
							break;
						}
					}
					// diagnol
					boolean w = true;
					for (int i = 0; i < 5; i++) {
						if (!check[i][i]) {
							w = false;
							break;
						}
					}
					if (w) {
						win = true;
					}

					w = true;
					for (int i = 0; i < 5; i++) {
						if (!check[i][4 - i]) {
							w = false;
							break;
						}
					}
					if (w) {
						win = true;
					}

					if (win) {
						System.out.println("BINGO after " + (a + 1) + " numbers announced");
						break;
					}

				}
			}

		}

	}
}
