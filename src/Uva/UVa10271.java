package Uva;

import java.io.*;
import java.util.*;

public class UVa10271 {
	static int[] sticks = new int[5010];
	static int[][] dp = new int[5010][1010];
	static int size, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			N = 8 + Integer.parseInt(st.nextToken());
			size = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				sticks[j] = Integer.parseInt(st.nextToken());
				for (int j2 = 0; j2 < N; j2++) {
					dp[j][j2] = -1;
				}
			}
			pw.println(min(0, 0));

		}

		pw.close();
		br.close();

	}
	
	static int min(int n,int k)
	{
		if(k==N)
			return 0;
		
		if(dp[n][k]!=-1) return dp[n][k];
		int dif  = sticks[n+1] - sticks[n];
		int sol1  = (dif*dif)+min(n+2,k+1);
		int sol2  = 1000000000;
		
		if(size-(n+1)>=((N-k)*3))
			sol2 = min(n+1,k);
		
		
		return dp[n][k] = Math.min(sol1, sol2);
	}
	
}
