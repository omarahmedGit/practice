package Uva;
import java.util.*;
import java.io.*;
public class UVa11747 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int vertex,edges,a,b,w;
		ArrayList<node> edgeList;
		Union_Find_Set U;
		ArrayList<Integer> solution;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			vertex = Integer.parseInt(st.nextToken());
			edges  = Integer.parseInt(st.nextToken());
			if(vertex==0&edges==0) break;

			edgeList = new ArrayList<node>();
			U = new Union_Find_Set(vertex);
			solution = new ArrayList<Integer>();

			for (int i =0; i<edges; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				edgeList.add(new node(a,b,w));
			}

			Collections.sort(edgeList);

			node cur;
			for (int i=0; i< edges; i++) {
				cur = edgeList.get(i);
				if(!U.isInTheSameSet(cur.a,cur.b))
				{
					U.merge(cur.a,cur.b);
				}
				else {
					solution.add(cur.w);
				}
			}

			for (int i =0; i< solution.size(); i++) {
				pw.print(solution.get(i));
				if(i!=solution.size()-1)
					pw.print(' ');
			}
			
			if(solution.size()==0)
				pw.print("forest");

			pw.println();

		}

		
		
		br.close();
		pw.close();
	}
	


	
	static class node implements Comparable<node>
	{
		int a,b,w;

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
