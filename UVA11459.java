import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class UVA11459 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());
		for (int p = 0; p < test; p++) {

			String[] firstLine = reader.readLine().split(" ");

			int player = Integer.parseInt(firstLine[0]);
			int SN = Integer.parseInt(firstLine[1]);
			int roll = Integer.parseInt(firstLine[2]);

			Map<Integer, Integer> SnakeLadd = new HashMap<>();
			int[] pos = new int[player];

			for (int i = 0; i < SN; i++) {
				String[] temp = reader.readLine().split(" ");
				SnakeLadd.put(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
			}

			boolean win = false;
			int dieCunt = 0;
			for (int i = 0; i < player; i++) {
				pos[i] = 1;
			}
			while (dieCunt < roll) {

				for (int a = 0; a < player; a++) {
					int die = Integer.parseInt(reader.readLine());
					if (!win) {
						pos[a] += die;
						if (SnakeLadd.containsKey(pos[a])) {
							pos[a] = SnakeLadd.get(pos[a]);
						}
						if (pos[a] >= 100) {
							win = true;
						}
					}
					dieCunt++;
				}
			}

			for (int i = 0; i < player; i++) {
				System.out.printf("Position of player %d is %d.\n", (i + 1), pos[i]);
			}

		}

	}
}
