package Uva;
import java.util.*;
import java.io.*;
public class UVa452 {
	
	private static boolean[][] graph = new boolean[27][27];
	private static int[] w = new int[27];
	private static int[] in = new int[27];
	private static int[] degree = new int[27];
	private static int max ;
	private static PriorityQueue<node> q;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		StringTokenizer st;
		boolean inside ;
		br.readLine();
		for(int ii=0;ii<=test;ii++)
		{
			inside = false;
			max = 0;
			q = new PriorityQueue<node>();
			graph = new boolean[27][27];
			while(true)
			{
				String sd = br.readLine();
				if(sd==null||sd.length()==0) break;
				st = new StringTokenizer(sd);
				inside = true;
				boolean before = false;
				if(st.countTokens()>2) before = true;
				char task = st.nextToken().charAt(0);
				in[task-'A'] = Integer.parseInt(st.nextToken());
				degree[task-'A'] = 0;
				w[task-'A'] =0;
				if(before)
				{
					char[] b = st.nextToken().toCharArray();
					degree[task-'A']=b.length;
					for(int i=0;i<b.length;i++)
					{
						graph[b[i]-'A'][task-'A'] = true;
					}
				}
				q.add(new node(task-'A',degree[task-'A']));
			}
			if(inside)
			{
				longestPath();
				System.out.println(max);
				if(ii<test-1)
					System.out.println();
			}
		}
		
		br.close();
	}
	
	public static void longestPath()
	{
		node cur ;
		
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(cur.d!=0) break;
			if(w[cur.i]==0)
				w[cur.i]=in[cur.i];
			for(int i=0;i<27;i++)
			{
				if(graph[cur.i][i])
				{
					q.add(new node(i,--degree[i]));
					if(w[cur.i]+in[i]>w[i])
					{
						w[i] = w[cur.i]+in[i];
						max = Math.max(max, w[i]);
					}
				}
			}
			
		}
	}
	
	public static class node implements Comparable<node>
	{
		int i,d;
		public node (int i,int d)
		{
			this.i = i;
			this.d = d;
		}
		public int compareTo(node o)
		{
			return this.d-o.d;
		}
	}
	
	

}
