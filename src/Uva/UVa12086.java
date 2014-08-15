package Uva;
import java.util.*;
import java.io.*;
public class UVa12086 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		int count = 0;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken());
			
			if(n==0) break;
			
			int[] paro = new int[n]; 
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				paro[i] = Integer.parseInt(st.nextToken());
			}
			segment_tree tree = new segment_tree(n,paro);
			
			if(count!=0)
				pw.println();
			pw.printf("Case %d:\n",++count);
			
			while(true)
			{
				st = new StringTokenizer(br.readLine());
				if(st.countTokens()==1) break;
				char com = st.nextToken().charAt(0);
				int  f   = Integer.parseInt(st.nextToken());
				int  b   = Integer.parseInt(st.nextToken());
				if(com=='S')
				{
					tree.update(1, 0, n-1, f-1, f-1, b);
				} else {
					long ans = tree.query(1, 0, n-1, f-1, b-1);
					pw.println(ans);
				}
			}
			
			
		}
		
		
		pw.close();
		br.close();
	}
	
	
	public static class segment_tree {
		long[] tree ;
		long[] arr  ;
		segment_tree(int n ,int[] a) {
			tree = new long[4*n];
			arr  = new long[n];
			for(int i=0;i<n;i++) arr[i] = a[i] ;
			build(1,0,n-1);
		}
		
		void build(int node,int a,int b)
		{
			if(a>b) return ;
			
			if(a==b)
			{
				tree[node] = arr[a];
				return ;
			}
			
			build(node*2,a,(a+b)/2);
			build(1+node*2,1+(a+b)/2,b);
			
			tree[node] = tree[node*2] + tree[1+node*2] ;
		}
		
		void update(int node,int a,int b,int i,int j,int val)
		{
			if(a>b||a>j||b<i) return ;
			if(a==b)
			{
				tree[node] = val ;
				return ;
			}
			update(node*2,a,(a+b)/2,i,j,val);
			update(1+node*2,1+(a+b)/2,b,i,j,val);
			tree[node] = tree[node*2] + tree[1+node*2] ;
		}
		
		long query(int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i) 
				return 0;
			if(a>=i&&b<=j)
				return tree[node];
			
			long q1 = query(node*2,a,(a+b)/2,i,j);
			long q2 = query(1+node*2,1+(a+b)/2,b,i,j);
			
			return q1+q2;
		}
		
		
		
	}

}
