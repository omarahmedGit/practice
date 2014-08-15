package Uva;
import java.io.IOException;
import java.util.*;
public class UVa796 {
	static int vertex, rootChildren, dfsRoot, dfsNumberCounter;
	static ArrayList<Integer> dfs_num,dfs_low,dfs_parent;
	static ArrayList<Boolean> visited;
	static ArrayList<node> bridges;
	static ArrayList<ArrayList<Integer>> graph;
	
	static void reset()
	{
		dfsNumberCounter = 0;
		dfs_num = new ArrayList<Integer>();
		dfs_low = new ArrayList<Integer>();
		dfs_parent = new ArrayList<Integer>();
		visited = new ArrayList<Boolean>();
		bridges = new ArrayList<node>();
		graph = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < vertex; i++) {
			graph.add(new ArrayList<Integer>());
			dfs_num.add(-1);
			dfs_low.add(0);
			dfs_parent.add(0);
			visited.add(false);
		}
		
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cur, connected, neighbour;
		String con;
		while(sc.hasNext())
		{
			vertex = sc.nextInt();
			reset();
			for (int i = 0; i < vertex; i++) {
				cur = sc.nextInt();
				con = sc.next();
				connected = getNumber(con.toCharArray());
				
				for (int j = 0; j < connected; j++) {
					neighbour = sc.nextInt();
					graph.get(cur).add(neighbour);
				}
			}
			
			for (int i = 0; i < vertex; i++) {
				if (!visited.get(i)) {
					dfsRoot=i;
					rootChildren=0;
					articulationPointAndBridge(i);
				}
			}
			
			Collections.sort(bridges);
			System.out.printf("%d critical links\n",bridges.size());
			node node;
			for (int i = 0; i < bridges.size(); i++) {
				node = bridges.get(i);
				System.out.printf("%d - %d\n",node.a,node.b);
			}
			System.out.println();
		}
		
		sc.close();
	}
	static int getNumber(char[] con)
	{
		String number = "";
		for(int i=1;i<con.length-1;i++)
		{
			number+=con[i];
		}
		return Integer.parseInt(number);
	}



	static void articulationPointAndBridge(int u)
	{
		dfs_num.set(u,dfsNumberCounter);
		dfs_low.set(u,dfsNumberCounter++);
		visited.set(u,true);
		int v, size = graph.get(u).size();
		for (int i=0; i<size ; i++) {
			v = graph.get(u).get(i);
			if (!visited.get(v)) {
				dfs_parent.set(v,u);
				if(u==dfsRoot) rootChildren++;
				articulationPointAndBridge(v);
				if(dfs_low.get(v)>dfs_num.get(u))
				{
					bridges.add(new node(u,v));
				}
				dfs_low.set(u,Math.min(dfs_low.get(u),dfs_low.get(v)));

			} else if(v!=dfs_parent.get(u))
			{
				dfs_low.set(u,Math.min(dfs_low.get(u),dfs_num.get(v)));
			}

		}
	}

	static class node implements Comparable<node>
	{
		int a,b;
		node(int a,int b)
		{
			this.a = Math.min(a,b);
			this.b = Math.max(a,b);
		}
		@Override
		public int compareTo(node o) {
			if(this.a==o.a)
				return this.b-o.b;
			return this.a-o.a;
		}

	}

}
