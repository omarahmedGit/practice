package Uva;

import java.util.*;
import java.io.*;

public class UVa607 {
	static int lecsize, mlec, DI;
	static long[][] dp = new long[1001][1001];
	static long oo = 1000000;
	static int[] lec = new int[1001];

	static void gen() {
		for (int i = 0; i <= lecsize; i++) {
			for (int j = 0; j <= lecsize; j++) {
				dp[i][j] = oo;
			}
		}
		dp[0][0] = 0;
		for (int j = 0; j <= lecsize; j++) {
			for (int i = 0; i <= lecsize; i++) {
				if (dp[i][j] >= oo)
					continue;
				for (int j2 = i + 1; j2 <= lecsize; j2++) {
					long d = lec[j2] - lec[i];
					long t = mlec - d;
					long s = oo;

					if (t >= 0) {
						if (t == 0)
							s = 0;
						else if (t <= 10)
							s = -DI;
						else
							s = (t - 10) * (t - 10);
					} else
						break;

					dp[j2][j + 1] = Math.min(dp[i][j] + s, dp[j2][j + 1]);
				}

			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = 0;
		while (true) {
			st = new StringTokenizer(br.readLine());
			lecsize = Integer.parseInt(st.nextToken());
			if (lecsize == 0)
				break;
			st = new StringTokenizer(br.readLine());
			mlec = Integer.parseInt(st.nextToken());
			DI = Integer.parseInt(st.nextToken());
			lec[0] = 0;
			for (int i = 1; i <= lecsize; i++) {
				st = new StringTokenizer(br.readLine());
				lec[i] = Integer.parseInt(st.nextToken()) + lec[i - 1];
			}
			gen();
			long minl = 0, mindi = 0;
			for (int i = 1; i <= lecsize; i++) {
				if (dp[lecsize][i] < oo) {
					minl = i;
					mindi = dp[lecsize][i];
					break;
				}
			}
			if (t != 0)
				pw.println();
			pw.printf("Case %d:\n", ++t);
			pw.printf("Minimum number of lectures: %d\n", minl);
			pw.printf("Total dissatisfaction index: %d\n", mindi);
		}

		pw.close();
		br.close();
	}

}