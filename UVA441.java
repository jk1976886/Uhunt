import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA441 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int counter = 0;
		while (true) {
			String[] line = reader.readLine().split(" ");

			if (line[0].equals("0")) {
				break;
			}
			if (counter > 0) {
				System.out.println();
			}

			int k = Integer.parseInt(line[0]);
			int[] num = new int[k];
			for (int i = 1; i <= k; i++) {
				num[i - 1] = Integer.parseInt(line[i]);
			}

			for (int i1 = 0; i1 < k - 5; i1++) {
				for (int i2 = i1 + 1; i2 < k - 4; i2++) {
					for (int i3 = i2 + 1; i3 < k - 3; i3++) {
						for (int i4 = i3 + 1; i4 < k - 2; i4++) {
							for (int i5 = i4 + 1; i5 < k - 1; i5++) {
								for (int i6 = i5 + 1; i6 < k; i6++) {
									System.out.printf("%d %d %d %d %d %d\n", num[i1], num[i2], num[i3], num[i4],
											num[i5], num[i6]);
								}
							}
						}
					}
				}
			}

			counter++;

		}
	}
}
