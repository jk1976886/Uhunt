import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class UVA10107 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> input = new ArrayList<>();
		while (sc.hasNextInt()) {
			input.add(sc.nextInt());
			Collections.sort(input);

			if (input.size() % 2 == 1) {
				System.out.println(input.get(input.size() / 2));
			} else {
				System.out.println((int) ((input.get(input.size() / 2) + input.get(input.size() / 2 - 1)) / 2));
			}

		}
	}
}
