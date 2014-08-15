package Uva;
import java.util.Arrays;
import java.util.Scanner;


public class UVa11517 {
	static int target;
	static int[] coins;
	static int OO = 1000000000;
	static int[][] dp = new int[101][10001];
	static int[][] dp2 = new int[101][10001];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		
		while(testcases-->0)
		{
			target = sc.nextInt();
			int n = sc.nextInt();
			coins = new int[n];
			
			for (int i = 0; i < n; i++) {
				coins[i] = sc.nextInt();
			}
			
			Arrays.sort(coins);
			
			for (int i = 0; i < 101; i++) {
				for (int j = 0; j < 10001; j++) {
					dp[i][j] = -1;
					dp2[i][j]=-1;
				}
			}
			int sol = exchange(0, 0);
			target = sol;
			System.out.printf("%d %d\n",sol,trace(0,0));	
		}
		sc.close();
	}
	
	
	static int exchange(int idx, int val)
	{
		if(val>=target) return val;
		
		if(idx>=coins.length)
		{
			if(val<target) return OO;
			return val;
		}
		
		if(dp[idx][val]!=-1) return dp[idx][val];
		
		return dp[idx][val]= Math.min(exchange(idx+1, val), exchange(idx+1, val+coins[idx]));
	}
	
	static int trace(int idx,int val)
	{
		if(val>target) return OO;
		if(val==target) return 0;
		
		if(idx>=coins.length)
		{
			if(val!=target) return OO;
			return 0;
		}
		if(dp2[idx][val]!=-1) return dp2[idx][val];
		
		int ch1 = trace(idx+1, val);
		int ch2 = 1+trace(idx+1, val+coins[idx]);
		
		return dp2[idx][val]= Math.min(ch1, ch2);
	}

}
