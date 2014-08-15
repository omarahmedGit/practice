package Uva;

import java.io.*;
import java.util.StringTokenizer;

public class UVa315 {
	static boolean[][] graph = new boolean[101][101];

	static int rootChildren, vertex, dfsRoot, dfsNumberCounter;
	static int[] dfs_num, dfs_low, dfs_Parent;
	static boolean[] visited = new boolean[101];
	static boolean[] articulation = new boolean[101];

	static void initArrays()
	{
		dfs_Parent = new int[101];
		dfs_low = new int[101];
		dfs_num = new int[101];
	}
	static void reset()
	{
		dfsNumberCounter = 0;
		for (int i=0; i<101; i++) {
			dfs_num[i] = -1;
			dfs_low[i] = dfs_Parent[i] = 0;
			visited[i] = articulation[i] = false;
			for (int j=0; j<101; j++) {
				graph[i][j] = false;
			}
		}
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int tokens, node, node_con, solution;
		initArrays();
		while (true) {
			vertex = Integer.parseInt(br.readLine());
			if (vertex == 0)
				break;
			reset();
			while (true) {
				st = new StringTokenizer(br.readLine());
				tokens = st.countTokens();
				node = Integer.parseInt(st.nextToken());
				if (node == 0)
					break;
				for (int i = 1; i < tokens; i++) {
					node_con = Integer.parseInt(st.nextToken());
					graph[node][node_con] = graph[node_con][node] = true;
				}
			}

			for (int i=1; i<vertex; i++) {
				if (!visited[i]) {
					dfsRoot = i;
					rootChildren = 0;
					articulationPointAndBridge(i);
					articulation[i] = (rootChildren>1);
				}
			}
			solution = 0;
			for (int i =1; i<=vertex; i++) {
				if(articulation[i]) solution++;
			}
			System.out.println(solution);

		}

		br.close();
	}

	static void articulationPointAndBridge(int u) {
		dfs_num[u] = dfs_low[u] = dfsNumberCounter++;
		visited[u] = true;
		for (int i = 0; i < 101; i++) {
			if (graph[u][i]) {
				if (!visited[i]) {

					dfs_Parent[i] = u;
					if (u == dfsRoot)
						rootChildren++;

					articulationPointAndBridge(i);

					if (dfs_low[i] >= dfs_num[u])
						articulation[u] = true;

					dfs_low[u] = Math.min(dfs_low[u], dfs_low[i]);

				} else if(i!=dfs_Parent[u]) {
					dfs_low[u] = Math.min(dfs_low[u],dfs_num[i]);
				}
			}
		}
	}

}
