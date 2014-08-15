package Uva;
import java.util.*;
import java.io.*;
public class UVa314 {
	static int row,col;
	static boolean[][][] visited = new boolean[51][51][4];
	static boolean[][] graph = new boolean[51][51];
	static int[] _x = {1,-1,0,0}, _y = {0,0,-1,1};

	static class node 
	{
		int a,b,c; /* c is the position */
		node(int a,int b,int c)
		{
			this.a = a;
			this.b = b;
			this.c = c;
		}
	}

	static void bfs(node source,node target)
	{

		Queue<node> q= new LinkedList<node>();
		q.add(source);
		node cur;
		int coast= 0;
		while(!q.isEmpty())
		{
			++coast;
			for (int j=q.size(); j>0; j--) {
				cur = q.poll();
				if(visited[cur.a][cur.b][cur.c]) continue;
				visited[cur.a][cur.b][cur.c] = true;
				if(cur.c==0|cur.c==1)
				{
					q.add(new node(cur.a,cur.b,2));
					q.add(new node(cur.a,cur.b,3));
				} else {
					q.add(new node(cur.a,cur.b,0));
					q.add(new node(cur.a,cur.b,1));
				}

				int a = cur.a;
				int b = cur.b;
				
				for (int i = 0; i < 3; i++) {
					a+=_x[cur.c];
					b+=_y[cur.c];
					if(check(a,b))
					{
						if(a==target.a&b==target.b)
						{
							System.out.println(coast);
							return ;
						}
						if (!visited[a][b][cur.c]) {
							q.add(new node(a,b,cur.c));
						} 
					} else { break;}

					
				}
			}
		}
		System.out.println(-1);
	}

	static boolean check4sides(int a,int b)
	{
		if(graph[a-1][b]&graph[a-1][b-1]&graph[a][b-1]&graph[a][b])
			return true;
		return false;
	}
	static boolean check(int a,int b)
	{
		if(a>0&b>0&a<row&b<col)
			return check4sides(a,b);
		return false;
	}

	static int getSide(String side)
	{
		// 0 -> 2 3
		// 1 -> 2 3
  
		if(side.equals("north"))
			return 1;
		if(side.equals("south"))
			return 0;
		if(side.equals("east"))
			return 3;
		if(side.equals("west"))
			return 2;
		
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int re ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			if(row==0&col==0) break;
			for (int i=0; i<row; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<col; j++) {
					re = Integer.parseInt(st.nextToken());
					for (int j2 = 0; j2 < 4; j2++) {
						visited[i][j][j2] = false;
					}
					graph[i][j] = re==0?true:false;
				}
			}
			st = new StringTokenizer(br.readLine());
			int a,b,c,d;
			String side;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			side = st.nextToken();
			if(a==c&b==d)
				System.out.println(0);
			else bfs(new node(a,b,getSide(side)),new node(c,d,0));
		}



		br.close();
	}

}
