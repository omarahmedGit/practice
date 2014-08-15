package Uva;

import java.util.*;
import java.io.*;

public class UVa1235 {

	static int[] calc = new int[502];
	static int[][] lock = new int[502][4];
	static int size;
	static boolean[] vis = new boolean[502];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int oo = 100000;
		for (int i = 0; i < 4; i++)
			lock[0][i] = 0;
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= size; j++) {
				calc[j] = oo;
				vis[j] = false;
				char[] r = st.nextToken().toCharArray();
				for (int k = 0; k < r.length; k++) {
					lock[j][k] = r[k] - '0';
				}
			}
			int sol = precalc();
			pw.println(sol);
		}

		pw.close();
		br.close();
	}

	static class Pair implements Comparable<Pair> {
		int a, b;

		Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}

		@Override
		public int compareTo(Pair o) {
			return this.b - o.b;
		}

	}

	static int precalc() {
		// index 0 for 0000
		int x=0,y=1000000;
		for (int i = 1; i <= size; i++) {
			int d = dif(0,i);
			if(d<y)
			{
				y = d;
				x = i;
			}
		}
		
		int count = 0;

		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(x, y));
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			if (vis[cur.a])
				continue;
			vis[cur.a] = true;
			count += cur.b;
			for (int i = 1; i <= size; i++) {
				if (i != cur.a) {
					int d = dif(cur.a, i);
					if (!vis[i]&&d < calc[i]) {
						calc[i] = d;
						q.add(new Pair(i, calc[i]));
					}
				}
			}
		}

		return count;
	}

	static int dif(int a, int b) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int c = Math.abs(lock[a][i] - lock[b][i]);
			if (c > 5)
				c = 10 - c;
			count += c;
		}

		return count;
	}

}
