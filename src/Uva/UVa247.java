package Uva;
import java.util.*;
public class UVa247 {
	
	static int name_size , dfsNumberCount, vertex , scc_num;
	static int[] dfs_low,dfs_num;
	static boolean[] visited;
	static Map<String,Integer> map;
	static Stack<Integer> store;
	static String[] names;
	static ArrayList<ArrayList<Integer>> graph;
	

	static void initArray()
	{
		dfs_low = new int[30];
		dfs_num = new int[30];
		visited = new boolean[30];
		map = new HashMap<String,Integer>();
		store = new Stack<Integer>();
		names = new String[30];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<30;i++) graph.add(new ArrayList<Integer>());
	}

	static void reset()
	{
		name_size = dfsNumberCount = 0;
		scc_num = 1;
		map.clear();
		store.clear();
		for (int i=0; i<vertex; i++) {
			dfs_num[i]=-1;
			dfs_low[i]= 0;
			visited[i] = false;
			graph.set(i,new ArrayList<Integer>());
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int lines, t=0 , idx_1,idx_2;
		initArray();
		String a , b;
		while(true)
		{
			vertex = sc.nextInt();
			lines  = sc.nextInt();
			if(vertex==0&lines==0) break;
			if(t!=0) System.out.println();
			reset();

			for (int i=0; i<lines; i++) {
				a = sc.next();
				b = sc.next();
				if(!map.containsKey(a)){ names[name_size] = a; map.put(a, name_size++);}
				if(!map.containsKey(b)){ names[name_size] = b; map.put(b, name_size++);}
				idx_1 = map.get(a);
				idx_2 = map.get(b);

				graph.get(idx_1).add(idx_2);
			}
			System.out.printf("Calling circles for data set %d:\n", ++t);
			for (int i =0; i< vertex; i++) {
				if(dfs_num[i]==-1) tarjanSCC(i);
			}

		}

		sc.close();
	}



	static void tarjanSCC(int u)
	{
		dfs_num[u] = dfs_low[u] = dfsNumberCount++;
		visited[u] = true;
		store.add(u);
		int v, size = graph.get(u).size();
		for (int i=0;i<size ; i++) {
			v = graph.get(u).get(i);
			if (dfs_num[v]==-1) {
				tarjanSCC(v);
			}
			if (visited[v]) {
				dfs_low[u] = Math.min(dfs_low[u],dfs_low[v]);
			}
		}

		if (dfs_num[u]==dfs_low[u]) {
			scc_num++;
			while(true)
			{
				v = store.pop();
				System.out.print(names[v]);
				visited[v] = false;
				if(v==u) break;
				System.out.print(", ");
			}
			System.out.println();
		}
	}

}
