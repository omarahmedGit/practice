package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Uva11790 {
	static int[] h,w,LI,LD;
	static int[][] dp;
	static int ca = 1,n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testC = Integer.parseInt(st.nextToken());
		h = new int[3000];
		w = new int[3000];
		LD = new int[3000];
		LI = new int[3000];
		for (int i = 0; i < testC; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				h[j]= Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[j]= Integer.parseInt(st.nextToken());
			}
			tabe_method();
			/* USING RECURSING TLE */
			/*
			dp = new int[n+2][n+2];
			
			for (int j = 0; j < n+1; j++) {
				Arrays.fill(dp[j], -1);
			}
			int inc = LIS(1,0);
			h[0]=Integer.MAX_VALUE;
			for (int j = 0; j < n+1; j++) {
				Arrays.fill(dp[j], -1);
			}
			int dec = LDS(1,0);
			if(dec>inc)
				System.out.printf("Case %d. Decreasing (%d). Increasing (%d).\n",i+1,dec,inc);
			else
				System.out.printf("Case %d. Increasing (%d). Decreasing (%d).\n",i+1,inc,dec);
				*/
		}
		br.close();
	}
	
	
	static int LIS(int i, int j)
	{
		if(i==h.length||j==h.length) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int ch1 = LIS(i+1,j);
		int ch2 = 0;
		
		if(h[j]<h[i])
			ch2 = w[i]+LIS(i+1,i);
		
		return dp[i][j] = Math.max(ch1, ch2);
	}
	
	static int LDS(int i, int j)
	{
		if(i==h.length||j==h.length) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int ch1 = LDS(i+1,j);
		int ch2 = 0;
		
		if(h[j]>h[i])
			ch2 = w[i]+LDS(i+1,i);
		
		return dp[i][j] = Math.max(ch1, ch2);
	}
	
	static void tabe_method()
	{
		int max_i = 0,max_d=0;
		
		for (int i = 0; i < n; i++) {
			LI[i] = LD[i] = w[i];
			for (int j = 0; j < i; j++) {
				if(h[i]>h[j])
					LI[i] = Math.max(LI[i], w[i]+LI[j]);
				if(h[i]<h[j])
					LD[i] = Math.max(LD[i], w[i]+LD[j]);
			}
			
			max_i = Math.max(max_i, LI[i]);
			max_d = Math.max(max_d, LD[i]);
		}
		
		if(max_d>max_i)
			System.out.printf("Case %d. Decreasing (%d). Increasing (%d).\n",ca++,max_d,max_i);
		else
			System.out.printf("Case %d. Increasing (%d). Decreasing (%d).\n",ca++,max_i,max_d);	
		
		
	}

}
