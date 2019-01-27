import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class UVA11034 {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());
		for (int p = 0; p < test; p++) {

			String[] lm = reader.readLine().split(" ");
			int length = Integer.parseInt(lm[0]) * 100;
			int cars = Integer.parseInt(lm[1]);

			Queue<Integer> left = new LinkedList<>();
			Queue<Integer> right = new LinkedList<>();

			for (int i = 0; i < cars; i++) {
				String[] line = reader.readLine().split(" ");

				if (line[1].equals("left")) {
					left.add(Integer.parseInt(line[0]));
				} else {
					right.add(Integer.parseInt(line[0]));
				}

			}
			boolean l = true;
			int counter = 0;
			int lHol = length;

			while (true) {
				lHol = length;
				if (left.isEmpty() && right.isEmpty()) {
					break;
				}

				if (l) {
					while (!left.isEmpty()) {
						if (lHol >= left.peek()) {
							lHol -= left.poll();
						} else {
							break;
						}
					}
				} else {
					while (!right.isEmpty()) {
						if (lHol >= right.peek()) {
							lHol -= right.poll();
						} else {
							break;
						}
					}
				}

				counter++;
				l = !l;
			}
			System.out.println(counter);
		}

	}
}
