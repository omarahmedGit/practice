package Uva;
import java.util.*;
import java.io.*;

public class UVa12047 {
	static int vertex,p;
	static boolean[][] visited = new boolean[2][10001];
	static long[][] dis = new long[2][10001];
	static ArrayList<ArrayList<node>> graph = new ArrayList<ArrayList<node>>();
	static ArrayList<ArrayList<node>> reGraph = new ArrayList<ArrayList<node>>();

	static void reset()
	{
		for (int i=1; i<=vertex; i++) {
			visited[0][i] = visited[1][i] = false;
			graph.set(i,new ArrayList<node>());
			reGraph.set(i,new ArrayList<node>());
		}
	}
	static class node implements Comparable<node>
	{
		int a; long w;
		node(int a,long w)
		{
			this.a = a ;
			this.w = w;
		}

		public int compareTo(node o)
		{
			return (int) (this.w-o.w);
		}

	}

	static void Dijkstra(node source,int state)
	{
		for (int i=1; i<=vertex; i++) {
			dis[state][i] = 10000000000L;
		}
		// 0 for direct graph 
		// 1 for reGraph
		dis[state][source.a] = 0;
		PriorityQueue<node> q = new PriorityQueue<node>();
		q.add(source);
		node u,v;
		int size ;
		while(!q.isEmpty())
		{
			u = q.poll();
			if(visited[state][u.a]) continue ;
			visited[state][u.a] = true;
			
			size = state==0 ? graph.get(u.a).size() : reGraph.get(u.a).size();
			for (int i=0; i<size; i++) {
				v = (state==0) ? graph.get(u.a).get(i) : reGraph.get(u.a).get(i);
				if(u.w+v.w<dis[state][v.a])
				{
					dis[state][v.a] = u.w+v.w;
					q.add(new node(v.a,dis[state][v.a]));
				}
			}
		}

	}
	
	static long toll()
	{
		int size ;
		long coast;
		node cur;
		long max =-1;
		for (int i=1; i<=vertex; i++) {
			size = graph.get(i).size();
			for (int j=0; j<size; j++) {
				cur = graph.get(i).get(j);
				coast = dis[0][i]+cur.w+dis[1][cur.a];
				if(coast<=p)
				{	
					max = Math.max(cur.w,max);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		int edges , from, to , a, b, w;

		for (int i=0; i<10001; i++) {
			graph.add(new ArrayList<node>());
			reGraph.add(new ArrayList<node>());
		}

		while(t-->0)
		{
			st = new StringTokenizer(br.readLine());
			vertex 	= Integer.parseInt(st.nextToken());
			edges   = Integer.parseInt(st.nextToken());
			from 	= Integer.parseInt(st.nextToken());
			to 		= Integer.parseInt(st.nextToken());
			p 		= Integer.parseInt(st.nextToken());
			
			reset();

			for (int i=0; i<edges; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				graph.get(a).add(new node(b,w));
				reGraph.get(b).add(new node(a,w));
			}

			Dijkstra(new node(from,0),0);
			Dijkstra(new node(to,0) ,1);
			
			long sol = toll();
			pw.println(sol);
		}

		pw.close();
		br.close();
	}

}
