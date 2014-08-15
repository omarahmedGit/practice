package Uva;
import java.util.*;
import java.io.*;

public class UVa10600 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;

		int a,b,w,t = Integer.parseInt(br.readLine());
		int vertex, edges;
		Union_Find_Set u ;
		ArrayList<node> edgeList ;
		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edges = Integer.parseInt(st.nextToken());
			u = new Union_Find_Set(vertex+1);
			edgeList = new ArrayList<node>();
			
			for (int j=0; j<edges; j++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				edgeList.add(new node(a,b,w));
			}

			Collections.sort(edgeList);
			node cur;
			int mst = 0;
			ArrayList<Integer> index = new ArrayList<Integer>();

			for (int j=0; j<edgeList.size(); j++) {
				cur = edgeList.get(j);
				if(!u.isInTheSameSet(cur.a,cur.b))
				{
					mst += cur.w;
					index.add(j);
					u.merge(cur.a,cur.b);
				}
			}
			int sec_mst = Integer.MAX_VALUE;
			for (int j=0; j<index.size(); j++) {
				u = new Union_Find_Set(vertex+1);
				int v= 0;
				int count =0;
				for (int k =0; k<edgeList.size()&v<vertex-1; k++) {
					if(k==index.get(j)) continue;
					cur = edgeList.get(k);
					if (!u.isInTheSameSet(cur.a,cur.b)) {
						count+=cur.w;
						v++;
						u.merge(cur.a,cur.b);
					}
				}
				if(v==vertex-1)
					sec_mst = Math.min(sec_mst,count);	
			}

			pw.printf("%d %d\n",mst,sec_mst);
		}



		pw.close();
		br.close();
	}


	static class node implements Comparable<node>
	{
		int a,b;
		int w;

		node(int a,int b,int w)
		{
			this.a = a;
			this.b = b;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w-o.w;
		}
	}
	
	
	
	
	
	static class Union_Find_Set {

		int[] parent;
		
		Union_Find_Set(int x)
		{
			parent = new int[x];
			for (int i = 0; i < x; i++) parent[i] = i;
		}
		
		int find(int a)
		{
			if(parent[a]==a) return a;
			return parent[a] = find(parent[a]);
		}
		
		void merge(int a,int b)
		{
			parent[find(a)] = find(b);
		}
		
		boolean isInTheSameSet(int a, int b)
		{
			return find(a)==find(b);
		}

	}

}
