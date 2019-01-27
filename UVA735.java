import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UVA735 {

	public static Set<ArrayList<Integer>> permutation;
	public static Set<Set<Integer>> combination;
	public static HashMap<Integer, ArrayList<Integer>> result;
	public static boolean[] valid;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		result = new HashMap<>();
		valid = new boolean[61];
		for (int i = 0; i <= 20; i++) {
			valid[i] = true;
			valid[i * 2] = true;
			valid[i * 3] = true;
		}
		valid[50] = true;

		while (true) {
			int score = Integer.parseInt(reader.readLine());
			if (score <= 0) {
				System.out.println("END OF OUTPUT");
				break;
			}
			// one time complete search to find all permutations
			// while looking for permutations, for each permutation found, check if existed
			if (result.containsKey(score)) {

				if (result.get(score).get(0) == 0 && result.get(score).get(1) == 0) {
					System.out.println("THE SCORE OF " + score + " CANNOT BE MADE WITH THREE DARTS.");

				} else {
					System.out.println(
							"NUMBER OF COMBINATIONS THAT SCORES " + score + " IS " + result.get(score).get(0) + ".");
					System.out.println(
							"NUMBER OF PERMUTATIONS THAT SCORES " + score + " IS " + result.get(score).get(1) + ".");

				}
				System.out.println("**********************************************************************");

			} else {
				combination = new HashSet<>();
				permutation = new HashSet<>();

				for (int a = 0; a < 61; a++) {
					if (valid[a]) {
						for (int b = 0; b < 61; b++) {
							if (valid[b]) {
								for (int c = 0; c < 61; c++) {
									if (valid[c]) {
										if (a + b + c == score) {
											ArrayList<Integer> current = new ArrayList<>();
											Set<Integer> cur = new HashSet<>();
											current.add(a);
											current.add(b);
											current.add(c);
											cur.add(a);
											cur.add(b);
											cur.add(c);

											permutation.add(current);

											combination.add(cur);
										}
									}

								}
							}
						}
					}
				}

				if (combination.size() == 0 && permutation.size() == 0) {
					System.out.println("THE SCORE OF " + score + " CANNOT BE MADE WITH THREE DARTS.");
				} else {
					System.out
							.println("NUMBER OF COMBINATIONS THAT SCORES " + score + " IS " + combination.size() + ".");
					System.out
							.println("NUMBER OF PERMUTATIONS THAT SCORES " + score + " IS " + permutation.size() + ".");
				}
				System.out.println("**********************************************************************");
				ArrayList<Integer> ans = new ArrayList<>();
				ans.add(combination.size());
				ans.add(permutation.size());
				result.put(score, ans);
			}
			// for (Set<Integer> arr : combination) {
			// for (int i : arr) {
			// if (i == 50) {
			// System.out.println("***********");
			// }
			// System.out.print(i + " ");
			// }
			// System.out.println();
			// }
			// check 50 bulls eye

		}

	}

}
