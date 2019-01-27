import java.util.ArrayList;
import java.util.Scanner;

public class UVA10276 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int test = sc.nextInt();

		for (int p = 0; p < test; p++) {
			int n = sc.nextInt();
			int curNum = 1;
			ArrayList<ArrayList<Integer>> pegs = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				pegs.add(new ArrayList<>());
			}

			while (true) {
				boolean change = false;
				for (int i = 0; i < pegs.size() && !change; i++) {
					if (!pegs.get(i).isEmpty()) {
						double sqrt = Math.sqrt(pegs.get(i).get(pegs.get(i).size() - 1) + curNum);
						if (sqrt == (int) (sqrt)) {
							pegs.get(i).add(curNum);
							curNum++;
							change = true;
						}
					}
				}

				if (!change) {
					for (int i = 0; i < pegs.size(); i++) {
						if (pegs.get(i).size() == 0) {
							pegs.get(i).add(curNum);
							curNum++;
							change = true;
							break;
						}
					}
				}

				if (!change) {
					break;
				}
			}

			System.out.println(curNum - 1);

		}

	}
}
