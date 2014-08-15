package Uva;
import java.util.*;
import java.io.*;
public class UVa10048 {
	static boolean[] visited = new boolean[101];
	static int[] parent = new int[101];
	static int[][] graph = new int[101][101]; 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int vertex , edges , queries ;
		int a,b,w, t =1;
		Union_Find_Set u;
		ArrayList<node> edgeList;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edges  = Integer.parseInt(st.nextToken());
			queries= Integer.parseInt(st.nextToken());
			if(vertex==0&edges==0&queries==0) break;
			u = new Union_Find_Set(vertex+1);
			edgeList = new ArrayList<node>();
			
			if(t!=1) pw.println();

			for(int i=0;i<101;i++)
			{
				for (int j=0; j<101; j++) {
					graph[i][j] = -1;
				}
			}
			for (int i =0; i< edges; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				edgeList.add(new node(a,b,w));
			}

			Collections.sort(edgeList);
			node cur;
			for (int i=0; i<edgeList.size(); i++) {
				cur = edgeList.get(i);
				if(!u.isInTheSameSet(cur.a,cur.b))
				{
					graph[cur.a][cur.b] = cur.w;
					graph[cur.b][cur.a] = cur.w;
					u.merge(cur.a,cur.b);
				}
			}
			pw.printf("Case #%d\n",t++);
			for (int i=0; i<queries; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				for(int j=0;j<=vertex;j++){
					parent[j]  = j;
					visited[j] = false;	
				} 
				dfs(a);
				int sol = getMax(b);
				if(sol==-1)
					pw.println("no path");
				else
					pw.println(sol);
			}
		}
		

		pw.close();
		br.close();
	}

	static void dfs(int u)
	{
		visited[u] = true;
		for (int i=0; i< 101; i++) {
			if(graph[u][i]!=-1&!visited[i])
			{
				parent[i] = u;
				dfs(i);
			}
		}
	}

	static int getMax(int u)
	{
		int max = -1;
		int a  = u, b;
		while(true)
		{
			b = parent[a];
			if(b == a) break;
			max = Math.max(max, graph[a][b]);
			a = b;
		}
		return max;
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

		@Override
		public int compareTo(node o) {
			return this.w-o.w;
		}
		
	}


	static class Union_Find_Set {

		int[] parent;
		
		Union_Find_Set(int x)
		{
			parent = new int[x];
			for (int i = 0; i < x; i++) parent[i] = i;
		}
		
		int find(int a)
		{
			if(parent[a]==a) return a;
			return parent[a] = find(parent[a]);
		}
		
		void merge(int a,int b)
		{
			parent[find(a)] = find(b);
		}
		
		boolean isInTheSameSet(int a, int b)
		{
			return find(a)==find(b);
		}

	}

}
