package SPOJ;
import java.util.*;
import java.io.*;

public class HORRIBLE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(st.nextToken());
		int n , c, p, q, v;
		while(t-->0)
		{
			st= new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			segment_tree tree = new segment_tree(n);
			for (int i = 0; i < c; i++) {
				st= new StringTokenizer(br.readLine());
				int com = Integer.parseInt(st.nextToken());
				if(com==0)
				{
					p = Integer.parseInt(st.nextToken());
					q = Integer.parseInt(st.nextToken());
					v = Integer.parseInt(st.nextToken());
					tree.update_tree(1,0,n-1,p-1, q-1,v);
				} else {
					p = Integer.parseInt(st.nextToken());
					q = Integer.parseInt(st.nextToken());
					long sum = tree.query_tree(1,0,n-1,p-1,q-1);
					pw.println(sum);
				}
			}
		}
		
		pw.close();
	}
	
	
	public static class segment_tree{
		long[] tree ;
		long[] lazy ;
		public segment_tree(int n)
		{
			tree = new long[4*n];
			lazy = new long[4*n];
			//build_tree(1,0,n-1);
		}
		
//		void build_tree(int node , int a, int b)
//		{
//				if(a>b) return ;
//				
//				if(a==b)
//				{
//					tree[node] = 0 ;
//					return ;
//				}
//				
//				build_tree(node*2, a, (a+b)/2);
//				build_tree(1+(node*2), 1+((a+b)/2), b);
//				
//				tree[node] = tree[node*2]+tree[1+(node*2)] ;
//		}
		
		void update_tree(int node , int a ,int b , int i,int j , int value)
		{
			if(lazy[node]!=0)
			{
				tree[node]+=((b-a+1)*lazy[node]);
				if(a!=b)
				{
					lazy[node*2]     +=lazy[node];
					lazy[1+(node*2)] +=lazy[node];
				}
				lazy[node] =0;
			}
			
			if(a>b||a>j||b<i) return ;
			
			if(a>=i&&b<=j)
			{
				tree[node]+=((b-a+1L)*value) ;
				if(a!=b)
				{
					lazy[node*2]    +=value;
					lazy[1+(node*2)]+=value;
				}
				return ;
			}
			
			update_tree(node*2, a, (a+b)/2, i, j, value );
			update_tree(1+(node*2), 1+((a+b)/2), b, i, j, value);
			
			tree[node] = tree[node*2] + tree[1+(node*2)] ;
		}
		
		long query_tree(int node, int a, int b, int i, int j)
		{
			if(a>b||a>j||b<i) return 0;
			
			if(lazy[node]!=0)
			{
				
				tree[node]+=((b-a+1L)*lazy[node]);
				if(a!=b)
				{
					lazy[node*2]    +=lazy[node];
					lazy[(node*2)+1]+=lazy[node];
				}
				lazy[node]=0;
			}
			
			if(a>=i&&b<=j)
				return tree[node];
			
			long q1 = query_tree(node*2,a,(a+b)/2,i,j);
			long q2 = query_tree(1+(node*2),1+((a+b)/2),b,i,j);
			
			long res = q1+q2;
			
			return res ;
		}
		
	}

}
