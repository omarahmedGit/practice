package CF;
import java.util.*;
public class rokethon_2014_b {
	static char[] input;
	static int[] pre;
	static int[][] dp = new int[1000][1000];
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		input = sc.next().toCharArray();
		pre = new int[input.length];
		calpre();
		
		
		sc.close();
	}
	
	
	static int dp(int l ,int r)
	{
		if(dp[l][r]!=-1) return dp[l][r];
		int max = -1;
		for (int i = l+1; i < r; i++) {
			
			max = Math.max(max, dp(l,i)+dp(i+1,r));
		}
		
		return 0;
	}
	
	
	static void calpre()
	{
		int[] let = new int[27];
		for(int i =0;i<27;i++) let[i] =-1;
		for (int i = 0; i < input.length; i++) {
			int x = let[input[i]-'A'];
			let[input[i]-'A'] = i;
			if(x==-1)
				continue;
			pre[x] = i;
		}
	}
}
