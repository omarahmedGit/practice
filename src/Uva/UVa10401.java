package Uva;
import java.util.*;
public class UVa10401 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long[][] graph;
		boolean[][] vis ;
		PriorityQueue<IntegerPair> q;
		while(sc.hasNext())
		{
			q = new PriorityQueue<IntegerPair>();
			graph = new long[15][15];
			vis = new boolean[15][15];
			char[] in = sc.next().toCharArray();
			int n = in.length;
			int[] col = new int[in.length];
			for (int i = 0; i < in.length; i++) {
				if(in[i]=='?')
					col[i] = -1;
				else
					col[i] = (in[i]>'0'&in[i]<='9')?(in[i]-'0'-1):(in[i]-'A')+9;		
			}
			
			
			if(n==1|n==0)
			{
				System.out.println(n);
				continue;
			}
			if(col[0]==-1)
			{
				if(col[1]==-1)
				{
					for (int i = 0; i < n; i++) {
						q.add(new IntegerPair(i,0));
						graph[i][0] = 1;
					}
					
				} else {
					for (int i = 0; i < n; i++) {
						if(Math.abs(col[1]-i)>1){
							q.add(new IntegerPair(i,0));
							graph[i][0] = 1;
						}
					}
				}
			} else {
				q.add(new IntegerPair(col[0], 0));
				graph[col[0]][0] = 1;
			}
			
			IntegerPair cur ;
			while(!q.isEmpty())
			{
				cur  = q.poll();
				if(vis[cur.f1][cur.f2]) continue;
				vis[cur.f1][cur.f2] = true;
				if(cur.f2<n-1)
				{
					if(col[cur.f2+1]!=-1)
					{
						if(Math.abs(cur.f1-col[cur.f2+1])>1)
						{
							q.add(new IntegerPair(col[cur.f2+1],cur.f2+1));
							graph[col[cur.f2+1]][cur.f2+1] += graph[cur.f1][cur.f2];
						}
						
					} else {
						
						for (int i = 0; i < n; i++) {
							if(Math.abs(i-cur.f1)>1)
							{
								if(cur.f2+1==n-1)
								{
									graph[i][cur.f2+1]+=graph[cur.f1][cur.f2];
								} else {
									if(col[cur.f2+1]==-1)
									{
										graph[i][cur.f2+1]+=graph[cur.f1][cur.f2];
										q.add(new IntegerPair(i,cur.f2+1));
									} else {
										if(Math.abs(i-col[cur.f2+1])>1)
										{
											graph[i][cur.f2+1]+=graph[cur.f1][cur.f2];
											q.add(new IntegerPair(i,cur.f2+1));
										}
									}
								}
							}
						}	
					}
				}
			}
			long sol = 0;
			for(int i=0;i<n;i++)
			{
				sol+=graph[i][n-1];
			}
			System.out.println(sol);
			
		}
		
		
		
		
		sc.close();
	}
	
	public static class IntegerPair implements Comparable<IntegerPair>
	{
		int f1,f2;
		public IntegerPair(int a,int b)
		{
			f1 = a;
			f2 = b;
		}
		public int compareTo(IntegerPair o)
		{
			return this.f2-o.f2;
		}
	}
	

}
