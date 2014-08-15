package Uva;
import java.util.Scanner;


public class UVa10306 {
	static int[][][] dp = new int[41][301][301];
	static node[] coins1;
	static int OO=10000000,target;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0)
		{
			int n = sc.nextInt();
			target = sc.nextInt();
			coins1 = new node[n];
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b =sc.nextInt();
				coins1[i] = new node(a,b);
			}
			
			for (int i = 0; i < 41; i++) {
				for (int j = 0; j < 301; j++) {
					for (int j2 = 0; j2 < 301; j2++) {
						dp[i][j][j2] = -1;
					}
				}
			}
			target*=target;
			int sol = dpcoins(0, 0, 0);
			if(sol>=OO)
				System.out.println("not possible");
			else
				System.out.println(sol);
			
			
		}
		sc.close();
	}
	
	static int sum(int a,int b)
	{
		return a*a+b*b;
	}
	
	static int dpcoins(int idx,int x, int y)
	{
		if(sum(x,y)>target)
			return OO;
		
		if(sum(x,y)==target)
			return 0;
		
		if(idx>=coins1.length)
		{
			if(sum(x,y)==target) return 0;
			return OO;
		}
		
		if(dp[idx][x][y]!=-1) return dp[idx][x][y];
		
		return dp[idx][x][y] = Math.min(dpcoins(idx+1,x,y), 1+dpcoins(idx,x+coins1[idx].a,y+coins1[idx].b));
	}
	
	
	static class node implements Comparable<node>
	{
		int a,b,m;
		
		public node(int aa,int bb) {
			a = aa;
			b = bb;
			m = (a*a)+(b*b);
		}
		

		@Override
		public int compareTo(node o) {
			// TODO Auto-generated method stub
			return m-o.m;
		}
	}

}
