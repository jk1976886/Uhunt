import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA732 {

	public static String in, out;

	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (reader.ready()) {
			in = reader.readLine();
			out = reader.readLine();

			System.out.println("[");

			if (in.length() == out.length()) {
				find("", "", "", 0, 0);
			}

			System.out.println("]");
		}

	}

	public static void find(String cur, String stack, String path, int counter, int index) {
		if (counter == 2 * in.length() && cur.equals(out)) {
			for (int i = 0; i < path.length(); i++) {
				System.out.print(path.charAt(i));
				if (i != path.length() - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < cur.length(); i++) {
			if (cur.charAt(i) != out.charAt(i)) {
				return;
			}
		}

		// PUSH
		if (index < in.length()) {
			find(cur, stack + in.charAt(index), path + "i", counter + 1, index + 1);
		}
		// POP
		if (stack.length() != 0) {
			find(cur + stack.charAt(stack.length() - 1), stack.substring(0, stack.length() - 1), path + "o",
					counter + 1, index);
		}

	}
}
