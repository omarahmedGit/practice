package CF;
import java.util.*;
import java.io.*;
public class CFD_257 {
	static long[] dis = new long[500010] ;
	static boolean[] parent = new boolean[500010] ;
	static boolean[] vis = new boolean[100010];
	static int n,m,k,sol=0;
	static long OO = 1000000000000000L ;
	static HashSet<Integer> hash = new HashSet<Integer>();
	static ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i <= n; i++)
			adj.add(new ArrayList<Pair>());
		int a,b,w;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Pair(b,w,false));
			adj.get(b).add(new Pair(a,w,false));
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			b = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			adj.get(1).add(new Pair(b,w,true));
		}
		
		dijkestra();
		
		for (int i = 2; i <= n; i++)
			if(parent[i]) sol++;
		
		
		
		pw.println(k-sol);
		pw.close();
		br.close();
	}
	
	
	static void dijkestra()
	{
		Arrays.fill(dis, OO);
		
		dis[1] = 0; // source 
		
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		q.add(new Pair(1,0,false));
		Pair cur ;
		while(!q.isEmpty())
		{
			cur = q.poll();
			
			if(vis[cur.a]) continue ;
			vis[cur.a] = true ;
			for (Pair pair : adj.get(cur.a)) {
				long dist = pair.b+cur.b;	
				if(dist<=dis[pair.a])
				{
					if(dist<dis[pair.a])
						parent[pair.a] = pair.train ;
					else if(dist == dis[pair.a] && !pair.train)
						parent[pair.a] = false;
					
					dis[pair.a] = dist ;
					q.add(new Pair(pair.a,dist,pair.train));	
				}
			}
		}
		
	}
	
	public static class Pair implements Comparable<Pair>
	{
		int a;
		long b;
		boolean train ;
		Pair(int a,long b, boolean t)
		{
			this.a = a;
			this.b = b;
			train = t;
		}
		
		public int compareTo(Pair o)
		{
			if(this.b==o.b){
				if(!(this.train^o.train))
					return 0;
				else if(this.train)
					return   1;
				else return  -1;
			}
			long ret = this.b - o.b ;
			return ret>0 ?1:-1;
		}
	}
	
	
	

}
