package Uva;
import java.util.*;
import java.io.*;
public class UVa11463 {
	static int[][] adjList = new int[100][100];
	static int oo = 1000000000;
	static void floyed()
	{
		for(int i=0;i<100;i++)
			for(int j=0;j<100;j++)
				for(int k=0;k<100;k++)
					adjList[j][k] = Math.min(adjList[j][k],adjList[j][i]+adjList[i][k]);


	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int t = Integer.parseInt(br.readLine());
		int vertex , edges , a, b ;
		for (int i=1; i<=t; i++) {
			for(int k=0;k<100;k++)
				for(int j=0;j<100;j++)
					adjList[k][j] = k==j?0: oo;
			vertex = Integer.parseInt(br.readLine());
			edges = Integer.parseInt(br.readLine());

			for (int j=0;j<edges;j++) {
				st = new StringTokenizer(br.readLine());
				a  = Integer.parseInt(st.nextToken());
				b  = Integer.parseInt(st.nextToken());
				adjList[a][b] = adjList[b][a] = 1;
			}
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			floyed();
			int sol = 0 ;
			
			for(int j=0;j<vertex;j++)
				sol = Math.max(sol, adjList[a][j]+adjList[j][b]);
			
			System.out.printf("Case %d: %d\n",i, sol);
		}


		br.close();
	}

}
