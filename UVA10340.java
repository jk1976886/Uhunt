import java.util.Scanner;

public class UVA10340 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			String[] line = sc.nextLine().split(" ");
			String original = line[0];
			String target = line[1];
			int counter = 0;
			for (int i = 0; i < target.length(); i++) {
				if (counter < original.length() && target.charAt(i) == original.charAt(counter)) {
					counter++;
				}
			}

			if (counter == original.length()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}

		}

	}
}
