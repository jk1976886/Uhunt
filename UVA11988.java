import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class UVA11988 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (reader.ready()) {
			char[] line = reader.readLine().toCharArray();

			LinkedList<Character> ans = new LinkedList<>();
			int index = 0;

			for (int i = 0; i < line.length; i++) {
				if (line[i] == '[') {
					index = 0;
				} else if (line[i] == ']') {
					index = ans.size();
				} else {
					ans.add(index, line[i]);
					index++;
				}
			}

			for (char c : ans) {
				System.out.print(c);
			}
			System.out.println();

		}

	}
}
