package Uva;
import java.util.*;

public class UVa10765 {
	static int vertex , dfsRoot, rootChildren, dfsNumberCounter;
	static int[] dfs_low,dfs_num,dfs_parent;
	static ArrayList<node> solution;
	static boolean[] visited ; // articulation ;
	static ArrayList<ArrayList<Integer>> graph;

	static void initArrays()
	{
		dfs_low    = new int[100000];
		dfs_num    = new int[100000];
		dfs_parent = new int[100000];
		visited      = new boolean[100000];
		//articulation = new boolean[100000];
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i=0; i<100000; i++) {
			graph.add(new ArrayList<Integer>());
		}
	}

	static void reset()
	{
		solution = new ArrayList<node>();
		for (int i=0;i<vertex;i++) {
			dfs_parent[i] = dfs_low[0] = 0;
			dfs_num[i] = -1;
			visited[i] = false; // articulation[i] = false;
			graph.set(i,new ArrayList<Integer>());
			solution.add(new node(i,0));
		}
	}

	public static void main(String[] args) {
		initArrays();
		Scanner sc = new Scanner(System.in);
		int number_of_points,a,b, z;
		while(true)
		{
			vertex = sc.nextInt();
			number_of_points = sc.nextInt();
			if(vertex==0& number_of_points==0)
				break;
			reset();
			while(true)
			{
				a = sc.nextInt(); b=sc.nextInt();
				if(a==-1&b==-1)
					break;
				graph.get(a).add(b);
				graph.get(b).add(a);
			}
			z = 0;
			for (int i=0; i<vertex; i++) {
				if(!visited[i])
				{
					dfsRoot = i;
					rootChildren = 0;
					z++;
					articulationPointAndBridge(i);
					solution.get(i).score= rootChildren-1;
				}
			}
			for (int i = 0; i < solution.size(); i++) {
				solution.get(i).score+=z;
			}
			Collections.sort(solution);
			node node;
			for (int i=0; i<number_of_points;i++) {
				node = solution.get(i);
				System.out.printf("%d %d\n",node.num,node.score);
			}
			System.out.println();
		}

		sc.close();

	}


	static void articulationPointAndBridge(int u)
	{
		dfs_num[u] = dfs_low[u] = dfsNumberCounter++;
		visited[u] = true;
		int v,size = graph.get(u).size();

		for (int i = 0; i<size ; i++) {
			v = graph.get(u).get(i);
			if (!visited[v]) {
				dfs_parent[v] = u;
				if(dfsRoot==u) rootChildren++;
				articulationPointAndBridge(v);

				if(dfs_low[v]>=dfs_num[u])
				{
					//articulation[u] = true;
					solution.get(u).incrementScore();
				}
				dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
			} else if(v!=dfs_parent[u]) {
				dfs_low[u] = Math.min(dfs_low[u],dfs_num[v]);
			}
		}
	}

	static class node implements Comparable<node>
	{
		int num,score;
		node(int num,int score)
		{
			this.num     = num;
			this.score   = score;
		}
		void incrementScore()
		{
			this.score++;
		}

		@Override
		public int compareTo(node o) {
			if(this.score==o.score)
				return this.num-o.num;
			return o.score-this.score;
		}
	}

}
