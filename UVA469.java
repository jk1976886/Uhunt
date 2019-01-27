
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class UVA469 {
	public static class pair {
		int row, col;

		public pair(int r, int c) {
			row = r;
			col = c;
		}
	}

	public static ArrayList<ArrayList<pair>> map;
	public static ArrayList<ArrayList<Character>> input;
	public static Set<pair> visited;
	public static Stack<pair> stack;
	public static int[] dr = { 0, 0, 1, -1, 1, 1, -1, -1 };
	public static int[] dc = { 1, -1, 0, 0, 1, -1, 1, -1 };

	public static boolean valid(int r, int c) {
		boolean rvalid = r >= 0 && r < map.size();
		boolean cvalid = c >= 0 && c < map.get(0).size();
		return rvalid && cvalid && !visited.contains(map.get(r).get(c));
	}

	public static int dfs(int row, int col) {

		if (input.get(row).get(col) == 'L') {
			return 0;
		}
		pair begin = new pair(row, col);
		visited.add(map.get(row).get(col));
		int res = 1;
		while (!stack.isEmpty()) {

			for (int i = 0; i < 8; i++) {
				int tempRow = row + dr[i];
				int tempCol = col + dc[i];
				// System.out.println(tempRow + " " + tempCol);

				if (valid(tempRow, tempCol)) {
					if (input.get(tempRow).get(tempCol) == 'W') {
						res++;
						visited.add(map.get(tempRow).get(tempCol));
						stack.add(map.get(tempRow).get(tempCol));
					}
				}
			}
		}
		return res;

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean first = true;
		sc.nextLine();

		while (sc.hasNext()) {
			map = new ArrayList<ArrayList<pair>>();
			input = new ArrayList<ArrayList<Character>>();
			visited = new HashSet<>();
			stack = new Stack<>();
			int counter = 0;
			while (sc.hasNext()) {
				String line = sc.nextLine();

				if (sc.hasNextInt())
					break;

				map.add(new ArrayList<pair>());
				input.add(new ArrayList<Character>());
				for (int i = 0; i < line.length(); i++) {
					if (line.charAt(i) == 'W') {
						map.get(counter).add(new pair(counter, i));
						input.get(counter).add(line.charAt(i));
					} else {
						map.get(counter).add(new pair(counter, i));
						input.get(counter).add(line.charAt(i));
					}
				}
				counter++;

			}

			if (first) {
				first = false;
			} else {
				System.out.println();
			}

			while (sc.hasNextInt()) {
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				System.out.println(dfs(a, b));
			}

			// print1D(point);
		}
	}

}
