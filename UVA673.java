import java.util.Scanner;
import java.util.Stack;

public class UVA673 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String input = sc.nextLine();
			boolean valid = false;
			Stack<Character> st = new Stack<>();
			for (int ii = 0; ii < input.length(); ii++) {
				if (st.size() != 0) {
					if (st.peek() == '(') {
						if (input.charAt(ii) == ')') {
							st.pop();
						} else {
							st.push(input.charAt(ii));
						}
					} else if (st.peek() == '[') {
						if (input.charAt(ii) == ']') {
							st.pop();
						} else {
							st.push(input.charAt(ii));
						}
					}
				} else {
					st.push(input.charAt(ii));
				}
			}
			if (st.size() == 0) {
				valid = true;

			}

			if (valid) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}

	}

}
