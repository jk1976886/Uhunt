import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UVA1056 {
	public static void main(String[] args) throws Exception {
		// BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		int caseCunt = 1;
		while (true) {
			if (caseCunt > 1) {
				System.out.println();
			}
			int P = sc.nextInt();
			int R = sc.nextInt();
			if (P == 0 && R == 0) {
				break;
			}

			int[][] map = new int[P][P];
			for (int i = 0; i < P; i++) {
				for (int j = 0; j < P; j++) {
					map[i][j] = P;
				}
			}
			HashSet<String> names = new HashSet<>();
			HashMap<String, Integer> nameToint = new HashMap<>();

			int counter = 0;
			for (int i = 0; i < R; i++) {
				String first = sc.next();
				String second = sc.next();
				if (!names.contains(first)) {
					names.add(first);
					nameToint.put(first, counter);
					counter++;
				}
				if (!names.contains(second)) {
					names.add(second);
					nameToint.put(second, counter);
					counter++;
				}

				map[nameToint.get(first)][nameToint.get(second)] = 1;
				map[nameToint.get(second)][nameToint.get(first)] = 1;
			}

			for (int i = 0; i < P; i++) {
				for (int j = 0; j < P; j++) {
					for (int k = 0; k < P; k++) {
						if (map[j][k] > map[j][i] + map[i][k]) {
							map[j][k] = map[j][i] + map[i][k];
						}
					}
				}
			}

			int max = 0;
			for (int i = 0; i < P; i++) {
				for (int j = 0; j < P; j++) {
					if (i != j && map[i][j] > max) {
						max = map[i][j];
					}
				}
			}
			if (max >= P) {
				System.out.println("Network " + caseCunt + ": DISCONNECTED");
			} else {
				System.out.println("Network " + caseCunt + ": " + max);
			}
			caseCunt++;
		}

	}
}
