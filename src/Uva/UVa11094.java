package Uva;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UVa11094 {
	static boolean[][] vis = new boolean[22][22];
	static boolean[][] con = new boolean[22][22];
	static int wX,wY,sX,sY;
	static boolean _A;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		char[] line;
		char a = 'l';
		while(sc.hasNext())
		{
			wX = sc.nextInt();
			wY = sc.nextInt();
			
			for (int i = 0; i < wX; i++) {
				line = sc.next().toCharArray();
				if(i==0) a = line[0];
				for (int j = 0; j < wY; j++) {
					vis[i][j] = false;
					con[i][j] = line[j]==a?true:false;
				}
			}
			
			sX = sc.nextInt();
			sY = sc.nextInt();
			
			_A = con[sX][sY];
			
			// first choose finish where he stand
			bfs(sX,sY);
			int sol = countConnectedComp();
			pw.println(sol);
		
		}
		
		sc.close();
		pw.close();
	}
	
	static int countConnectedComp()
	{
		int maxC = 0,count=0;
		
		for (int i = 0; i < wX; i++) {
			for (int j = 0; j < wY; j++) {
				if(con[i][j]==_A&!vis[i][j])
				{
					count = bfs(i,j);
					if(maxC<count) maxC = count;
				}
			}
		}
		
		return maxC; 
	}
	static boolean check(int x,int y)
	{
		return (x>-1&y>-1&x<wX&y<wY)?true:false;
	}
	static int bfs(int x,int y)
	{
		int count = 0;
		node sur = new node(x,y);
		Queue<node> q = new LinkedList<node>();
		q.add(sur);
		node cur;
		int[] _x = {1,-1,0,0};
		int[] _y = {0,0,1,-1};
		int X,Y;
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(vis[cur.x][cur.y]) continue;
			vis[cur.x][cur.y] = true;
			count++;
			for (int i = 0; i < 4; i++) {
				X = cur.x+_x[i];
				Y = cur.y+_y[i];
				if(Y<0) Y = wY-1;
				if(Y==wY) Y = 0;
				
				if(check(X,Y))
				{
					if(!vis[X][Y]&con[X][Y]==_A) q.add(new node(X,Y));
				}
			}
			
		}
		return count;
	}
	
	public static class node
	{
		int x,y;
		public node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

}
