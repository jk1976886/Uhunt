import java.util.Scanner;

public class UVA10258 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		sc.nextLine();
		sc.nextLine();
		for (int p = 0; p < T; p++) {
			boolean[] ppl = new boolean[101];
			boolean[][] prob = new boolean[101][10];
			int[][] incorrect = new int[101][10];
			int peopleCunt = 0;

			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if (line.equals("")) {
					break;
				}
				String[] items = line.split(" ");

				int contestant = Integer.parseInt(items[0]);
				int problem = Integer.parseInt(items[1]);
				int time = Integer.parseInt(items[2]);
				String type = items[3];

				if (!ppl[contestant]) {
					ppl[contestant] = true;
					peopleCunt++;
				}
				if (type.equals("C") && !prob[contestant][problem]) {
					prob[contestant][problem] = true;
					incorrect[contestant][problem] *= 20;
					incorrect[contestant][problem] += time;
				} else if (type.equals("I") && !prob[contestant][problem]) {
					incorrect[contestant][problem]++;
				}

			}
			int[] totalTime = new int[101];

			int[] correct = new int[101];

			for (int i = 1; i <= 100; i++) {
				int time = 0;
				int counter = 0;
				for (int ii = 1; ii <= 9; ii++) {
					if (prob[i][ii]) {
						time += incorrect[i][ii];
						counter++;
					}
				}
				totalTime[i] = time;
				correct[i] = counter;
			}

			for (int j = 0; j < peopleCunt; j++) {
				int max = 0;
				int cur = 0;
				for (int i = 1; i <= 100; i++) {
					if (ppl[i] && correct[i] > max) {
						max = correct[i];
						cur = i;
					} else if (ppl[i] && correct[i] == max) {
						if (totalTime[i] < totalTime[cur]) {
							cur = i;
						} else if (totalTime[i] == totalTime[cur]) {
							if (cur > i) {
								cur = i;
							}
						}

					}
				}
				if (correct[cur] == 0) {
					break;
				}
				ppl[cur] = false;
				System.out.printf("%d %d %d\n", cur, correct[cur], totalTime[cur]);
			}

			for (int i = 1; i <= 100; i++) {
				if (ppl[i]) {
					System.out.printf("%d %d %d\n", i, correct[i], totalTime[i]);
				}
			}
			if (p != T - 1) {
				System.out.println();
			}
		}

	}

}
