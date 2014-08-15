package Uva;
import java.util.*;
public class UVa11838 {
	static int vertex, scc , dfsNumberCounter;
	static int[] dfs_num,dfs_low;
	static boolean[] visited;
	static ArrayList<ArrayList<Integer>> graph;
	static Stack<Integer> SCC;
	
	static void initTarjanSCC()
	{
		dfs_num = new int[2002];
		dfs_low = new int[2002];
		visited = new boolean[2002];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<2002; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}

	static void reset()
	{
		scc = dfsNumberCounter =0;
		SCC = new Stack<Integer>();
		for (int i=1; i<=vertex; i++) {
			graph.set(i,new ArrayList<Integer>());
			dfs_low[i] = 0;
			dfs_num[i] = -1;
			visited[i] = false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		initTarjanSCC();
		int lines,v,w,p;
		while(true)
		{
			vertex = sc.nextInt();
			lines  = sc.nextInt();
			if(vertex==0&lines==0) break;
			reset();
			for (int i=0; i< lines; i++) {
				v = sc.nextInt();
				w = sc.nextInt();
				p = sc.nextInt();
				graph.get(v).add(w);
				if(p==2) graph.get(w).add(v);
			}
			for (int i=1; i<=vertex; i++) {
				if (dfs_num[i]==-1) {
					tarjanSCC(i);
				}
			}
			if(scc!=1)
				System.out.println(0);
			else
				System.out.println(1);
		}

		sc.close();

	}

	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = dfsNumberCounter++;
		visited[u] = true;
		SCC.add(u);
		int v, size = graph.get(u).size() ;
		for (int i=0; i<size; i++) {
			v = graph.get(u).get(i);
			if(dfs_num[v]==-1)
				tarjanSCC(v);
			if (visited[v]) {
				dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
			}
		}

		if(dfs_low[u]==dfs_num[u]){
			scc++;
			while(true)
			{
				int x = SCC.pop();
				visited[x]=false;
				if(x==u) break;
			}
		}
	}

}
