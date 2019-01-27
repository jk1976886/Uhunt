import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10755 {

	public static int[][][] heap;
	public static int a, b, c;

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int test = Integer.parseInt(reader.readLine());
		reader.readLine();

		for (int p = 0; p < test; p++) {
			String[] ABC = reader.readLine().split(" ");
			a = Integer.parseInt(ABC[0]);
			b = Integer.parseInt(ABC[1]);
			c = Integer.parseInt(ABC[2]);
			heap = new int[a][b][c];

			String[] num = reader.readLine().split(" ");
			int counter = 0;

			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					for (int q = 0; q < c; q++) {
						heap[i][j][q] = Integer.parseInt(num[counter]);
						counter++;
					}
				}
			}

			if (reader.ready()) {
				reader.readLine();
			}
		}

	}
}
