import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class UVA10954 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			int N = Integer.parseInt(reader.readLine());
			if (N == 0) {
				break;
			}
			String[] line = reader.readLine().split(" ");

			PriorityQueue<Integer> pq = new PriorityQueue<>();
			for (String s : line) {
				pq.add(Integer.parseInt(s));
			}

			int cost = 0;

			while (!pq.isEmpty()) {
				if (pq.size() == 2) {
					int hol = pq.poll() + pq.poll();
					cost += hol;
					break;
				} else {
					int hol = pq.poll() + pq.poll();
					cost += hol;
					pq.add(hol);
				}

			}
			System.out.println(cost);
		}

	}
}
