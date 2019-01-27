import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class UVA11849 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] line = reader.readLine().split(" ");
			int N = Integer.parseInt(line[0]);
			int M = Integer.parseInt(line[1]);

			if (N == 0 && M == 0) {
				break;
			}

			Set<Integer> jack = new TreeSet<>();
			Set<Integer> rep = new TreeSet<>();

			for (int i = 0; i < N; i++) {
				jack.add(Integer.parseInt(reader.readLine()));
			}
			for (int i = 0; i < M; i++) {
				int hol = Integer.parseInt(reader.readLine());
				if (jack.contains(hol)) {
					rep.add(hol);
				}

			}
			System.out.println(rep.size());
		}
	}
}
