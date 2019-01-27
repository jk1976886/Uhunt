import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class UVA1203 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
		TreeSet<Integer> keys = new TreeSet<>();

		while (true) {
			String[] line = reader.readLine().split(" ");
			if (line[0].equals("#")) {
				break;
			}

			int qNum = Integer.parseInt(line[1]);
			int period = Integer.parseInt(line[2]);
			if (!map.containsKey(period)) {
				map.put(period, new TreeSet<>());
			}
			map.get(period).add(qNum);
			keys.add(period);

		}
		int K = Integer.parseInt(reader.readLine());
		int counter = 0;
		int time = 1;
		boolean done = false;

		while (counter < K && !done) {
			TreeSet<Integer> temp = new TreeSet<>();
			for (int period : keys) {
				if (done) {
					break;
				}
				if (time % period == 0) {
					for (int i : map.get(period)) {
						if (counter >= K) {
							done = true;
							break;
						}
						temp.add(i);
						counter++;
					}
				}
			}
			for (int i : temp) {
				System.out.println(i);
			}

			time++;
		}

	}
}
