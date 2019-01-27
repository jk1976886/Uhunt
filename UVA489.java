import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class UVA489 {
	public static void main(String[] args) throws Exception {
		// Scanner sc = new Scanner(System.in);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			int round = Integer.parseInt(reader.readLine());

			if (round == -1) {
				break;
			}

			String t = reader.readLine();
			String g = reader.readLine();
			Set<Character> target = new HashSet<>();
			Set<Character> guess = new HashSet<>();
			Set<Character> wrong = new HashSet<>();
			Set<Character> right = new HashSet<>();

			for (int i = 0; i < t.length(); i++) {
				target.add(t.charAt(i));
			}

			int counter = 0;

			for (int i = 0; i < g.length(); i++) {
				char c = g.charAt(i);
				if (target.contains(c)) {
					right.add(c);
					target.remove(c);
					wrong.add(c);
				} else {
					if (!wrong.contains(c)) {
						wrong.add(c);
						counter++;
					}
				}
				if (target.size() == 0) {
					break;
				}
				if (counter >= 7) {
					break;
				}
			}
			System.out.println("Round " + round);
			if (counter >= 7) {
				System.out.println("You lose.");
			} else if (target.size() == 0) {
				System.out.println("You win.");
			} else {
				System.out.println("You chickened out.");
			}
		}

	}

}
