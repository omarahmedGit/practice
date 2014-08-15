package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class Uva348 {
	static node[] matrix = new node[11];
	static long[][] dp = new long[15][15];
	static int[][] minindex = new int[15][15];
	public static void main(String[] args) throws IOException {
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int testcases = 1;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 0) break;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				long a = Long.parseLong(st.nextToken());
				long b = Long.parseLong(st.nextToken());
				matrix[i] = new node(a,b);
			}
			for (int i = 0; i < 15; i++) {
				for (int j = 0; j < 15; j++) {
					dp[i][j] = -1;
				}
			}
			nested(0,n-1);
			pw.printf("Case %d: ",testcases++);
			pw.println(trace(0,n-1));
		}
		pw.close();
	}
	
	public static long nested(int s ,int e)
	{
		if(s==e)
			return 0;
		if(s+1==e)
			return matrix[s].a*matrix[s].b*matrix[e].b;
		if(dp[s][e]!=-1) return dp[s][e];
		
		long min  = 10000000000L;
		int minidx = 0;
		for (int i = s; i < e; i++) {
			long sol = nested(s,i) + nested(i+1,e)  + (matrix[s].a*matrix[i].b*matrix[e].b);
			minidx = sol<min ? i: minidx;
			min = Math.min(min,sol);
		}
		minindex[s][e] = minidx;
		return dp[s][e] = min;
	}
	
	public static String trace(int s, int e)
	{
		if(s==e)
			return "A"+(s+1);
		if(s+1==e)
			return "(A"+(s+1)+" x A"+(e+1)+")";
		
		int sol = minindex[s][e];
		
		return "(" + trace(s, sol) +" x " +trace(sol+1, e)+")" ;
	}
	
	public static class node 
	{
		long a , b;
		public node(long a , long b) {
			this.a = a;
			this.b = b;
		}
	}
}
