import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UVA462 {
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Integer> num = new HashMap<>();
		Map<Integer, String> name = new HashMap<>();
		String[] rank = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K" };
		String[] suit = { "S", "H", "D", "C" };

		int counter = 0;
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				num.put((rank[i] + suit[j]), counter);
				name.put(counter, (rank[i] + suit[j]));
				counter++;
			}
		}

		while (reader.ready()) {
			String[] input = reader.readLine().split(" ");
			ArrayList<Integer> card = new ArrayList<>();
			ArrayList<Integer> S = new ArrayList<>();
			ArrayList<Integer> H = new ArrayList<>();
			ArrayList<Integer> D = new ArrayList<>();
			ArrayList<Integer> C = new ArrayList<>();
			int point = 0;
			// stopped?
			boolean s = false;
			boolean h = false;
			boolean d = false;
			boolean c = false;

			for (int i = 0; i < input.length; i++) {
				card.add(num.get(input[i]));
				int temp = card.get(i) % 4;
				if (temp == 0) {
					S.add(card.get(i));
				} else if (temp == 1) {
					H.add(card.get(i));
				} else if (temp == 2) {
					D.add(card.get(i));
				} else if (temp == 3) {
					C.add(card.get(i));
				}

			}

			// rule 1,2,3,4
			boolean k = false;
			boolean q = false;
			boolean j = false;
			for (int i : S) {
				String str = name.get(i);
				if (i <= 3) {
					// A
					point += 4;
					s = true;
				} else if (i >= 48) {
					// K
					point += 3;
					k = true;// rule 2
					if (S.size() == 1) {
						point--;
					}
				} else if (i >= 44 && i <= 47) {
					// Q
					point += 2;
					q = true;// rule 3
					if (S.size() <= 2) {
						point--;
					}
				} else if (i >= 40 && i <= 43) {
					// J
					point += 1;
					j = true;// rule 4
					if (S.size() <= 3) {
						point--;
					}
				}
			}
			if (!s) {
				if (k && S.size() >= 2) {
					s = true;
				} else if (q && S.size() >= 3) {
					s = true;
				}
			}

			k = false;
			q = false;
			j = false;

			for (int i : H) {
				String str = name.get(i);
				if (i <= 3) {
					// A
					point += 4;
					h = true;
				} else if (i >= 48) {
					// K
					point += 3;
					k = true;// rule 2
					if (H.size() == 1) {
						point--;
					}
				} else if (i >= 44 && i <= 47) {
					// Q
					point += 2;
					q = true;// rule 3
					if (H.size() <= 2) {
						point--;
					}
				} else if (i >= 40 && i <= 43) {
					// J
					point += 1;
					j = true;// rule 4
					if (H.size() <= 3) {
						point--;
					}
				}
			}
			if (!h) {
				if (k && H.size() >= 2) {
					h = true;
				} else if (q && H.size() >= 3) {
					h = true;
				}
			}

			k = false;
			q = false;
			j = false;

			for (int i : D) {
				String str = name.get(i);
				if (i <= 3) {
					// A
					point += 4;
					d = true;
				} else if (i >= 48) {
					// K
					point += 3;
					k = true;// rule 2
					if (D.size() == 1) {
						point--;
					}
				} else if (i >= 44 && i <= 47) {
					// Q
					point += 2;
					q = true;// rule 3
					if (D.size() <= 2) {
						point--;
					}
				} else if (i >= 40 && i <= 43) {
					// J
					point += 1;
					j = true;// rule 4
					if (D.size() <= 3) {
						point--;
					}
				}
			}

			if (!d) {
				if (k && D.size() >= 2) {
					d = true;
				} else if (q && D.size() >= 3) {
					d = true;
				}
			}

			k = false;
			q = false;
			j = false;

			for (int i : C) {
				String str = name.get(i);
				if (i <= 3) {
					// A
					point += 4;
					c = true;
				} else if (i >= 48) {
					// K
					point += 3;
					k = true;// rule 2
					if (C.size() == 1) {
						point--;
					}
				} else if (i >= 44 && i <= 47) {
					// Q
					point += 2;
					q = true;// rule 3
					if (C.size() <= 2) {
						point--;
					}
				} else if (i >= 40 && i <= 43) {
					// J
					point += 1;
					j = true;// rule 4
					if (C.size() <= 3) {
						point--;
					}
				}
			}
			if (!c) {
				if (k && C.size() >= 2) {
					c = true;
				} else if (q && C.size() >= 3) {
					c = true;
				}
			}

			// finished rule 1,2,3,4
			// check if no trump

			if (point >= 16 && s && h && d && c) {
				System.out.println("BID NO-TRUMP");
			} else {
				// continue rule 5,6,7
				// rule 5

				if (S.size() == 2) {
					point++;
				}
				if (H.size() == 2) {
					point++;
				}
				if (D.size() == 2) {
					point++;
				}
				if (C.size() == 2) {
					point++;
				}

				// rule 6
				if (S.size() == 1) {
					point += 2;
				}
				if (H.size() == 1) {
					point += 2;
				}
				if (D.size() == 1) {
					point += 2;
				}
				if (C.size() == 1) {
					point += 2;
				}

				// rule 7
				if (S.size() == 0) {
					point += 2;
				}
				if (H.size() == 0) {
					point += 2;
				}
				if (D.size() == 0) {
					point += 2;
				}
				if (C.size() == 0) {
					point += 2;
				}

				if (point < 14) {
					System.out.println("PASS");
				} else {
					int max = S.size();
					if (H.size() > max) {
						max = H.size();
					}
					if (D.size() > max) {
						max = D.size();
					}
					if (C.size() > max) {
						max = C.size();
					}

					if (S.size() == max) {
						System.out.println("BID S");
					} else if (H.size() == max) {
						System.out.println("BID H");
					} else if (D.size() == max) {
						System.out.println("BID D");
					} else if (C.size() == max) {
						System.out.println("BID C");
					}

				}

			}
		}

	}
}
