import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class UVA10067 {

	public static int[] beg, tar;
	public static int[][] forbid;
	// public static boolean found;
	public static ArrayList<Integer> ans;
	public static boolean[] visited;
	public static Map<Integer, ArrayList<int[]>> map, orig;

	// 1
	// 8 0 5 6
	// 6 5 0 8
	// 5
	// 8 0 5 7
	// 8 0 4 7
	// 5 5 0 8
	// 7 5 0 8
	// 6 4 0 8

	public static int[] move(int[] cur, int index, int but) {
		int[] aha = new int[4];
		for (int i = 0; i < 4; i++) {
			aha[i] = cur[i];
		}
		if (but == 0) {
			aha[index]++;
			if (aha[index] == 10) {
				aha[index] = 0;
			}
		} else if (but == 1) {
			aha[index] -= 1;
			if (aha[index] == -1) {
				aha[index] = 9;
			}

		}
		return aha;
	}

	// 0 is right, 1 is left
	public static void main(String[] args) {
		orig = new HashMap<>();

		for (int i = 0; i < 10; i++) {
			for (int ii = 0; ii < 10; ii++) {
				for (int iii = 0; iii < 10; iii++) {
					for (int iiii = 0; iiii < 10; iiii++) {
						int[] temp = { i, ii, iii, iiii };
						int n = num(temp);
						orig.put(n, new ArrayList<>());
						for (int p = 0; p < 4; p++) {
							orig.get(n).add(move(temp, p, 0));
							orig.get(n).add(move(temp, p, 1));
						}
					}
				}
			}
		}

		// we'll see if this works
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();

		for (int p = 0; p < test; p++) {

			beg = new int[4];
			tar = new int[4];
			map = new HashMap<>();
			visited = new boolean[10000];
			ans = new ArrayList<>();
			map.putAll(orig);

			for (int i = 0; i < 4; i++) {
				beg[i] = sc.nextInt();
				// System.out.println(beg[i]);
			}
			for (int i = 0; i < 4; i++) {
				tar[i] = sc.nextInt();
				// System.out.println(tar[i]);
			}

			int forb = sc.nextInt();
			forbid = new int[forb][4];
			for (int i = 0; i < forb; i++) {
				for (int ii = 0; ii < 4; ii++) {
					forbid[i][ii] = sc.nextInt();
				}
				visited[num(forbid[i])] = true;
			}

			int counter = 0;
			Queue<int[]> q = new LinkedList<>();
			q.add(beg);
			visited[num(beg)] = true;
			int curCunt = 0;
			int levelCunt = 1;
			int nextCunt = 0;
			boolean found = false;
			while (!q.isEmpty()) {
				int[] hol = q.poll();
				int cur = num(hol);
				// System.out.println(cur);
				// if (cur == 6508) {
				// System.out.println(counter);
				// }
				if (cur == num(tar)) {
					found = true;
					break;
				}
				curCunt++;
				for (int[] i : map.get(cur)) {
					if (!visited[num(i)]) {
						visited[num(i)] = true;
						q.add(i);
						nextCunt++;
					}
				}
				if (curCunt == levelCunt) {
					counter++;
					curCunt = 0;
					levelCunt = nextCunt;
					nextCunt = 0;
				}
			}
			if (found) {
				System.out.println(counter);
			} else {
				System.out.println(-1);
			}
		}

	}

	public static int num(int[] arr) {
		return arr[0] * 1000 + arr[1] * 100 + arr[2] * 10 + arr[3];
	}
}