package Uva;
import java.util.*;
public class UVa907 {
	static int[] comu_dis = new int[610];
	static int[][] dp = new int[610][310];
	static int N,K;
	static int OO = 1000000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			N = sc.nextInt();
			K = 1 + sc.nextInt();
			
			for (int i = 0; i <= N; i++) {
				comu_dis[i] = sc.nextInt();
			}
			// reset dp array
			for(int i=0;i<=N;i++)
				for(int j=0;j<=K;j++)
					dp[i][j] = -1;
			
			System.out.println(minN(0,K));
		}
		
		sc.close();
	}
	
	static int minN(int pos, int nights_left)
	{
		if((nights_left<0)||((N-pos+1)<nights_left)) return OO;
		if(pos>N) return nights_left!=0?OO:0;
		if(dp[pos][nights_left]!=-1) return dp[pos][nights_left];
		
		int min = OO, k =0;
		for (int i = pos; i <= N; i++) {
			k+=comu_dis[i];
			min = Math.min(min,Math.max(k,minN(i+1,nights_left-1)));
		}
		return dp[pos][nights_left] = min;
	}

}
