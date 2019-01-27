import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA146 {
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String line = reader.readLine();
			if (line.equals("#")) {
				break;
			}
			int cur = -1;
			int index = -1;

			for (int i = line.length() - 1; i >= 0; i--) {
				cur = i;
				index = check(line, i);
				if (index != -1) {
					// found the key letter

					break;
				}
			}

			if (index == -1) {
				System.out.println("No Successor");
			} else {
				System.out.println(compose(line, cur, index));
			}
		}

	}

	public static String compose(String input, int a, int b) {
		String output = "";
		output += input.substring(0, a);
		output += input.charAt(b);
		output += rev(input.substring(b + 1));
		output += input.charAt(a);
		output += rev(input.substring(a + 1, b));
		return output;
	}

	public static int check(String input, int index) {
		if (index >= input.length() - 1) {
			return -1;
		}

		char cur = input.charAt(index);
		String sub = input.substring(index + 1);
		for (int i = sub.length() - 1; i >= 0; i--) {
			if (sub.charAt(i) > cur) {
				return i + index + 1;
			}
		}

		return -1;
	}

	public static String rev(String original) {
		String output = "";
		for (int i = original.length() - 1; i >= 0; i--) {
			output += original.charAt(i);
		}
		return output;
	}
}
