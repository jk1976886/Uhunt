import java.util.*;

public class UVA10986 {
	public static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cas = sc.nextInt();
		for (int p = 1; p <= cas; p++) {

			int n = sc.nextInt();
			int m = sc.nextInt();
			int s = sc.nextInt();
			int t = sc.nextInt();
			map = new int[n][n];

			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int val = sc.nextInt();

				map[a][b] = val;
				map[b][a] = val;
			}

			System.out.println("Case #" + p + ": ");
		}
	}

	public static void search(int cur) {

	}
}
