import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class UVA11747 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String[] firstLine = reader.readLine().split(" ");
			int n = Integer.parseInt(firstLine[0]);
			int m = Integer.parseInt(firstLine[1]);
			if (n == 0 && m == 0) {
				break;
			}
			PriorityQueue<Edge> edges = new PriorityQueue<>();
			for (int i = 0; i < m; i++) {
				String[] line = reader.readLine().split(" ");
				edges.add(new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2])));
			}
			PriorityQueue<Integer> discard = new PriorityQueue<>();
			UnionFindDisjointSet ufds = new UnionFindDisjointSet(n);
			for (int i = 0; i < m; i++) {
				Edge cur = edges.poll();
				if (!ufds.isSameSet(cur.pointA, cur.pointB)) {
					ufds.unionSet(cur.pointA, cur.pointB);
				} else {
					discard.add(cur.weight);
				}

			}
			if (discard.size() == 0) {
				System.out.println("forest");
			} else {
				String output = "";
				while (!discard.isEmpty()) {
					output += discard.poll() + " ";
				}
				System.out.println(output.trim());
			}
		}

	}

	public static class Edge implements Comparable<Edge> {
		int pointA, pointB, weight;

		public Edge(int a, int b, int w) {
			pointA = a;
			pointB = b;
			weight = w;
		}

		@Override
		public int compareTo(Edge other) {
			return this.weight - other.weight;
		}
	}

	public static class UnionFindDisjointSet {

		// Union-Find Disjoint Sets Library written in OOP manner, using both path
		// compression and union by rank heuristics
		// OOP style
		public ArrayList<Integer> parent, rank, setSize;
		public int numSets;

		public UnionFindDisjointSet(int N) {
			parent = new ArrayList<Integer>(N);
			rank = new ArrayList<Integer>(N);
			setSize = new ArrayList<Integer>(N);
			numSets = N;
			for (int i = 0; i < N; i++) {
				parent.add(i);
				rank.add(0);
				setSize.add(1);
			}
		}

		public int findSet(int i) {
			if (parent.get(i) == i)
				return i;
			else {
				int ret = findSet(parent.get(i));
				parent.set(i, ret);
				return ret;
			}
		}

		public Boolean isSameSet(int i, int j) {
			return findSet(i) == findSet(j);
		}

		public void unionSet(int i, int j) {
			if (!isSameSet(i, j)) {
				numSets--;
				int x = findSet(i);
				int y = findSet(j);
				// rank is used to keep the tree short
				if (rank.get(x) > rank.get(y)) {
					parent.set(y, x);
					setSize.set(x, setSize.get(x) + setSize.get(y));
				} else {
					parent.set(x, y);
					setSize.set(y, setSize.get(y) + setSize.get(x));
					if (rank.get(x) == rank.get(y))
						rank.set(y, rank.get(y) + 1);
				}
			}
		}

		public int numDisjointSets() {
			return numSets;
		}

		public int sizeOfSet(int i) {
			return setSize.get(findSet(i));
		}

	}
}
