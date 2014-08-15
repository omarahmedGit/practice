package TC;

public class SRM_610_1000 {

	static int M,N,T;
	static int[][][] dp = new int[50][50][51];
	static int[] event_i,event_j;

	public static void main(String args[])
	{
		int[] a = {0,3,3};
		int[] b = {0,3,0};
		
		System.out.println(GetMaximumGold(3, 3, a, b));

	}

	static int abs(int a)
	{
		return Math.abs(a);
	}

	static int f(int a,int b,int s)
	{
		if(dp[a][b][s]!=-1) return dp[a][b][s];

		if(s==T) return dp[a][b][s] = 0;

		int x = M+N - abs(event_i[a]-event_i[s]) - abs(event_j[b]-event_j[s]) ;

		int res = 0;

		for(int an=0;an<event_i.length;an++)
			res = Math.max(res, x + f(an,b,s+1));
		for(int bn=0;bn<event_i.length;bn++)
			res = Math.max(res, x + f(a,bn,s+1));

		return dp[a][b][s] = res;
	}

	public static int  GetMaximumGold(int m,int n, int[] event_a,int[] event_b)
	{
		M = m;
		N = n;
		T = event_a.length;
		
		event_i = event_a;
		event_j = event_b;
		for(int i=0;i<50;i++)
			for(int j=0;j<50;j++)
				for(int k=0;k<51;k++)
					dp[i][j][k] = -1;
		int max = 0;

		for (int a=0; a<event_i.length;a++) {
			for (int b=0;b<event_i.length;b++) {
				max = Math.max(max,f(a,b,0));
			}
		}

		return max;
	}





}