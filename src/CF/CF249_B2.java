package CF;

import java.util.*;

public class CF249_B2 {
	static ArrayList<letter> arr = new ArrayList<letter>();
	static int[] val;
	static ArrayList<Integer> sol = new ArrayList<Integer>();
	static int left;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] num = sc.next().toCharArray();
		left = sc.nextInt();
		sc.close();
		for (int i = 0; i < num.length; i++) {
			arr.add(new letter(num[i] - '0', i));
		}
		Collections.sort(arr);

		for (int i = 0; i < num.length; i++) {
			choose(i);
		}
		
		for (int i = 0; i < sol.size(); i++) {
			System.out.print(sol.get(i));
		}
		System.out.println();
	}

	static void choose(int index) {

		for (int i = 0; i < arr.size(); i++) {
			letter d = arr.get(i);

			if (d.pos - index <= left) {
				arr.remove(i);
				sol.add(d.v);
				left -= (d.pos - index);
				ArrayList<letter> temp = new ArrayList<letter>();
				for (int j = 0; j < arr.size(); j++) {
					letter l = arr.get(j);
					int pos = l.pos;
					if (pos < d.pos && pos >= index)
						pos++;
					temp.add(new letter(l.v, pos));
				}
				arr = temp;
				return;
			}
		}
	}

	public static class letter implements Comparable<letter> {
		int v, pos;

		public letter(int a, int b) {
			v = a;
			pos = b;
		}

		public int compareTo(letter o) {
			if (o.v == this.v)
				return this.pos - o.pos;
			return o.v - this.v;
		}
	}
}
