package Uva;
import java.util.*;
import java.io.*;

public class UVa11492 {

	static int words , index ; /* edges */
	static ArrayList<ArrayList<node>> graph = new ArrayList<ArrayList<node>>();
	static Map<String,Integer> map = new HashMap<String,Integer>();
	static boolean[][] visited = new boolean[4004][26];
	static int[][] dis = new int[4004][26];

	static void Dijkstra(int source)
	{
		node cur,v; int size;
		for (int i=0; i< index; i++) {
			for (int j=0; j<26; j++) {
				dis[i][j] = 1000000000;
				visited[i][j] = false;
			}
		}
		PriorityQueue<node> q = new PriorityQueue<node>();
		for (int i=0; i<26; i++){
			dis[source][i] = 0;
			visited[source][i] = true;	
		}

		for (int i=0; i<graph.get(source).size(); i++) {
			cur = graph.get(source).get(i);
			dis[cur.to][cur.firstChar] = Math.min(dis[cur.to][cur.firstChar],cur.w);
			q.add(new node(cur.to,cur.firstChar,cur.w));
		}
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(visited[cur.to][cur.firstChar]) continue;
			visited[cur.to][cur.firstChar] = true;
			size = graph.get(cur.to).size();
			for (int i=0; i<size; i++) {
				v = graph.get(cur.to).get(i);
				if(cur.firstChar!=v.firstChar)
				{
					if(cur.w+v.w<dis[v.to][v.firstChar])
					{
						dis[v.to][v.firstChar] = cur.w+v.w;
						q.add(new node(v.to,v.firstChar,dis[v.to][v.firstChar]));
					}
				}
			}
		}
	}

	static class node implements Comparable<node>
	{
		int to , firstChar , w;
		node(int a, int b, int c)
		{
			this.to = a;
			this.firstChar = b;
			this.w = c;	
		}

		public int compareTo(node o)
		{
			return this.w-o.w;
		}
	}
	static void initArr()
	{
		for (int i =0; i<4004; i++) {
			graph.add(new ArrayList<node>());
		}
	}

	static void reset()
	{
		map.clear();
		for (int i =0; i<4004; i++) {
			graph.set(i,new ArrayList<node>());
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		String from_s,to_s , a , b, c;
		int from, to;
		initArr();
		while(true)
		{
			words = Integer.parseInt(br.readLine());
			if(words == 0) break ;
			reset();
			index = 0;

			st = new StringTokenizer(br.readLine());
			from_s 	= st.nextToken();
			to_s 	= st.nextToken();

			if(!map.containsKey(from_s)) map.put(from_s,index++);
			if(!map.containsKey(to_s)) map.put(to_s,index++);
			

			int idx_a,idx_b;
			for (int i=0; i<words; i++) {
				st = new StringTokenizer(br.readLine());
				a = st.nextToken();
				b = st.nextToken();
				c = st.nextToken();
				if(!map.containsKey(a)) map.put(a,index++);
				if(!map.containsKey(b)) map.put(b,index++);
				idx_a = map.get(a);
				idx_b = map.get(b);
				graph.get(idx_a).add(new node(idx_b,c.charAt(0)-'a',c.length()));
				graph.get(idx_b).add(new node(idx_a,c.charAt(0)-'a',c.length()));
			}
			from = map.get(from_s);
			to   = map.get(to_s);
			Dijkstra(from);
			int sol = dis[to][0];
			for (int i=1; i<26; i++) {
				sol = Math.min(sol,dis[to][i]);
			}
			if(sol==1000000000)
				pw.println("impossivel");
			else 
				pw.println(sol);

		}



		pw.close();
		br.close();
	}

}
