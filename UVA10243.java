import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class UVA10243 {
	public static HashMap<Integer, ArrayList<Integer>> map;
	public static int N, counter;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;

			counter = 0;
			map = new HashMap<>();

			for (int i = 0; i < N; i++) {
				int n = sc.nextInt();
				map.put(i + 1, new ArrayList<Integer>());
				for (int ii = 0; ii < n; ii++) {
					map.get(i + 1).add(sc.nextInt());
				}
			}
		}

	}

	public static void dfs() {
		Stack<Integer> stack = new Stack<>();

	}
}
