import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

public class UVA481_Correct {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		LinkedList<Integer> lst = new LinkedList<Integer>();
		while (true) {
			String s = in.readLine();
			if (s == null)
				break;
			s = s.trim();
			if (s.length() == 0)
				continue;
			int n = Integer.parseInt(s);
			lst.add(n);
		}
		int[] arr = new int[lst.size()];
		int top = 0;
		for (int i : lst)
			arr[top++] = i;
		int[] best = new int[arr.length];
		int[] index = new int[arr.length];
		int[] parent = new int[arr.length];
		Arrays.fill(best, Integer.MAX_VALUE);
		for (int i = 0; i < arr.length; i++) {
			int l = 0;
			int len = arr.length - 1;
			while (len > 0) {
				len /= 2;
				if (best[l + len] < arr[i])
					l += len + 1;
			}
			if (best[l] > arr[i]) {
				index[l] = i;
				best[l] = arr[i];
				parent[i] = (l - 1 < 0) ? -1 : index[l - 1];
			}
		}
		Stack<Integer> rev = new Stack<Integer>();
		for (int i = arr.length - 1; i >= 0; i--) {
			if (best[i] != Integer.MAX_VALUE) {
				int ind = index[i];
				while (ind != -1) {
					rev.push(arr[ind]);
					ind = parent[ind];
				}
				break;
			}
		}
		System.out.println(rev.size());
		System.out.println("-");
		while (!rev.isEmpty())
			System.out.println(rev.pop());

	}
}
