import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UVA11057 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		boolean first = true;
		while (reader.ready()) {
			if (first) {
				first = false;
			} else {
				reader.readLine();
			}
			if (!reader.ready()) {
				break;
			}
			int n = Integer.parseInt(reader.readLine());
			String[] bookPrice = reader.readLine().split(" ");
			int m = Integer.parseInt(reader.readLine());

			int[] price = new int[bookPrice.length];
			for (int i = 0; i < price.length; i++) {
				price[i] = Integer.parseInt(bookPrice[i]);
			}
			// input finished
			Arrays.sort(price);
			int a = 10000000;
			int b = -10000000;

			for (int i = 0; i < price.length; i++) {
				if (price[i] >= m) {
					break;
				}
				int cur = price[i];
				int tar = m - cur;
				int left = 0;
				int right = price.length - 1;
				int mid = 0;
				if (tar > cur) {
					left = i + 1;
				} else if (tar < cur) {
					right = i - 1;
				}
				boolean found = false;
				if (tar == cur) {
					int tempIndex = i + 1;
					if (tempIndex < price.length && price[tempIndex] == tar) {
						found = true;
					}
					if (!found) {
						tempIndex -= 2;
						if (tempIndex >= 0 && price[tempIndex] == tar) {
							found = true;
						}
					}

				} else {
					while (left <= right) {
						mid = (left + right) / 2;
						if (price[mid] > tar) {
							right = mid - 1;
						} else if (price[mid] < tar) {
							left = mid + 1;
						} else {
							break;
						}
					}
				}
				int test1 = Math.abs(cur - tar);
				int test2 = Math.abs(a - b);
				if (found) {
					a = tar;
					b = tar;
				} else if (price[mid] == tar && Math.abs(cur - tar) < Math.abs(a - b)) {

					a = cur;
					b = tar;
				}

			}
			// System.out.println(a + " " + b);
			System.out.println("Peter should buy books whose prices are " + a + " and " + b + ".");
			System.out.println();
		}

	}
}
