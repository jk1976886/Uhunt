import java.util.*;

public class UVA11727 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			int[] input = new int[3];
			for (int ii = 0; ii < 3; ii++) {
				input[ii] = sc.nextInt();
			}

			Arrays.sort(input);

			System.out.printf("Case %d: %d\n", i + 1, input[1]);
		}

	}

}
