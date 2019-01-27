import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class UVA11799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 1; i <= test; i++) {
			int n = sc.nextInt();
			PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
			for (int j = 0; j < n; j++) {
				pq.add(sc.nextInt());
			}
			System.out.printf("Case %d: %d\n", i, pq.poll());
		}

	}
}
