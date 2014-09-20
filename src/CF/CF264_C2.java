package CF;

import java.util.*;
import java.io.*;

public class CF264_C2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = (n * 2) - 1;
		long[] ri = new long[m];
		long[] le = new long[m];

		int[][] val = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = i, h = n - i - 1, lo = 0; lo < n & k < m; h++, lo++, k++) {
				int x = val[i][lo] = Integer.parseInt(st.nextToken());
				ri[k] += x;
				le[h] += x;
			}
		}
		br.close();

		ArrayList<cell> vv = new ArrayList<cell>();

		for (int i = 0; i < n; i++) {
			for (int j = 0, h = n - i - 1; j < n; h++, j++) {
				long v = ri[i + j] + le[h];
				v -= ((long) val[i][j]);
				vv.add(new cell((i * n) + j, v));
			}
		}

		cell xd = new cell(0, new Long("-1"));
		for (int i = 0; i < vv.size(); i++) {
			cell xx = vv.get(i);
			if (xx.val > xd.val) {
				xd = xx;
			}
		}
		
		cell xa = new cell(0, new Long("-1"));

		int x1 = xd.x / n, x2, y1 = xd.x % n, y2;
		for (int i = 0; i < vv.size(); i++) {
			cell xx = vv.get(i);
			if (xx.x != xd.x) {
				x2 = xx.x / n;
				y2 = xx.x % n;
				if ((Math.abs(x1 - x2) + Math.abs(y1 - y2)) % 2 == 1) {
					if (xa.val < xx.val)
						xa = xx;
				}
			}
		}

		System.out.println(xa.val + xd.val);
		System.out.printf("%d %d %d %d\n", (xa.x / n) + 1, (xa.x % n) + 1,
				(xd.x / n) + 1, (xd.x % n) + 1);
	}

	public static class cell implements Comparable<cell> {
		int x;
		Long val;

		public cell(int a, Long v) {
			x = a;
			val = v;
		}

		@Override
		public int compareTo(cell o) {
			if (this.val == o.val)
				return 0;
			return this.val < o.val ? 1 : -1;
		}

	}

}
