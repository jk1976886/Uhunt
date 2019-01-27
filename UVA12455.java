import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA12455 {

	public static int[] input;
	public static int target;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());

		for (int p = 0; p < test; p++) {
			target = Integer.parseInt(reader.readLine());
			int num = Integer.parseInt(reader.readLine());
			input = new int[num];
			String[] line = reader.readLine().split(" ");

			for (int i = 0; i < num; i++) {
				input[i] = Integer.parseInt(line[i]);
			}
			// recursion
			found = false;
			find(0, target);
			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}

	public static boolean found;

	public static void find(int curIndex, int cur) {
		if (cur == 0) {
			found = true;
			return;
		}
		if (found || curIndex >= input.length) {
			return;
		}
		find(curIndex + 1, cur - input[curIndex]);
		find(curIndex + 1, cur);
	}
}
