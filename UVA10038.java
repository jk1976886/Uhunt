import java.util.*;

public class UVA10038 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {

			int n = sc.nextInt();

			int[] input = new int[n];

			boolean valid = true;
			for (int i = 0; i < n; i++) {
				input[i] = sc.nextInt();
			}

			if (n == 1) {
				System.out.println("Jolly");
			} else {
				ArrayList<Integer> diff = new ArrayList<Integer>();
				for (int i = 0; i < n - 1; i++) {
					int D = Math.abs(input[i + 1] - input[i]);
					if (diff.contains(D)) {
						valid = false;
						break;
					} else if (D > n - 1) {
						valid = false;
						break;
					} else if (D <= 0) {
						valid = false;
						break;
					}

					diff.add(D);
				}

				if (valid) {
					System.out.println("Jolly");
				} else {
					System.out.println("Not jolly");
				}
			}
		}

	}

}
