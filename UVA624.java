import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA624 {
	public static int[] min;
	public static String ans;
	public static int max, N;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (reader.ready()) {
			String[] line = reader.readLine().split(" ");
			N = Integer.parseInt(line[0]);
			int tracks = Integer.parseInt(line[1]);
			min = new int[tracks];
			for (int i = 2; i < line.length; i++) {
				min[i - 2] = Integer.parseInt(line[i]);
			}
			max = 0;
			find(0, 0, "");
			System.out.println(ans.trim() + " sum:" + max);
		}

	}

	public static void find(int cur, int sum, String path) {
		if (cur == min.length) {
			// last item checked
			if (sum > max) {
				max = sum;
				ans = path;
			}
			return;
		}
		if (sum + min[cur] <= N) {
			find(cur + 1, sum + min[cur], path + " " + min[cur]);
		}
		find(cur + 1, sum, path);

	}
}
