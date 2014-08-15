package Uva;
import java.util.*;
public class UVa10913 {
	static int N,K;
	static int[][] graph = new int[80][80];
	static int[] states = {0,1,2};
	static int[] _x = {0 ,1, 0};
	static int[] _y = {-1,0, 1};
	static int OO = 1000000000;
	static int[][][][] dp = new int[80][80][6][3];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 0;
		while(sc.hasNext())
		{
			N = sc.nextInt();
			K = sc.nextInt();
			if(N==0&K==0) break;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i < 80; i++)
				for (int j = 0; j < 80; j++)
					for (int k = 0; k < 6; k++)
						for (int h = 0; h < 3; h++)
							dp[i][j][k][h] = -1;
						
			int sol = maxSum(0, 0, K, 1);
			if(sol==-OO)
				System.out.printf("Case %d: impossible\n",++t);
			else
				System.out.printf("Case %d: %d\n",++t,sol);
			
			
		}
		
		sc.close();
	}
	
	static int maxSum(int x,int y,int k_left,int state)
	{
		if((k_left<0)||(y<0)||(y>=N)||(x>=N)) return -OO;
		
		if(x==N-1&&y==N-1) {
			if(k_left==0&&graph[x][y]<0) return -OO;
			return graph[x][y];
		}
		
		if(dp[x][y][k_left][state]!=-1) return dp[x][y][k_left][state];
		
		int max = -OO, key = graph[x][y]<0 ? k_left-1:k_left;
		
		
		for (int i = 0; i < 3; i++) {
			if((state==0&i==2)||(state==2&i==0)) continue ;
			max = Math.max(max,maxSum(x+_x[i],y+_y[i],key,states[i]));
		}
		
		if(max!=-OO) max+=graph[x][y];
		
		return  dp[x][y][k_left][state] = max;
		
	}

}
