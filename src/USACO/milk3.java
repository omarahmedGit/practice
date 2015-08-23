package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
ID: omarahm1
LANG: JAVA
TASK: milk3 
*/

public class milk3 {

	public static class triple {
		int a, b, c;

		triple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("milk3.in"));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		br.close();
		
		boolean[][][] state = new boolean[21][21][21];

		Queue<triple> q = new LinkedList<triple>();
		q.add(new triple(0, 0, c));
		state[0][0][c] = true;

		boolean[] ret = new boolean[21];
		ret[c] = true;
		while (!q.isEmpty()) {
			triple cur = q.poll();

			int aa, bb, cc;

			if (cur.a != a) {
				if (cur.b > 0) {
					if (cur.b >= a - cur.a) {
						aa = a;
						bb = cur.b - (a - cur.a);
					} else {
						aa = cur.b + cur.a;
						bb = 0;
					}
					if (!state[aa][bb][cur.c]) {
						state[aa][bb][cur.c] = true;
						q.add(new triple(aa, bb, cur.c));
					}
				}

				if (cur.c > 0) {
					if (cur.c >= a - cur.a) {
						aa = a;
						cc = cur.c - (a - cur.a);
					} else {
						aa = cur.c + cur.a;
						cc = 0;
					}
					if (!state[aa][cur.b][cc]) {
						state[aa][cur.b][cc] = true;
						q.add(new triple(aa, cur.b, cc));
					}
				}

			}

			if (cur.b != b) {
				if (cur.a > 0) {
					if (cur.a >= b - cur.b) {
						bb = b;
						aa = cur.a - (b - cur.b);
					} else {
						bb = cur.b + cur.a;
						aa = 0;
					}
					if (!state[aa][bb][cur.c]) {
						state[aa][bb][cur.c] = true;
						q.add(new triple(aa, bb, cur.c));
						if (aa == 0)
							ret[cur.c] = true;
					}
				}

				if (cur.c > 0) {
					if (cur.c >= b - cur.b) {
						bb = b;
						cc = cur.c - (b - cur.b);
					} else {
						bb = cur.c + cur.b;
						cc = 0;
					}
					if (!state[cur.a][bb][cc]) {
						state[cur.a][bb][cc] = true;
						q.add(new triple(cur.a, bb, cc));
						if (cur.a == 0)
							ret[cc] = true;
					}
				}

			}

			if (cur.c != c) {
				if (cur.b > 0) {
					if (cur.b >= c - cur.c) {
						cc = c;
						bb = cur.b - (c - cur.c);
					} else {
						cc = cur.b + cur.c;
						bb = 0;
					}
					if (!state[cur.a][bb][cc]) {
						state[cur.a][bb][cc] = true;
						q.add(new triple(cur.a, bb, cc));
						if (cur.a == 0)
							ret[cc] = true;
					}
				}

				if (cur.a > 0) {
					if (cur.a >= c - cur.c) {
						cc = c;
						aa = cur.a - (c - cur.c);
					} else {
						cc = cur.c + cur.a;
						aa = 0;
					}
					if (!state[aa][cur.b][cc]) {
						state[aa][cur.b][cc] = true;
						q.add(new triple(aa, cur.b, cc));
						if (aa == 0)
							ret[cc] = true;
					}
				}

			}
		}
		int sol = 0;
		for (int i = 0; i < ret.length; i++) {
			if (ret[i])
				sol++;
		}
		PrintWriter pw = new PrintWriter(new FileWriter("milk3.out"));

		int res = 0;
		for (int i = 0; i < ret.length; i++) {
			if (ret[i]) {
				res++;
				pw.print(i);
				if (res != sol)
					pw.print(" ");
			}
		}
		pw.println();
		pw.close();

	}
}
