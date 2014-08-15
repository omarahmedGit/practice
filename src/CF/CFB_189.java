package CF;
import java.util.*;
public class CFB_189 {
	static int[][] adjList = new int[102][102];
	static boolean[] visited = new boolean[102];
	static ArrayList<node> graph = new ArrayList<node>(); 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		while(n-->0)
		{
			int q = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(q==2)
			{
				boolean ans = false;
				resetVisited();
				dfs(graph.get(x-1));
				if(visited[y-1]) ans = true;
				if(ans)System.out.println("YES");
				else System.out.println("NO");
			}
			else
			{
				node newnode = new node(graph.size(),x,y);
				constractGraph(newnode);
				graph.add(newnode);
			}
		}
		sc.close();
	}
	
	public static void constractGraph(node n)
	{
		node getnode;
		for (int i = 0; i < graph.size(); i++) {
			getnode = graph.get(i);
			if(getnode.checkIsSon(n)){
				adjList[graph.size()][i] = 1;
			}
			if(getnode.checkIsParent(n)){
				adjList[i][graph.size()] = 1;
			}
		}
	}
	
	public static void dfs(node u)
	{
		visited[u.idx] = true;
		for (int i = 0; i < 102; i++)
			if(adjList[u.idx][i]==1)
				if(!visited[i])
					dfs(graph.get(i));
	}
	
	public static void resetVisited() { for(int i =0;i<102;i++) visited[i]= false;}	
	
	public static class node
	{
		int idx,s,e;
		public node (int idx,int x,int y)
		{
			this.idx = idx;
			s =x;
			e =y;
		}
		// a is the son of this
		boolean checkIsParent(node a)
		{
			return (this.s>a.s&this.s<a.e)||(this.e>a.s&this.e<a.e);
		}
		// a is the parent of this
		boolean checkIsSon(node a)
		{
			return (a.s>this.s&a.s<this.e)||(a.e>this.s&a.e<this.e);
		}
	}

}
