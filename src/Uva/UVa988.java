package Uva;
import java.util.*;
public class UVa988 {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int[] degree ,w;
	private static PriorityQueue<IntegerPair> q;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n ,s , c;
		boolean blankLine = false;
		while(sc.hasNext())
		{
			n = sc.nextInt();
			if(blankLine) System.out.println();
			blankLine = true;
			q      = new PriorityQueue<IntegerPair>();
			graph  = new ArrayList<ArrayList<Integer>>();
			degree = new int[n];
			w 	   = new int[n];
			for(int i=0;i<n;i++){
				graph.add(new ArrayList<Integer>());
			}
			for (ArrayList<Integer> x :graph) {
				s = sc.nextInt();
				for (int j = 0; j < s; j++) {
					c = sc.nextInt();
					x.add(c);
					degree[c]++;
				}
			}
			
			for (int i = 0; i < n; i++) {
				q.add(new IntegerPair(i,degree[i]));
			}
			
			IntegerPair cur ;
			while(!q.isEmpty())
			{
				cur = q.poll();
				if(cur.b!=0) break;
				
				if(w[cur.a]==0) w[cur.a]=1;
				
				for(int x : graph.get(cur.a))
				{
					q.add(new IntegerPair(x,--degree[x]));
					w[x]+=w[cur.a];
				}
				
			}
			int solution = 0,index = 0;
			for(ArrayList<Integer> x: graph)
			{
				if(x.size()==0)
				{
					solution+=w[index];
				}
				++index;
			}
			
			System.out.println(solution);
		}
		
		
		sc.close();
	}
	
	public static class IntegerPair implements Comparable<IntegerPair>
	{
		int a,b;
		public IntegerPair(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
		public int compareTo(IntegerPair o)
		{
			return this.b-o.b;
		}
		
	}

}
