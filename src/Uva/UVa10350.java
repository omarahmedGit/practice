package Uva;
import java.util.*;
public class UVa10350 {
	private static ArrayList<IntegerPair>[] path ;
	private static int[] degree = new int[15*120];
	private static int[] w = new int[15*120];
	private static int OO = 1000000000;
	
	private static int M,N;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String name ;
		path = (ArrayList<IntegerPair>[])new ArrayList[15*120];
		while(sc.hasNext())
		{
			name = sc.next();
			N = sc.nextInt();
			M = sc.nextInt();
			
			for(int i=0;i<(M*(N-1));i++)
			{	
				path[i] = new ArrayList<IntegerPair>();
				int start = ((i/M)+1)*M;
				for (int j = 0; j < M; j++) {
					int time = sc.nextInt();
					path[i].add(new IntegerPair(start+j,time));
				}
			}
			
			for (int i = M*(N-1); i < N*M; i++) {
				path[i] = new ArrayList<IntegerPair>();
			}
			
			
			
			System.out.println(name);
			getshortest();
			
		}
		
		sc.close();
	}
	
	public static void getshortest()
	{
		PriorityQueue<IntegerPair> q = new PriorityQueue<IntegerPair>();
		for (int i = 0; i < (M*N); i++) {
			if(i<M)
			{
				q.add(new IntegerPair(i,0));
				degree[i] = 0;
				w[i]=0;
			} else {
				q.add(new IntegerPair(i,M));
				degree[i] = M;
				w[i] = OO;
			}
		}
		IntegerPair cur ;
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(cur.b!=0) break;
			IntegerPair pair ;
			int d;
			for (int i = 0; i < path[cur.a].size(); i++) {
				pair = path[cur.a].get(i);
				d = --degree[pair.a];
				q.add(new IntegerPair(pair.a,d));
				if(w[pair.a]>w[cur.a]+pair.b+2){
					w[pair.a]=w[cur.a]+pair.b+2;
				}
			}	
		}
		int min = OO;
		for (int i = 0,j=(N*M)-1; i < M; j--,i++) {
			min = Math.min(min,w[j]);
		}
		System.out.println(min);
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
