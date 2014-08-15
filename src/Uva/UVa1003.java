package Uva;

import java.io.*;
import java.util.*;

public class UVa1003 {
	static int oo = 1000000000;
	static int[] len = new int[1010];
	static int[][] dp = new int[1000][1000];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					dp[i][j]=-1;
			
			len[0] = 0;
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= m; i++) {
				len[i] = Integer.parseInt(st.nextToken());
			}
			len[m+1] = n;
			
			int ans = cut_stick(0,m+1);
			pw.printf("The minimum cutting is %d.\n",ans);
		}
		
		
		pw.close();
		br.close();
	}
	
	
	static int cut_stick(int l,int r)
	{
		if(l==r-1)
			return 0;
		
		
		if(dp[l][r]!=-1) return dp[l][r];
		
		int min = oo;
		int val = len[r]-len[l];
		for(int i=l+1;i<r;i++){
			min = Math.min(min, cut_stick(l,i)+cut_stick(i,r)+val);
		}
			
		
		return dp[l][r] = min;
	}

}
