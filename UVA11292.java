import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class UVA11292 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] firstLine = reader.readLine().split(" ");
			int n = Integer.parseInt(firstLine[0]);
			int m = Integer.parseInt(firstLine[1]);
			if (n == 0 && m == 0) {
				break;
			}

			PriorityQueue<Integer> head = new PriorityQueue<>();
			PriorityQueue<Integer> knight = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				head.add(Integer.parseInt(reader.readLine().trim()));

			}
			for (int i = 0; i < m; i++) {
				knight.add(Integer.parseInt(reader.readLine().trim()));

			}
			int cost = 0;
			while (!knight.isEmpty() && !head.isEmpty()) {
				int curKnight = knight.poll();
				if (curKnight >= head.peek()) {
					head.poll();
					cost += curKnight;
				}
			}
			if (head.isEmpty()) {
				System.out.println(cost);
			} else {
				System.out.println("Loowater is doomed!");
			}

		}

	}
}
