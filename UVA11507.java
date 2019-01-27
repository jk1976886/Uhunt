import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA11507 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int n = Integer.parseInt(reader.readLine().split(" ")[0]);
			if (n == 0) {
				break;
			}
			String[] bend = reader.readLine().split(" ");
			String end = "+x";
			for (String s : bend) {
				if (s.equals("No")) {
					// do nothing
				} else if (s.equals("+z")) {
					if (end.equals("+x")) {
						end = "+z";
					} else if (end.equals("-x")) {
						end = "-z";
					} else if (end.equals("+y")) {
						// end = "";
					} else if (end.equals("-y")) {
						// end = "";
					} else if (end.equals("+z")) {
						end = "-x";
					} else if (end.equals("-z")) {
						end = "+x";
					}
				} else if (s.equals("-z")) {
					if (end.equals("+x")) {
						end = "-z";
					} else if (end.equals("-x")) {
						end = "+z";
					} else if (end.equals("+y")) {
						// end = "";
					} else if (end.equals("-y")) {
						// end = "";
					} else if (end.equals("+z")) {
						end = "+x";
					} else if (end.equals("-z")) {
						end = "-x";
					}
				} else if (s.equals("+y")) {
					if (end.equals("+x")) {
						end = "+y";
					} else if (end.equals("-x")) {
						end = "-y";
					} else if (end.equals("+y")) {
						end = "-x";
					} else if (end.equals("-y")) {
						end = "+x";
					} else if (end.equals("+z")) {
						// end = "";
					} else if (end.equals("-z")) {
						// end = "";
					}
				} else if (s.equals("-y")) {
					if (end.equals("+x")) {
						end = "-y";
					} else if (end.equals("-x")) {
						end = "+y";
					} else if (end.equals("+y")) {
						end = "+x";
					} else if (end.equals("-y")) {
						end = "-x";
					} else if (end.equals("+z")) {
						// end = "";
					} else if (end.equals("-z")) {
						// end = "";
					}
				}
			}
			System.out.println(end);

		}

	}
}
