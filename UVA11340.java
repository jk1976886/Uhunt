
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class UVA11340 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		// System.out.println(n);
		for (int i = 0; i < n; i++) {

			int k = Integer.parseInt(reader.readLine());
			// System.out.println(k);
			HashMap<Character, Integer> input = new HashMap<Character, Integer>();

			for (int ii = 0; ii < k; ii++) {
				String in = reader.readLine();
				// System.out.println(in);
				String[] IN = in.split(" ");
				char c = IN[0].charAt(0);
				int cent = Integer.parseInt(IN[1]);
				input.put(c, cent);
			}

			int m = Integer.parseInt(reader.readLine());
			// System.out.println(m);
			double money = 0;
			if (m != 0) {

				for (int ii = 0; ii < m; ii++) {
					String line = reader.readLine();
					// System.out.println(line);
					// System.out.println(ii);
					for (int iii = 0; iii < line.length(); iii++) {
						if (input.get(line.charAt(iii)) != null) {
							money += input.get(line.charAt(iii));
						}
					}
				}
				money /= 100.00;

				String output = money + "$";
				if (output.length() >= 5) {
					System.out.println(output);
				} else {
					System.out.println(output.substring(0, 3) + "0" + output.substring(3));
				}
			} else {
				System.out.println("0.00$");
			}
		}

	}

}