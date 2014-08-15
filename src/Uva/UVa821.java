package Uva;
import java.util.*;

public class UVa821 {
	static int oo = 1000000000;
	static int[][] adjList = new int[102][102];
	static boolean[] vis = new boolean[102];

	static void floyed(int test)
	{
		for(int i=1;i<=100;i++)
			for(int j=1;j<=100;j++)
				for(int k=1;k<=100;k++)
					adjList[j][k] = Math.min(adjList[j][k],adjList[j][i]+adjList[i][k]);

		int sum = 0,num=0 ,pair = 0;
		for(int i=1;i<=100;i++)
			for(int j=1;j<=100;j++)
				if(adjList[i][j]!=oo) sum+=adjList[i][j];
		
		for(int i=1;i<=100;i++)
			if(vis[i])
				num++;
		for (int i=1; i<num; i++) {
			pair+=i;
		}
		pair*=2;
		double sol = sum;
		sol/=(double)pair;
		System.out.printf("Case %d: average length between pages = %.3f clicks\n",test,sol);


	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,c=0,test=0;
		while(c<2)
		{
			for (int i=1;i<101;i++){
				vis[i]=false;
				for(int j=1;j<101;j++)
					adjList[i][j] = i==j?0:oo;
			}
			
			test++;
			
			while(true)
			{
				a = sc.nextInt();
				b = sc.nextInt();
				if(a==0&b==0)
				{
					c++;
					break;
				}
				c=0;
				vis[a]=vis[b]=true;
				adjList[a][b] = 1;
			}
			if(c==1)
			{
				floyed(test);
			}

		}
		sc.close();
	}

}
