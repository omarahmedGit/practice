package CF;

import java.io.*;
import java.util.*;

public class CF254_A2 {
	static int[][] vis;
	static int n, m;
	static int[] _x = { 0, 0, 1, -1 };
	static int[] _y = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		vis = new int[n][m];
		// 1 for B
		// 2 for W
		// 0 Good unvisited Cell
		// -1 bad cell
		for (int i = 0; i < n; i++) {
			char[] line = br.readLine().toCharArray();
			for (int k = 0; k < line.length; k++) {
				vis[i][k] = line[k] == '.' ? 0 : -1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] == 0) {
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int x = vis[i][j];
				if (x == 1)
					System.out.print("B");
				else if (x == 2)
					System.out.print("W");
				else
					System.out.print("-");
			}
			System.out.println();
		}

		br.close();
	}

	public static void bfs(int i, int j) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(i, j));

		vis[i][j] = 1;
		while (!q.isEmpty()) {
			Pair cur = q.poll();
			int in = vis[cur.a][cur.b] == 1 ? 2 : 1;
			for (int k = 0; k < 4; k++) {
				if (valid(cur.a + _x[k], cur.b + _y[k])) {
					if (vis[cur.a + _x[k]][cur.b + _y[k]] == 0) {
						vis[cur.a + _x[k]][cur.b + _y[k]] = in;
						q.add(new Pair(cur.a + _x[k], cur.b + _y[k]));
					}
				}
			}
		}
	}

	public static boolean valid(int i, int j) {
		return i > -1 & j > -1 & i < n & j < m;
	}

	public static class Pair {
		int a, b;

		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

}
