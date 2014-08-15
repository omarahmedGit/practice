package Uva;
import java.util.*;

public class Uva10616 {
	static int n, m, Q;
	static long[] ar = new long[202];
	static long[][][] dp = new long[202][25][15];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q, idx = 1;
		while (true) {
			n = sc.nextInt();
			q = sc.nextInt();
			if (n == 0 && q == 0)
				break;

			for (int i = 0; i < n; i++) {
				ar[i] = sc.nextLong();
			}

			System.out.printf("SET %d:\n", idx++);
			for (int i = 0; i < q; i++) {
				Q = sc.nextInt();
				m = sc.nextInt();
				for (int j = 0; j < n; j++) {
					for (int j2 = 0; j2 < Q; j2++) {
						for (int k = 0; k < m; k++) {
							dp[j][j2][k] = -1;
						}
					}
				}
				System.out.printf("QUERY %d: %d\n", i + 1, group(0, 0, 0));
			}

		}

		sc.close();
	}

	static long group(int idx, int rem, int tak) {
		if (tak == m)
			return rem == 0 ? 1 : 0;

		if (idx == n)
			return 0;

		if (dp[idx][rem][tak] != -1)
			return dp[idx][rem][tak];
		
		int xs = mod(rem+mod(ar[idx],Q),Q);
		
		return dp[idx][rem][tak] = group(idx + 1, rem, tak)+ group(idx + 1, xs, tak + 1);
	}

	static int mod(long a, int b) {
		return (int) ((a%b)+b)%b;
	}

}
