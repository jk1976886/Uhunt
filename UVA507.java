import java.util.Scanner;

public class UVA507 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b = sc.nextInt();

		for (int p = 1; p <= b; p++) {
			int s = sc.nextInt();

			int[] rating = new int[s];
			rating[0] = 0;

			for (int i = 1; i < s; i++) {
				rating[i] = sc.nextInt();

			}

			int curBeg = 0;
			int curEnd = 0;
			int beg = 0;
			int end = 0;
			int sum = 0;
			int max = 0;

			for (int i = 1; i < s; i++) {
				sum += rating[i];

				curEnd = i;

				if (sum > max || (sum == max && curEnd - curBeg > end - beg)) {
					max = sum;
					beg = curBeg;
					end = curEnd;
				}

				if (sum < 0) {
					sum = 0;
					curBeg = i;
					curEnd = i;
				}

			}

			if (max == 0) {
				System.out.println("Route " + p + " has no nice parts");
			} else {
				System.out.println(
						"The nicest part of route " + p + " is between stops " + (beg + 1) + " and " + (end + 1));
			}

		}

	}
}