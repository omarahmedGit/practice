package Uva;
import java.util.*;
import java.io.*;
public class UVa11228 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int t  = Integer.parseInt(br.readLine());
		int vertex , r;
		
		int []_x = new int[1002];
		int []_y = new int[1002];
		ArrayList<node> edgeList;
		Union_Find_Set u ;

		for (int i=0; i<t; i++) {
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			u = new Union_Find_Set(vertex);
			edgeList = new ArrayList<node>();
			for (int j=0; j< vertex; j++) {
				st = new StringTokenizer(br.readLine());
				_x[j] = Integer.parseInt(st.nextToken());
				_y[j] = Integer.parseInt(st.nextToken());
			}

			for (int j=0; j<vertex; j++) {
				for (int k =j+1; k<vertex; k++) {
					int w = ((_x[j]-_x[k])*(_x[j]-_x[k]))+((_y[j]-_y[k])*(_y[j]-_y[k]));
					edgeList.add(new node(j,k,w));
				}
			}

			Collections.sort(edgeList);
			node cur ;
			int states = 1;
			double road = 0,railway = 0;
			for (int j=0; j< edgeList.size(); j++) {
				cur = edgeList.get(j);
				if(!u.isInTheSameSet(cur.a,cur.b))
				{
					u.merge(cur.a, cur.b);
					if(Math.sqrt(cur.w)>r)
					{
						states++;
						railway+=Math.sqrt(cur.w);
					}
					else {
						road+= Math.sqrt(cur.w);
					}
				}
			}
			road += 0.5;
			railway+=0.5;
			pw.printf("Case #%d: %d %d %d\n",i+1,states,(int)road,(int)railway);
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
