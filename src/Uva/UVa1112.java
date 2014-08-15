package Uva;
import java.util.*;
import java.io.*;

public class UVa1112 {
	static ArrayList<ArrayList<node>> graph = new ArrayList<ArrayList<node>>();
	static int nodes;
	static int[] dis = new int[101];
	static boolean[] visited = new boolean[101];
	static class node implements Comparable<node>
	{	
		int a,w;
		node(int a,int w)
		{
			this.a = a;
			this.w = w;
		}

		public int compareTo(node o)
		{
			return this.w-o.w;
		}
	}
	static void Dijkstra(node source)
	{
		for(int i=1;i<=nodes;i++) dis[i] = Integer.MAX_VALUE;
		PriorityQueue<node> q = new PriorityQueue<node>();
		q.add(source);
		node u ,v;
		int size ;
		dis[source.a] = 0;
		while(!q.isEmpty())
		{
			u = q.poll();
			if(visited[u.a]) continue;
			visited[u.a] = true;
			size = graph.get(u.a).size();
			for (int i=0; i<size; i++) {
				v = graph.get(u.a).get(i);
				if(u.w+v.w<dis[v.a])
				{
					dis[v.a] = u.w+v.w;
					q.add(new node(v.a,dis[v.a])); 
				}
			}
		}
	}
	static void reset()
	{
		for(int i=1;i<101;i++){
			graph.set(i,new ArrayList<node>());
			visited[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int end , timelimite, lines , a, b, c, counter;
		for(int i=0;i<101;i++)
			graph.add(new ArrayList<node>());
		while(t-->0)
		{
			reset();
			br.readLine();
			nodes 		= Integer.parseInt(br.readLine());
			end 		= Integer.parseInt(br.readLine());
			timelimite 	= Integer.parseInt(br.readLine());
			lines		= Integer.parseInt(br.readLine());
			for (int i=0; i<lines; i++) {
				st = new StringTokenizer(br.readLine());
				a  = Integer.parseInt(st.nextToken());
				b  = Integer.parseInt(st.nextToken());
				c  = Integer.parseInt(st.nextToken());
				graph.get(b).add(new node(a,c));
			}
			Dijkstra(new node(end,0));
			counter = 0;
			for (int i=1; i<=nodes; i++) {
				if(dis[i]<=timelimite) counter++;
			}
			pw.println(counter);
			if(t!=0)
				pw.println();
				
		}
		pw.close();
		br.close();
	}




}
