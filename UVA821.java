import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UVA821 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int ca = 1;
		while (true) {
			String[] line = reader.readLine().split(" ");
			int[] input = new int[line.length];
			int counter = 0;
			for (String s : line) {
				input[counter] = Integer.parseInt(s);
				counter++;
			}
			if (input[0] == 0 && input[1] == 0) {
				break;
			}
			Map<Integer, ArrayList<Integer>> map = new HashMap<>();
			Set<Integer> key = new HashSet<>();
			int[][] dist = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			for (int i = 0; i < input.length; i++) {
				int a = input[i] - 1;
				i++;
				int b = input[i] - 1;
				if (a == -1 && b == -1) {
					break;
				}

				key.add(a);
				key.add(b);
				dist[a][b] = 1;
			}
			// floyd warshall: a is between b to c

			for (int a = 0; a < 100; a++) {
				for (int b = 0; b < 100; b++) {
					for (int c = 0; c < 100; c++) {
						if (dist[b][a] != Integer.MAX_VALUE && dist[a][c] != Integer.MAX_VALUE
								&& dist[b][c] > dist[b][a] + dist[a][c]) {
							dist[b][c] = dist[b][a] + dist[a][c];
						}
					}
				}
			}
			int sum = 0;

			for (int a = 0; a < 100; a++) {
				for (int b = 0; b < 100; b++) {
					if (dist[a][b] != Integer.MAX_VALUE && a != b) {
						sum += dist[a][b];
					}
				}
			}

			double answer = sum / (1.0 * key.size() * (key.size() - 1));
			System.out.printf("Case %d: average length between pages = %.3f clicks\n", ca, answer);
			ca++;
		}

	}
}
