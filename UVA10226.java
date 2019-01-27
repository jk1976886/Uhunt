import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class UVA10226 {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(reader.readLine());
		reader.readLine();
		// reader.readLine();
		for (int i = 0; i < test; i++) {

			Set<String> names = new HashSet<>();
			Map<String, Integer> tree = new TreeMap<>();
			int total = 0;

			while (reader.ready()) {

				String line = reader.readLine();
				if (line.equals("")) {
					break;
				}
				if (!names.contains(line)) {
					names.add(line);
					tree.put(line, 0);
				}

				tree.put(line, tree.get(line) + 1);
				total++;

			}

			for (String s : tree.keySet()) {
				System.out.println(s + " " + dec(tree.get(s), total));
			}
			System.out.println();
		}
	}

	public static String dec(int amt, int total) {
		double ans = Math.round((int) (amt * 10000000.0 / total) / 10.0) / 10000.0;
		int decimal = Double.toString(ans).length() - Integer.toString((int) ans).length() - 1;
		String a = Double.toString(ans);
		for (int i = 0; i < 4 - decimal; i++) {
			a += "0";
		}
		return a;

	}
}
