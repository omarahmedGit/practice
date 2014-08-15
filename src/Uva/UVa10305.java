package Uva;

import java.util.*;

public class UVa10305{
	static int N;
	static boolean[] visited = new boolean[102];
	static ArrayList<Integer> topoSort ;
	static ArrayList<ArrayList<Integer>> newG;
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int from,to,m;
		while(true)
		{
			N = sc.nextInt();
			m = sc.nextInt();
			if(N==0&&m==0)
				break;
			reset();
			for(int i=0;i<m;i++)
			{
				to = sc.nextInt();
				from = sc.nextInt();
				newG.get(from).add(to);
			}
			for (int i =1; i<=N; i++) {
				if (!visited[i]) {
					dfs(i);
				}
			}
			for (int i =0; i< topoSort.size(); i++) {
				System.out.print(topoSort.get(i));
				if(i!=topoSort.size()-1)
					System.out.print(" ");
			}
			System.out.println();
		}

		sc.close();

	}

	static void reset()
	{
		for (int i =0; i< 101; i++) {
			visited[i] = false;
		}
		
		newG = new ArrayList<ArrayList<Integer>>();
		
		for (int i =0; i<=N; i++) {
			newG.add(new ArrayList<Integer>());
		}

		topoSort = new ArrayList<Integer>();
	}

	static void dfs(int node)
	{
		visited[node] = true;
		int index , x = newG.get(node).size();
		for (int i =0 ; i< x ; i++) {
			index = newG.get(node).get(i);
			if (!visited[index]) {
				dfs(index);
			}
		}
		topoSort.add(node);
	}

}
