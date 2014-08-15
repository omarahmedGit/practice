package Uva;
import java.util.Arrays;
import java.util.Scanner;


public class Uva10721 {
	static int n,k,m;
	static long[][] dp = new long[55][100];
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			n = sc.nextInt();
			k = sc.nextInt();
			m = sc.nextInt();
			for (int i = 0; i < 55; i++)
				Arrays.fill(dp[i], -1);
			long sol = BC(0,0);
			System.out.println(sol);
		}
		
		sc.close();
	}
	
	
	static long BC(int idx,int sum)
	{	
		
		if(sum >  n) return 0; 
		
		if(idx >= k)
			return sum==n?1:0;
		
		if(dp[idx][sum]!=-1) return dp[idx][sum];
		
		long sol = 0;
		
		for (int i = 1; i <= m; i++) sol += BC(idx+1,sum+i);
		
		return dp[idx][sum] = sol;
	}
	
}
