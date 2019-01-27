import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UVA401 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] selfRef = { 'A', 'H', 'I', 'M', 'O', 'T', 'U', 'V', 'W', 'X', 'Y', '1', '8' };
		Set<Character> self = new HashSet<>();
		for (char c : selfRef) {
			self.add(c);
		}
		Map<Character, Character> mi = new HashMap<>();
		mi.put('A', 'A');
		mi.put('E', '3');
		mi.put('H', 'H');
		mi.put('I', 'I');
		mi.put('J', 'L');
		mi.put('L', 'J');
		mi.put('M', 'M');
		mi.put('O', 'O');
		mi.put('S', '2');
		mi.put('T', 'T');
		mi.put('U', 'U');
		mi.put('V', 'V');
		mi.put('W', 'W');
		mi.put('X', 'X');
		mi.put('Y', 'Y');
		mi.put('Z', '5');
		mi.put('1', '1');
		mi.put('2', 'S');
		mi.put('3', 'E');
		mi.put('5', 'Z');
		mi.put('8', '8');
		// boolean first = true;
		while (reader.ready()) {
			String str = reader.readLine();

			// if (first) {
			// first = false;
			// } else {
			// System.out.println();
			// }

			// check mirror
			boolean mirror = true;
			// check half
			for (int i = 0; i < str.length() / 2; i++) {
				char a = str.charAt(i);
				char b = str.charAt(str.length() - 1 - i);

				if (mi.containsKey(a)) {
					a = mi.get(a);
				}
				if (a != b) {
					mirror = false;
					break;
				} else {

					if (!mi.containsKey(a) && !self.contains(a)) {
						mirror = false;
						break;
					}
				}
			}
			// check middle?
			if (mirror) {
				if (str.length() % 2 == 1) {
					char c = str.charAt(str.length() / 2);
					if (!self.contains(c)) {
						mirror = false;
					}
				}
			}

			// check palindrome
			boolean pal = true;
			for (int i = 0; i < str.length() / 2; i++) {
				char a = str.charAt(i);
				char b = str.charAt(str.length() - 1 - i);

				if (a != b) {
					pal = false;
					break;
				}
			}

			if (pal && mirror) {
				System.out.println(str + " -- is a mirrored palindrome.");
			} else if (pal) {
				System.out.println(str + " -- is a regular palindrome.");
			} else if (mirror) {
				System.out.println(str + " -- is a mirrored string.");
			} else {
				System.out.println(str + " -- is not a palindrome.");
			}
			System.out.println();

		}

	}
}
