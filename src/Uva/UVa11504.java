package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
public class UVa11504 {
	static int vertex, SSC_num ,dfsNumberCounter;
	static int[] data_num,data_low, sol;
	static boolean[] visited,done;
	static ArrayList<ArrayList<Integer>> graph;
	static Stack<Integer> SCC;
	
	
	
	static void initArray()
	{
		data_low = new int[100002];
		data_num = new int[100002];
		visited = new boolean[100002];
		done = new boolean[100002];
		sol = new int[100002];
		graph = new ArrayList<ArrayList<Integer>>();
		for(int i =0;i<100002;i++){
			graph.add(new ArrayList<Integer>());
		} 
	}

	static void reset()
	{
		dfsNumberCounter = 0;
		SCC = new Stack<Integer>();
		for (int i=1; i<=vertex; i++) {
			data_low[i] = sol[i] = 0;
			data_num[i] = -1;
			visited[i] = done[i]= false;
			graph.set(i, new ArrayList<Integer>());
		}
	}

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int lines , a , b , n = Integer.parseInt(st.nextToken());
		initArray();
		for (int i=0; i<n ; i++) {
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			lines  = Integer.parseInt(st.nextToken());
			reset();
			for (int j=0; j<lines ; j++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				graph.get(a).add(b);
			}
			SSC_num = 0;	
			for (int j=1; j<=vertex; j++) {
				if(data_num[j]==-1) tarjanSCC(j);
			}
			for(int j=0;j<=vertex;j++) visited[j]= false;
			
			for (int j = 1; j <= vertex; j++) {
				if(!visited[j]) dfs(j,-1);
			}
			
			pw.println(SSC_num);
		}
		pw.close();
		br.close();
	}

	
	
	static void dfs(int u,int parent)
	{
		int v ,size = graph.get(u).size();
		visited[u] = true;
		for(int i=0;i<size;i++)
		{
			v = graph.get(u).get(i);
			if(sol[u]!=sol[v]&v!=parent&!done[sol[v]])
			{
				done[sol[v]]=true;
				SSC_num--;
			}
			
			if(!visited[v])
			{
				dfs(v,u);
			}
		}
	}
	
	static void tarjanSCC(int u)
	{
		data_num[u] = data_low[u] = dfsNumberCounter++;
		visited[u]  = true;
		SCC.add(u);
		int size = graph.get(u).size();
		int con;
		for (int i=0; i<size; i++) {
			con = graph.get(u).get(i);
			if(data_num[con]==-1)
				tarjanSCC(con);
			if(visited[con])
				data_low[u] = Math.min(data_low[u],data_low[con]);
		}
		if (data_low[u]==data_num[u]) {
			SSC_num++;
			while(true)
			{
				int v = SCC.pop();
				sol[v] = SSC_num;
				visited[v]=false;
				if(v==u) break;
			}
		}
	}
	
	

}
