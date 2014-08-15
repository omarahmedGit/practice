package Uva;
import java.util.*;
public class UVA10819 {
	static ArrayList<pair> arr;
	static int[][]dp = new int[105][505];
	static int n,m;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			n = sc.nextInt();
			if(n+200>2000) n+=200;
			m = sc.nextInt();
			arr = new ArrayList<pair>();
			for (int i = 0; i < m; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				arr.add(new pair(a,b));
			}
			ArrayList<Integer> T = new ArrayList<Integer>();
			for (int i = 0; i < 105; i++) {
				for (int j = 0; j < 505; j++) {
					dp[i][j]=-1;
				}
			}
			int ix =0;
			for (int i = 500; i >-1 ; i--) 
			{
				int sol = dots(0,i);
				T.add(sol);
				if(sol<=n)
				{
					if(!((sol<2000&&(n-200>=sol|n<2000))|sol>2000)) continue;
					ix = 500-i;
					break;
				}
			}
			int yix = 500 - ix; 			
			System.out.println(yix);
		}
		sc.close();
	}
	
	static int dots(int idx,int rem)
	{
		if(idx==m&&rem==0)
			return 0;
		if(idx==m||rem<0)
			return 100000000;
			
		if(dp[idx][rem]!=-1) return dp[idx][rem];
		
		int ch1 = dots(idx+1,rem);
		int ch2 = 100000000;
		
		int amount = rem-arr.get(idx).f;
		
		if(amount>=0)
			ch2  = arr.get(idx).p+dots(idx+1,amount);
		
		return dp[idx][rem] = Math.min(ch1, ch2);
	}
	
	static class pair
	{
		int f,p;
		public pair(int pp,int ff) {
			p = pp;
			f = ff;
		}
	}

}
