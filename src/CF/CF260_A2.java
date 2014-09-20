package CF;

import java.util.*;

public class CF260_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pair[] a = new Pair[n];
		for (int i = 0; i < n; i++) {
			a[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		sc.close();
		Arrays.sort(a);
		Pair pair = a[0];

		for (int i = 1; i < a.length; i++) {
			if (a[i].b > pair.b)
				pair = a[i];
			else {
				System.out.println("Happy Alex");
				return;
			}
		}
		
		System.out.println("Poor Alex");

	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.a == o.a)
				return this.b - o.b;
			return this.a - o.a;
		}

	}

}
