package Uva;
import java.util.*;
import java.io.*;


public class UVa11101 {
	static char[][] visited = new char[2001][2001];
	static ArrayList<node> mall_one , mall_two ;
	static int[] _x = {1,-1,0,0}, _y = {0,0,1,-1};

	static void bfs()
	{
		Queue<node> q = new LinkedList<node>();
		for (int i=0; i<mall_one.size(); i++) {
			q.add(mall_one.get(i));
			node add = mall_one.get(i);
			visited[add.a][add.b] = 't';
		}

		for (int i=0; i<mall_two.size() ; i++) {
			node two = mall_two.get(i);
			visited[two.a][two.b] = 'x';
		}

		node cur ;
		int coast = 0, a, b;
		while(!q.isEmpty())
		{
			coast ++;
			for (int i=q.size(); i>0; i--) {
				cur = q.poll();
				for (int j=0; j< 4; j++) {
					a = cur.a+_x[j];
					b = cur.b+_y[j];
					if (check(a,b)) {
						if(visited[a][b]=='t')
							continue;
						if (visited[a][b]=='x') {
							System.out.println(coast);
							return ;
						}
						visited[a][b] = 't';
						q.add(new node(a,b));
					}
				}
			}
			
		}
	}
	static boolean check(int x,int y)
	{
		if(x>=0&y>=0&y<=2000&x<=2000)
			return true;
		return false;
	}
	static class node 
	{
		int a,b;
		node(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int a,b;

		while(true)
		{
			a = Integer.parseInt(br.readLine());
			if(a==0) break;
			mall_one = new ArrayList<node>();
			mall_two = new ArrayList<node>();
			

			for (int i=0; i<2001; i++) {
				for (int j=0; j<2001; j++) {
					visited[i][j] = 'f';
				}
			}
			
			int aa = a;
			while(aa>0)
			{
				st = new StringTokenizer(br.readLine());
				int tokens = st.countTokens();
				for (int i=0; i< tokens ; i+=2) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					mall_one.add(new node(x,y));
					aa--;

				}
			}
			b = Integer.parseInt(br.readLine());

			int bb = b;

			while(bb>0)
			{
				st = new StringTokenizer(br.readLine());
				int tokens = st.countTokens();
				for (int i=0; i< tokens ; i+=2) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					mall_two.add(new node(x,y));
					bb--;
				}
			}


			bfs();



		}

		br.close();
	}

}
