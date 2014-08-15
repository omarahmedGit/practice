package Uva;
import java.util.*;
import java.io.*;

public class UVa929 {
	static int row,col;
	static int[][] dis = new int[1000][1000], graph = new int[1000][1000];
	static boolean[][] visited = new boolean[1000][1000];
	static int[] _x = {1,-1,0,0},_y = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(br.readLine());

		while(t-->0)
		{
			row = Integer.parseInt(br.readLine());
			col = Integer.parseInt(br.readLine());

			for (int i=0; i<row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0;j<col; j++) {
					visited[i][j] = false;
					dis[i][j] = Integer.MAX_VALUE;
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Dijkstra(new node(0,0,0));
			pw.println(dis[row-1][col-1]);
		}

		pw.close();
		br.close();
	}

	static boolean check(int a,int b)
	{
		if(a>=0&b>=0&a<row&b<col)
			return true;
		return false;
	}

	static class node implements Comparable<node>
	{
		int a,b,w;
		node(int a,int b,int w)
		{
			this.a = a;
			this.b = b;
			this.w = w;
		}
		public int compareTo(node o)
		{
			return this.w-o.w;
		}
	}


	static void Dijkstra(node source)
	{
		dis[source.a][source.b] = graph[source.a][source.b];
		PriorityQueue<node> q = new PriorityQueue<node>();
		q.add(source);
		node u ;
		while(!q.isEmpty())
		{
			u = q.poll();
			if(visited[u.a][u.b]) continue;
			visited[u.a][u.b] = true;
			for (int i=0; i<4; i++) {
				int a = u.a+_x[i];
				int b = u.b+_y[i];
				if(check(a,b))
				{
					if(dis[u.a][u.b]+graph[a][b]<dis[a][b])
					{
						dis[a][b] = dis[u.a][u.b]+graph[a][b];
						q.add(new node(a,b,dis[a][b]));
					}
				}
			}
		}
	}

}
