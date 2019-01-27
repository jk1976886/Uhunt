import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class UVA10172 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		for (int p = 0; p < test; p++) {
			int N = sc.nextInt();
			int S = sc.nextInt();
			int Q = sc.nextInt();

			ArrayList<Queue<Integer>> station = new ArrayList<>();
			Stack<Integer> cargo = new Stack<>();

			for (int i = 0; i <= N; i++) {
				station.add(new LinkedList<>());
			}

			for (int i = 1; i <= N; i++) {
				int Qi = sc.nextInt();
				for (int j = 0; j < Qi; j++) {
					station.get(i).add(sc.nextInt());
				}
			}

			int time = 0;
			int curSta = 1;

			while (true) {
				boolean temp = false;
				if (curSta > N) {
					// System.out.println("-------------------------------------");
					curSta = 1;
				}
				// System.out.println("curSta is: " + curSta);
				// System.out.println("before: ");
				// System.out.println(station.get(curSta));
				// unload and enque
				while (true) {
					if (cargo.isEmpty()) {
						break;
					}

					if (cargo.peek() == curSta) {
						cargo.pop();
					} else if (station.get(curSta).size() < Q) {
						station.get(curSta).add(cargo.pop());
					} else {
						break;
					}
					time++;
				}

				// reload and deque
				while (true) {
					if (cargo.size() == S || station.get(curSta).isEmpty()) {
						break;
					}

					cargo.push(station.get(curSta).poll());
					time++;
				}

				// debug
				// System.out.println("After:");
				// System.out.println(station.get(curSta));
				// System.out.println("cargo car: ");
				// System.out.println(cargo);
				// System.out.println();

				boolean done = true;
				if (!cargo.isEmpty()) {
					done = false;
				}
				for (int i = 1; i <= N && done; i++) {
					if (!station.get(i).isEmpty()) {
						done = false;
						break;
					}
				}

				if (done) {
					break;
				}

				time += 2;
				curSta++;
			}
			System.out.println(time);

		}

	}
}
