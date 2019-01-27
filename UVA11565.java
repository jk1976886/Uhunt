import java.util.Arrays;
import java.util.Scanner;

public class UVA11565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int[] ans = new int[3];

			boolean sol = false;
			for (int x = -22; x <= 22 && !sol; x++) {
				if (x * x <= c) {
					for (int y = -100; y <= 100 && !sol; y++) {
						if (y != x && x * x + y * y <= c) {
							for (int z = -100; z <= 100 && !sol; z++) {
								if (z != x && z != y && x + y + z == a && x * y * z == b
										&& x * x + y * y + z * z == c) {
									System.out.printf("%d %d %d\n", x, y, z);
									sol = true;
								}
							}
						}
					}
				}
			}

			if (!sol) {
				System.out.println("No solution.");
			}

		}

	}
}
