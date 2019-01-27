import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeSet;

public class UVA978 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			if (p != 0) {
				System.out.println();
			}

			String[] line = reader.readLine().split(" ");
			int field = Integer.parseInt(line[0]);
			int g = Integer.parseInt(line[1]);
			int b = Integer.parseInt(line[2]);

			TreeSet<Integer> green = new TreeSet<>();
			TreeSet<Integer> blue = new TreeSet<>();
			int[] gDup = new int[101];
			int[] bDup = new int[101];

			for (int i = 0; i < g; i++) {
				int cur = Integer.parseInt(reader.readLine());
				green.add(cur);
				gDup[cur]++;
			}
			for (int i = 0; i < b; i++) {
				int cur = Integer.parseInt(reader.readLine());
				blue.add(cur);
				bDup[cur]++;
			}

			while (true) {

				ArrayList<Integer> gHol = new ArrayList<>();
				ArrayList<Integer> bHol = new ArrayList<>();

				int counter = 0;
				if (b < field || g < field) {
					counter = Math.min(g, b);
				} else {
					counter = field;
				}

				for (int i = 0; i < counter; i++) {
					gHol.add(green.last());
					gDup[green.last()]--;
					if (gDup[green.last()] == 0) {
						green.pollLast();
					}

					bHol.add(blue.last());
					bDup[blue.last()]--;
					if (bDup[blue.last()] == 0) {
						blue.pollLast();
					}
					g--;
					b--;
				}

				for (int i = 0; i < counter; i++) {
					int curG = gHol.get(i);
					int curB = bHol.get(i);

					if (curG > curB) {
						int hol = curG - curB;
						green.add(hol);
						gDup[hol]++;
						g++;
					} else if (curB > curG) {
						int hol = curB - curG;
						blue.add(hol);
						bDup[hol]++;
						b++;
					}

				}

				if (blue.isEmpty() && green.isEmpty()) {
					System.out.println("green and blue died");
					break;
				} else if (blue.isEmpty()) {
					System.out.println("green wins");
					int len = green.size();
					for (int ii = 0; ii < len; ii++) {
						for (int iii = 0; iii < gDup[green.last()]; iii++) {
							System.out.println(green.last());
						}
						green.pollLast();
					}
					break;
				} else if (green.isEmpty()) {
					System.out.println("blue wins");
					int len = blue.size();
					for (int ii = 0; ii < len; ii++) {
						for (int iii = 0; iii < bDup[blue.last()]; iii++) {
							System.out.println(blue.last());
						}
						blue.pollLast();
					}
					break;
				}

			}
			// System.out.println();

		}

	}
}
