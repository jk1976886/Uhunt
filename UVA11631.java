import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class UVA11631 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] firstLine = reader.readLine().split(" ");
			int n = Integer.parseInt(firstLine[0]);
			int e = Integer.parseInt(firstLine[1]);
			if (n == 0 && e == 0) {
				break;
			}
			PriorityQueue<Edge> edges = new PriorityQueue<>();
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			for (int i = 0; i < n; i++) {
				map.put(i, new ArrayList<>());
			}
			int max = 0;
			for (int i = 0; i < e; i++) {
				String[] line = reader.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				int w = Integer.parseInt(line[2]);
				max += w;
				edges.add(new Edge(a, b, w));
				map.get(a).add(b);
				map.get(b).add(a);
			}
			UnionFindDisjointSet ufds = new UnionFindDisjointSet(n);
			int sum = 0;
			for (int i = 0; i < e; i++) {
				Edge edge = edges.poll();
				// if not the same, join them and add the edge to sum
				if (!ufds.isSameSet(edge.pointA, edge.pointB)) {
					ufds.unionSet(edge.pointA, edge.pointB);
					sum += edge.weight;
				}
			}
			System.out.println(max - sum);

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
}
