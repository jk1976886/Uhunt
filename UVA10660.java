import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class UVA10660 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());
		int[][] index = new int[5][5];
		int counter = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				index[i][j] = counter;
				counter++;
			}
		}

		for (int p = 0; p < test; p++) {
			int nonEmpty = Integer.parseInt(reader.readLine());
			int[][] city = new int[5][5];
			ArrayList<pair> points = new ArrayList<>();
			ArrayList<Integer> office = new ArrayList<>();
			for (int i = 0; i < nonEmpty; i++) {
				String[] line = reader.readLine().split(" ");
				int r = Integer.parseInt(line[0]);
				int c = Integer.parseInt(line[1]);
				int num = Integer.parseInt(line[2]);
				city[r][c] = num;
				points.add(new pair(r, c, num));
			}

			// loop through so that each office is on one of the points with population,
			// split into two cases: >=5 areas and <5 areas
			if (points.size() == 5) {
				for (pair pa : points) {
					office.add(index[pa.r][pa.c]);
				}
			} else if (points.size() < 5) {
				// here's the problem
				boolean[][] used = new boolean[5][5];
				int cunt = 5;
				for (pair pa : points) {
					office.add(index[pa.r][pa.c]);
					used[pa.r][pa.c] = true;
					cunt--;
				}

				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (!used[i][j]) {
							office.add(index[i][j]);
							used[i][j] = true;
							cunt--;
						}

						if (cunt <= 0) {
							break;
						}
					}
					if (cunt <= 0) {
						break;
					}
				}

			} else {
				// check distance
				ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
				int min = Integer.MAX_VALUE;

				for (int a = 0; a < points.size() - 4; a++) {
					for (int b = a + 1; b < points.size() - 3; b++) {
						for (int c = b + 1; c < points.size() - 2; c++) {
							for (int d = c + 1; d < points.size() - 1; d++) {
								for (int e = d + 1; e < points.size(); e++) {
									// find sum distance and compare, if less than, add solution
									// a b c d e are office locations
									// create a int[][] that calculates all distances
									// update 5 times, first set all to infinity
									int[][] dis = new int[5][5];
									int tr = points.get(a).r;
									int tc = points.get(a).c;
									for (int i = 0; i < 5; i++) {
										for (int j = 0; j < 5; j++) {
											dis[i][j] = city[i][j] * (Math.abs(i - tr) + Math.abs(j - tc));
										}
									}
									ArrayList<pair> oft = new ArrayList<>();
									oft.add(points.get(a));
									oft.add(points.get(b));
									oft.add(points.get(c));
									oft.add(points.get(d));
									oft.add(points.get(e));

									for (int v = 0; v < 5; v++) {
										tr = oft.get(v).r;
										tc = oft.get(v).c;

										for (int i = 0; i < 5; i++) {
											for (int j = 0; j < 5; j++) {
												int newDis = city[i][j] * (Math.abs(i - tr) + Math.abs(j - tc));
												if (newDis < dis[i][j]) {
													dis[i][j] = newDis;
												}
											}
										}
									}

									int sum = 0;
									for (int i = 0; i < 5; i++) {
										for (int j = 0; j < 5; j++) {
											sum += dis[i][j];
										}
									}
									if (sum < min) {
										min = sum;
										ans.clear();
										ArrayList<Integer> temp = new ArrayList<>();
										for (int i = 0; i < 5; i++) {
											temp.add(index[oft.get(i).r][oft.get(i).c]);
										}
										Collections.sort(temp);
										ans.add(temp);
									} else if (sum == min) {
										ArrayList<Integer> temp = new ArrayList<>();
										for (int i = 0; i < 5; i++) {
											temp.add(index[oft.get(i).r][oft.get(i).c]);
										}
										Collections.sort(temp);
										ans.add(temp);
									}
								}
							}
						}
					}
				}
				// 5 loops finished

				office = ans.get(0);
				for (int i = 1; i < ans.size(); i++) {
					boolean aSmallerThanb = false;
					for (int j = 0; j < 5; j++) {
						if (office.get(j) < ans.get(i).get(j)) {
							aSmallerThanb = true;
							break;
						}
					}
					if (!aSmallerThanb) {
						office.clear();
						office.addAll(ans.get(i));
					}
				}

			}
			Collections.sort(office);
			for (int i = 0; i < 5; i++) {
				System.out.print(office.get(i));
				if (i != 4) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

	}

	public static class pair {
		int r, c, val;

		public pair(int a, int b, int c) {
			this.r = a;
			this.c = b;
			this.val = c;
		}
	}
}
