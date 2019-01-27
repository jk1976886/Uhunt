import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UVA10114 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String[] line = reader.readLine().split(" ");
			int month = Integer.parseInt(line[0]);
			double downpayment = Double.parseDouble(line[1]);
			double own = Double.parseDouble(line[2]);
			int entry = Integer.parseInt(line[3]);

			if (month < 0) {
				break;
			}

			double[] dep = new double[month + 1];

			for (int i = 0; i < entry; i++) {
				String[] l = reader.readLine().split(" ");
				dep[Integer.parseInt(l[0])] = Double.parseDouble(("0" + l[1]));
			}

			double curVal = own + downpayment;
			double payment = own / month;
			int counter = 0;
			// own -= payment;
			curVal *= (1.0 - dep[0]);
			while (curVal <= own && counter <= month) {
				own -= payment;
				if (dep[counter + 1] == 0) {
					dep[counter + 1] = dep[counter];
				}
				curVal *= (1.0 - dep[counter + 1]);
				counter++;
			}
			if (counter == 1) {
				System.out.println("1 month");
			} else {
				System.out.println(counter + " months");
			}
		}

	}
}
