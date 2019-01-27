import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class UVA156 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<String> pq = new PriorityQueue<>();

		ArrayList<String> dic = new ArrayList<>();
		ArrayList<char[]> cha = new ArrayList<>();
		boolean input = false;

		while (!input) {
			String[] line = reader.readLine().split(" ");
			for (String s : line) {
				if (!s.isEmpty()) {
					if (s.equals("#")) {
						input = true;
						break;
					}
					dic.add(s);
					char[] temp = s.toLowerCase().toCharArray();
					Arrays.sort(temp);
					cha.add(temp);
				}
			}
		}

		// all words in dic
		int size = dic.size();


		for (int i = 0; i < size; i++) {
			boolean ana = false;

			for (int j = 0; j < size; j++) {
				// check if two things are anagram

				if (i != j && cha.get(i).length == cha.get(j).length) {
					boolean check = true;

					for (int a = 0; a < cha.get(i).length; a++) {
						if (cha.get(i)[a] != cha.get(j)[a]) {
							check = false;
							break;
						}
					}

					if (check) {
						ana = true;
						break;
					}
				}

			}

			if (!ana) {
				pq.add(dic.get(i));
			}
		}

		for (int i = pq.size(); i > 0; i--) {
			System.out.println(pq.poll());
		}

	}
}
