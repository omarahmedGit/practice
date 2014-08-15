package Uva;
import java.util.*;
import java.io.*;

public class UVa10653 {
	static int col,row;
	static int[][] graph = new int[1001][1001];
	static boolean[][] visited = new boolean[1001][1001];
	static int[] _x = {1,-1,0,0} , _y = {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int lines , a , b , x1,y1,x2,y2;
		while(true) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			if(row==0&col==0) break;
			reset();
			lines = Integer.parseInt(br.readLine());
			
			for (int i=0; i<lines; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				for (int j=0; j<c; j++) {
					b = Integer.parseInt(st.nextToken());
					graph[a][b] = -1; 
				}
			}

			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());
			
			bfs(new node(x1,y1));

			pw.println(graph[x2][y2]);
		}
		pw.close();
		br.close();
	}

	static void reset()
	{
		for (int i=0; i< row; i++) {
			for (int j=0; j<col; j++) {
				graph[i][j] = 0;
				visited[i][j] = false;
			}
		}
	}

	static void bfs(node start)
	{
		Queue<node> q = new LinkedList<node>();
		q.add(start);
		node cur ;
		while(!q.isEmpty())
		{
			cur = q.poll();

			if(visited[cur.x][cur.y]) continue;
			
			visited[cur.x][cur.y] = true;

			for (int i=0; i<4; i++) {
				if (check(cur.x+_x[i],cur.y+_y[i])) {
					if(graph[cur.x+_x[i]][cur.y+_y[i]]!=-1&!visited[cur.x+_x[i]][cur.y+_y[i]])
					{
						graph[cur.x+_x[i]][cur.y+_y[i]] = graph[cur.x][cur.y]+1;
						q.add(new node(cur.x+_x[i],cur.y+_y[i]));
					}
				}
			}
		}

	}

	static boolean check(int x,int y)
	{
		if(x>=0&y>=0&x<row&y<col)
			return true;
		return false;
	}

	static class node {
		int x,y;
		node(int x,int y)
		{
			this.x = x;
			this.y = y;
		}
	}
}
