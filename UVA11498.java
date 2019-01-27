import java.util.Scanner;

public class UVA11498 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int k = sc.nextInt();

			if (k == 0) {
				break;
			}

			int n = sc.nextInt();
			int m = sc.nextInt();

			for (int i = 0; i < k; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (a == n || b == m) {
					System.out.println("divisa");
				} else if (a < n && b > m) {
					System.out.println("NO");
				} else if (a < n && b < m) {
					System.out.println("SO");
				} else if (a > n && b > m) {
					System.out.println("NE");
				} else if (a > n && b < m) {
					System.out.println("SE");
				}
			}

		}

	}

}
