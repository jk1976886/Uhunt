import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA584 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] line = reader.readLine().split(" ");
			if (line[0].equals("Game")) {
				break;
			}
			int[] score = new int[22];
			boolean[] strike = new boolean[12];
			boolean[] spade = new boolean[12];
			int index = 0;
			int last = 0;
			// 0 is normal, 1 is spade, 2 is strike

			for (int i = 0; i < line.length; i++) {
				String a = line[i];
				if (a.equals("X") && index < 20) {
					// strike
					score[index] = 10;
					if (index == 18) {
						last = 2;
					}
					strike[(index + 1) / 2] = true;
				} else if (index > 19) {
					// extra
					if (last == 1) {
						if (a.equals("X")) {
							score[index] = 10;
						} else {
							score[index] = Integer.parseInt(a);
						}
					} else if (last == 2) {
						i++;
						String b = line[i];
						if (a.equals("X")) {
							if (b.equals("X")) {
								score[index] = 10;
								score[index + 1] = 10;
							} else {
								score[index] = 10;
								score[index + 1] = Integer.parseInt(b);
							}
						} else {
							score[index] = Integer.parseInt(a);
							if (b.equals("/")) {
								score[index + 1] = 10 - score[index];
							} else {
								score[index + 1] = Integer.parseInt(b);
							}
						}
					}

				} else {
					i++;
					String b = line[i];
					if (b.equals("/")) {
						// spade
						int A = Integer.parseInt(a);
						score[index] = A;
						score[index + 1] = 10 - A;
						if (index == 18) {
							last = 1;
						}
						spade[(index + 1) / 2] = true;
					} else {
						int A = Integer.parseInt(a);
						int B = Integer.parseInt(b);
						score[index] = A;
						score[index + 1] = B;
					}
				}

				index += 2;
			}
			int sum = 0;
			for (int i = 0; i < 20; i++) {
				if (strike[(i + 1) / 2]) {
					sum += 10;
					i++;
					if (strike[(i + 2) / 2]) {
						sum += 10 + score[i + 3];
					} else {
						sum += score[i + 1] + score[i + 2];
					}
				} else if (spade[(i + 1) / 2]) {
					sum += 10;
					i++;
					sum += score[i + 1];
				} else {
					sum += score[i];
					i++;
					sum += score[i];

				}

			}

			// for (int i : score) {
			// System.out.print(i + " ");
			// }
			// System.out.println();
			System.out.println(sum);

		}

	}
}
