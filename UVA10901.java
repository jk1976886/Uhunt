import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class UVA10901 {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());
		for (int p = 0; p < test; p++) {
			if (p != 0) {
				System.out.println();
			}
			String[] ntm = reader.readLine().split(" ");

			// max load: n
			int n = Integer.parseInt(ntm[0]);
			// travel time: t
			int t = Integer.parseInt(ntm[1]);
			// cars: m
			int m = Integer.parseInt(ntm[2]);

			Queue<Integer> left = new LinkedList<>();
			Queue<Integer> right = new LinkedList<>();
			Queue<Integer> leftIndex = new LinkedList<>();
			Queue<Integer> rightIndex = new LinkedList<>();
			int[] ans = new int[m];

			for (int i = 0; i < m; i++) {
				String[] line = reader.readLine().split(" ");
				if (line[1].equals("left")) {
					left.add(Integer.parseInt(line[0]));
					leftIndex.add(i);
				} else {
					right.add(Integer.parseInt(line[0]));
					rightIndex.add(i);
				}
			}

			int time = 0;
			boolean l = true;
			ArrayList<Integer> ship = new ArrayList<>();

			while (!left.isEmpty() || !right.isEmpty()) {
				if (l) {
					while (ship.size() < n) {
						if (!left.isEmpty() && left.peek() <= time) {
							ship.add(leftIndex.poll());
							left.poll();
						} else {
							break;
						}
					}
				} else {
					while (ship.size() < n) {
						if (!right.isEmpty() && right.peek() <= time) {
							ship.add(rightIndex.poll());
							right.poll();
						} else {
							break;
						}
					}
				}

				if (ship.size() == 0) {
					if (!left.isEmpty() && !right.isEmpty()) {
						if (left.peek() < right.peek()) {
							if (left.peek() > time) {
								time = left.peek();
							}
							if (!l) {
								time += t;
								l = !l;
							}
						} else if (left.peek() > right.peek()) {
							if (right.peek() > time) {
								time = right.peek();
							}
							if (l) {
								time += t;
								l = !l;
							}
						} else {
							if (right.peek() > time) {

								time = right.peek();
							}
						}
					} else if (!left.isEmpty() && right.isEmpty()) {
						if (left.peek() > time) {
							time = left.peek();
						}
						if (!l) {
							time += t;
							l = !l;
						}
					} else if (!right.isEmpty() && left.isEmpty()) {
						if (right.peek() > time) {
							time = right.peek();
						}
						if (l) {
							time += t;
							l = !l;
						}
					} else {
						break;
					}
				} else {
					time += t;
					l = !l;
					for (int i = 0; i < ship.size(); i++) {
						ans[ship.get(i)] = time;
					}
					ship.clear();
				}
			}
			for (int i = 0; i < m; i++) {
				System.out.println(ans[i]);
			}
		}

	}
}
