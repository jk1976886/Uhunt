import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UVA10004 {
	public static Map<Integer, ArrayList<Integer>> map;
	public static int[] color;
	public static boolean bi;
	// 1 for black, 2 for white

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0) {
				break;
			}
			int l = sc.nextInt();
			map = new HashMap<>();
			color = new int[n];
			for (int i = 0; i < n; i++) {
				map.put(i, new ArrayList<>());
			}

			for (int i = 0; i < l; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();

				map.get(a).add(b);
				map.get(b).add(a);
			}
			bi = true;
			dfs(0, 1);

			if (bi) {
				System.out.println("BICOLORABLE.");
			} else {
				System.out.println("NOT BICOLORABLE.");
			}

		}

	}

	public static void dfs(int cur, int co) {
		if (!bi) {
			return;
		}
		color[cur] = co;
		if (co == 1) {
			for (int i : map.get(cur)) {
				if (color[i] == co) {
					bi = false;
					return;
				} else if (color[i] == 0) {
					dfs(i, 2);
				}
			}
		} else {
			for (int i : map.get(cur)) {
				if (color[i] == co) {
					bi = false;
					return;
				} else if (color[i] == 0) {
					dfs(i, 1);
				}
			}
		}

	}

}
