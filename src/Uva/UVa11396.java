package Uva;
import java.util.*;
public class UVa11396 {
	static int vertex;
	static boolean[][] graph = new boolean[301][301];
	static boolean[] visited = new boolean[301];
	static int[] color = new int[301];
	
	static void reset()
	{
		for (int i =0;i<301;i++) {
			visited[i] = false;
			color[i] = 0;
			for (int j = 0; j< 301; j++) {
				graph[i][j] = false;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b;
		while(sc.hasNext())
		{
			vertex = sc.nextInt();
			if(vertex==0) break;
			reset();
			while(true)
			{
				a = sc.nextInt();
				b = sc.nextInt();
				if(a==0&b==0) break;
				graph[a][b] = graph[b][a] = true;
			}

			if(bipartiteCheck(1))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}

	static boolean bipartiteCheck(int source)
	{
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		color[source] = 1;
		int cur;

		while(!q.isEmpty())
		{
			cur = q.poll();

			if(visited[cur]) continue;

			visited[cur] = true;
			/*
				1 for black 
				2 for white 
				0 uncolored
			*/
			for (int i =1; i<vertex; i++) {
				if(i==cur) continue;
				if(graph[cur][i])
				{
					if(color[i]==0){
						color[i] = color[cur]==1?2:1;
						q.add(i);
					}
					else if(color[i]!=0&(color[i]==color[cur]))
						return false;
				}
			}
		}
		return true;
	}

}
