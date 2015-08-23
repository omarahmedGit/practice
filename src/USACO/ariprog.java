package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/*
 ID: omarahm1
 LANG: JAVA
 TASK: ariprog 
 */

public class ariprog {
	static HashSet<Integer> hash;
	static ArrayList<Integer> bi;

	static void prepare(int m) {
		int max = 2 * m * m;
		int len = (m * m) + 1;

		boolean[] uni = new boolean[len];

		for (int i = 0; i <= m; i++) {
			int x = i * i;
			if (x < uni.length)
				uni[x] = true;
		}

		ArrayList<Integer> u = new ArrayList<Integer>();

		for (int i = 0; i < uni.length; i++) {
			if (uni[i])
				u.add(i);
		}

		bi = new ArrayList<Integer>();
		hash = new HashSet<Integer>();
		for (int i = 0; i < u.size(); i++) {
			for (int j = i; j < u.size(); j++) {
				int add = u.get(i) + u.get(j);
				if (add <= max) {
					if (!hash.contains(add)) {
						hash.add(add);
						bi.add(add);
					}
				}

			}
		}

		Collections.sort(bi);
	}

	public static class Pair implements Comparable<Pair> {
		int start, step;

		public Pair(int a, int b) {
			start = a;
			step = b;
		}

		public int compareTo(Pair o) {
			if (o.step == this.step)
				return this.start - o.start;
			return this.step - o.step;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("ariprog.in"));
//		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		br.close();

		prepare(m);

		ArrayList<Pair> ret = new ArrayList<Pair>();

		int len = bi.size();
		int max = 2 * m * m;
		
		int lem1 = len-n+1;
		int lem2 = len-n+2;
		
		for (int i = 0; i < lem1; i++) {

			int startp = bi.get(i);

			if (startp >= max)
				break;

			for (int j = i + 1; j < lem2; j++) {
				int steps = bi.get(j) - startp;
				
				if(((n-1)*steps)+startp>max) continue;
				
				int next = startp;
				int count = 0;
				
				while (next <= max && hash.contains(next) && count < n) {
					count++;
					next += steps;
				}

				if (count == n) {
					ret.add(new Pair(startp, steps));
				}
			}
		}

		Collections.sort(ret);
		PrintWriter pw = new PrintWriter(new FileWriter("ariprog.out"));
//		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		 
		for (int i = 0; i < ret.size(); i++) {
			Pair cur = ret.get(i);
			pw.printf("%d %d\n", cur.start, cur.step);
		}

		if (ret.size() == 0)
			pw.println("NONE");

		pw.close();

	}

}
