package Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class UVa11906 {
	static int row, col, a, b, odd, even;
	static boolean[][] world = new boolean[101][101];
	static boolean[][] vis = new boolean[101][101];
	static int[] xs = new int[4];
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int _x, _y, water, testCases = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int i = 0; i < testCases; i++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			water = Integer.parseInt(br.readLine());
			reset();
			xs[0] = -a;
			xs[1] = a;
			xs[2] = -b;
			xs[3] = b;

			for (int j = 0; j < water; j++) {
				st = new StringTokenizer(br.readLine());
				_x = Integer.parseInt(st.nextToken());
				_y = Integer.parseInt(st.nextToken());
				world[_x][_y] = true;
			}
			king(i + 1);
		}
		br.close();
		pw.close();
	}

	static void king(int C) {
		even = odd = 0;
		int collect;
		int c, d;
		Queue<node> q = new LinkedList<node>();
		q.add(new node(0, 0));
		int i, j;
		int test_b = 2,test_a = 2;
		while (!q.isEmpty()) {
			node s = q.poll();
			i = s.a;
			j = s.b;
			if (vis[i][j])
				continue;
			vis[i][j] = true;
			collect = 0;
			test_a = a==0?1:2;
			test_b = b==0?3:4;
			for (int j2 = 0; j2 < test_a; j2++) {
				c = i + xs[j2];
				for (int k = 2; k < test_b; k++) {
					d = j + xs[k];
					if (!(c < 0 || d < 0 || c >= row || d >= col)) {
						if (!world[c][d]) {
							q.add(new node(c, d));
							collect++;
						}

					}
				}
			}
			if (a != b) {
				test_a = a==0?1:2;
				test_b = b==0?3:4;
				for (int j2 = 2; j2 < test_b; j2++) {
					c = i + xs[j2];
					for (int k = 0; k < test_a; k++) {
						d = j + xs[k];
						if (!(c < 0 || d < 0 || c >= row || d >= col)) {
							if (!world[c][d]) {
								q.add(new node(c, d));
								collect++;
							}

						}
					}
				}
			}
			if (collect % 2 == 0)
				even++;
			else
				odd++;

		}
		pw.printf("Case %d: %d %d\n", C, even, odd);
	}

	static void reset() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				world[i][j] = vis[i][j] = false;
			}
		}
	}

	public static class node {
		int a, b;

		public node(int a, int b) {
			this.a = a;
			this.b = b;
		}

	}

}
