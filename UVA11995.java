import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class UVA11995 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (reader.ready()) {
			int n = Integer.parseInt(reader.readLine().split(" ")[0]);
			Stack<Integer> stack = new Stack<>();
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

			boolean s = true;
			boolean q = true;
			boolean p = true;

			for (int i = 0; i < n; i++) {
				String[] line = reader.readLine().split(" ");
				if (Integer.parseInt(line[0]) == 1) {

					// add
					int hol = Integer.parseInt(line[1]);

					if (s) {
						try {
							stack.push(hol);
						} catch (Exception e) {
							s = false;
						}
					}

					if (q) {
						try {
							queue.add(hol);
						} catch (Exception e) {
							q = false;
						}
					}

					if (p) {
						try {
							pq.add(hol);
						} catch (Exception e) {
							p = false;
						}
					}
				} else {
					// take
					int hol = Integer.parseInt(line[1]);

					if (s) {
						try {
							if (stack.pop() != hol) {
								s = false;
							}
						} catch (Exception e) {
							s = false;
						}
					}

					if (q) {
						try {
							if (queue.poll() != hol) {
								q = false;
							}
						} catch (Exception e) {
							q = false;
						}
					}

					if (p) {
						try {
							if (pq.poll() != hol) {
								p = false;
							}
						} catch (Exception e) {
							p = false;
						}
					}
				}
			}

			if (s && !q && !p) {
				System.out.println("stack");
			} else if (q && !s && !p) {
				System.out.println("queue");
			} else if (p && !s && !q) {
				System.out.println("priority queue");
			} else if (!s && !q && !p) {
				System.out.println("impossible");
			} else {
				System.out.println("not sure");
			}
		}

	}
}
