import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class UVA11228 {

	/*
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * I GIVE UP
	 * 
	 * do MST once to determine states and another time to determine MSt within
	 * states
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());
		for (int p = 1; p <= test; p++) {
			String[] firstLine = reader.readLine().split("");
			int n = Integer.parseInt(firstLine[0]);
			int r = Integer.parseInt(firstLine[1]);
			int rSquare = r * r;
			UnionFindDisjointSet ufds = new UnionFindDisjointSet(n);
			point[] points = new point[n];

			for (int i = 0; i < n; i++) {
				String[] line = reader.readLine().split(" ");
				points[i] = new point(Integer.parseInt(line[0]), Integer.parseInt(line[1]));
			}

			PriorityQueue<Edge> edges = new PriorityQueue<>();

			for (int i = 0; i < n; i++) {
				int curMinLengthSquare = Integer.MAX_VALUE;
				int curMinLengthIndex = 0;

				for (int j = 0; j < n; j++) {
					if (j != i) {
						int curDistSquare = (int) (Math.pow(Math.abs(points[i].x - points[j].x), 2)
								+ Math.pow(Math.abs(points[i].y - points[j].y), 2));
						if (curDistSquare < curMinLengthSquare) {
							curMinLengthIndex = j;
						}
					}
				}
				// i to curMinLengthIndex is the shortest
			}

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

	public static class point implements Comparable<point> {
		int x, y;

		point(int a, int b) {
			x = a;
			y = b;
		}

		@Override
		public int compareTo(point other) {
			// TODO Auto-generated method stub
			if (this.x == other.x) {
				return this.y - other.y;
			}
			return this.x - other.x;
		}

		public boolean equals(point other) {
			return this.x == other.x && this.y == other.y;
		}

	}
}
