package Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;

public class UVa11953 {
	static char[][] world = new char[101][101];
	static boolean[][] vis = new boolean[101][101];
	static int size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int testCases = Integer.parseInt(br.readLine());
		char[] line;
		for (int i = 1; i <= testCases; i++) {
			size = Integer.parseInt(br.readLine());
			for (int j = 0; j < size; j++) {
				line = br.readLine().toCharArray();
				for (int j2 = 0; j2 < size; j2++) {
					vis[j][j2] = false;
					world[j][j2] = line[j2];
				}
			}
			int sol = countConnectedComp();
			System.out.printf("Case %d: %d\n",i,sol);
		}
		br.close();
		pw.close();
	}
	static int countConnectedComp()
	{
		int count = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(world[i][j]!='.'&&!vis[i][j])
				{
					if(bfs(i,j)) count++;
				}
			}
		}
		return count;
	}
	
	static boolean check(int i,int j)
	{
		return (i>-1&j>-1&i<size&j<size)? true:false;
	}
	static boolean bfs(int x,int y)
	{
		node src = new node(x,y);
		Queue<node> q = new LinkedList<node>();
		q.add(src);
		boolean alive = false;
		int i,j;
		node cur;
		int[] _x= {1,-1,0,0};
		int[] _y = {0,0,1,-1};
		while(!q.isEmpty())
		{
			cur = q.poll();
			vis[cur.x][cur.y] = true;
			if(world[cur.x][cur.y]=='x') alive = true;
			for (int k = 0; k < 4; k++) {
				i = cur.x+_x[k];
				j = cur.y+_y[k];
				if(check(i,j))
				{
					if(!vis[i][j]&world[i][j]!='.')
					{
						q.add(new node(i,j));
					}
				}
			}
		}
		
		return alive;
	}
	
	public static class node{
		int x,y;
		public node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

}
