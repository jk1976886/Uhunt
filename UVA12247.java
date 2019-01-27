import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UVA12247 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] line = reader.readLine().split(" ");
			if (line[0].equals("0")) {
				break;
			}
			boolean[] used = new boolean[53];

			ArrayList<Integer> princess = new ArrayList<>();
			princess.add(Integer.parseInt(line[0]));
			princess.add(Integer.parseInt(line[1]));
			princess.add(Integer.parseInt(line[2]));

			ArrayList<Integer> prince = new ArrayList<>();
			prince.add(Integer.parseInt(line[3]));
			prince.add(Integer.parseInt(line[4]));

			for (int i : princess) {
				used[i] = true;
			}
			for (int i : prince) {
				used[i] = true;
			}

			Set<Integer> cancel = new HashSet<>();

			Collections.sort(princess, Collections.reverseOrder());
			Collections.sort(prince, Collections.reverseOrder());

			int lose = 0;
			int win = 0;
			for (int i = 0; i < 2; i++) {
				int cur = 100;
				int curPrincess = 0;
				for (int j = 0; j < 3; j++) {
					if (!cancel.contains(prince.get(i)) && !cancel.contains(princess.get(j))) {
						if (prince.get(i) < princess.get(j) && (princess.get(j) - prince.get(i) < cur)) {
							cur = princess.get(j) - prince.get(i);
							curPrincess = princess.get(j);
						}
					}
				}
				if (cur == 100) {
					int min = princess.get(0);
					for (int q = 0; q < 3; q++) {
						if (!cancel.contains(princess.get(q)) && princess.get(q) < min) {
							min = princess.get(q);
						}
					}

					cancel.add(prince.get(i));
					cancel.add(min);
					win++;
				} else {
					cancel.add(curPrincess);
					cancel.add(prince.get(i));
					lose++;
				}
			}

			int hol = 0;
			for (int i = 0; i < 3; i++) {
				if (!cancel.contains(princess.get(i))) {
					hol = princess.get(i);
					break;
				}
			}
			int ans = 0;
			for (int i = hol + 1; i <= 52; i++) {
				if (!used[i]) {
					ans = i;
					break;
				}
			}
			if (lose == 2) {
				ans = 0;
			}
			if (win == 2) {

				for (int i = 1; i <= 52; i++) {
					if (!used[i]) {
						ans = i;
						break;
					}
				}
			}

			if (ans == 0) {
				System.out.println(-1);
			} else {
				System.out.println(ans);
			}

		}

	}
}
