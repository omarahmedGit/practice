package CF;

import java.util.*;

public class CF250_B2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		int lim = sc.nextInt();
		sc.close();

		Low[] ar = new Low[lim];

		for (int i = 0; i < lim; i++) {
			ar[i] = new Low(i + 1);
		}

		Arrays.sort(ar);

		int left = score;
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (int i = 0; i < ar.length; i++) {
			if (left == 0)
				break;
			if (ar[i].bit <= left) {
				left -= ar[i].bit;
				r.add(ar[i].val);
			}
		}

		if (left == 0) {
			Collections.sort(r);
			System.out.println(r.size());
			for (int i = 0; i < r.size(); i++) {
				System.out.print(r.get(i));
				if (i != r.size() - 1)
					System.out.print(" ");
			}
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}

	public static class Low implements Comparable<Low> {
		int val, bit;

		public Low(int a) {
			val = a;
			for (int i = 0; i < 31; i++) {
				int f = (val & (1 << i));
				if (f != 0) {
					bit = f;
					break;
				}
			}
		}

		public int compareTo(Low o) {
			return o.val - this.val;
		}
	}
}
