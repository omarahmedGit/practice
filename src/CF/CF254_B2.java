package CF;
import java.util.*;
public class CF254_B2 {
	static int n,m;
	static boolean[][] graph = new boolean[55][55];
	static boolean[] vis = new boolean[55];
	static boolean[] taken = new boolean[55];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int a,b;
		for (int i = 0; i < m; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			graph[a][b] = graph[b][a] = true;
		}
		sc.close();
		long res  = 1;
		
		for(int i=1;i<=n;i++)
		{
			if(!vis[i]) res = bfs(i,res);
		}
		
		System.out.println(res);
		
	}
	
	
	static long bfs(int source,long res)
	{
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(source);
		
		
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(vis[cur]) continue;
			vis[cur] = true ;
			
			for(int i=1;i<=50;i++)
			{
				if(graph[cur][i]&&!vis[i]&!taken[i])
				{
					taken[i] = true;
					res*=2;
					q.add(i);
				}
			}
		}
		
		
		return res;
	}

}
