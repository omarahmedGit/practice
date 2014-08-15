package CF;
import java.util.*;
import java.io.*;

public class CFE_149 {

	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		segment_tree tree = new segment_tree(n,arr);
		st = new StringTokenizer(br.readLine());
		
		int op = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < op; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			if(t==1)
			{
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				long sum = tree.query_tree(1, 0, n-1, a-1, b-1);
				pw.println(sum);
			} else {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				tree.update_tree(1, 0, n-1, a-1, b-1, c);
			}
		}
		pw.close();
		br.close();
	}
	
	public static class segment_tree {
		
		int[][] tree ;
		int[] arr  ;
		long[] lazy ;
		
		public segment_tree(int n, int[] arrr)
		{
			tree = new int[4*n][64];
			lazy = new long[4*n];
			this.arr  = new int[n];
			for(int i=0;i<n;i++) this.arr[i] = arrr[i];
			build_tree(1,0,n-1);
		}
		
		static long getSum(int[] arrr)
		{
			long carry = 0, sum =0;
			
			for(int i=0;i<64;i++)
			{
				long val = arrr[i]+carry ;
				sum += (val&1)==1?1L<<i:0;
				carry = val>>1;
			}
			return sum;
		}
		
		void build_tree(int node,int a,int b)
		{
			if(a>b) return ;
			
			if(a==b) {
				for(int i=0;i<64;i++)
					tree[node][i] = (arr[a]&(1L<<i))==0?0:1;
				return ;
			}
			build_tree(node*2,a, (a+b)/2);
			build_tree(1+node*2,1+(a+b)/2, b);
			
			for(int i=0;i<64;i++)
				tree[node][i] = tree[node*2][i] + tree[1+node*2][i] ;	
		}
		
		
		
		static int[] eval(int[] a, long val,int i,int j)
		{
			int n = j-i+1;
			
			for(int k=0;k<64;k++)
			{
				if((val&1L<<k)!=0)
				{
					a[k] = n-a[k];
				}
			}
			
			return a;
		}
		void update_tree(int node,int a,int b,int i,int j,int value)
		{
			if(lazy[node]!=0)
			{
				//tree node
				tree[node] = eval(tree[node],lazy[node],a,b);
				
				if(a!=b)
				{
					lazy[node*2] ^= lazy[node] ;
					lazy[1+node*2] ^= lazy[node] ;
				}
				lazy[node] = 0;
			}
			
			if(a>b||a>j||b<i) return ;
			
			if(a>=i&&b<=j)
			{
				tree[node] = eval(tree[node],value,a,b);
				
				if(a!=b)
				{
					lazy[node*2] ^=value ;
					lazy[1+node*2] ^=value;
				}
				return ;
			}
			
			update_tree(node*2,a,(a+b)/2,i,j,value);
			update_tree(1+node*2,1+(a+b)/2,b,i,j,value);
			
			for(int r=0;r<64;r++)
				tree[node][r] = tree[node*2][r] + tree[1+node*2][r] ;
			
		}
		
		long query_tree(int node,int a,int b,int i,int j)
		{
			
			if(a>b||a>j||b<i) return 0;
			
			if(lazy[node]!=0)
			{
				tree[node] = eval(tree[node],lazy[node],a,b);
				if(a!=b)
				{
					lazy[node*2] ^= lazy[node];
					lazy[1+node*2] ^= lazy[node];
				}
				lazy[node] = 0;
			}
			
			if(a>=i&&b<=j)
			{
				return getSum(tree[node]);
			}
			
			long q1 = query_tree(node*2,a,(a+b)/2,i,j);
			long q2 = query_tree(1+node*2,1+(a+b)/2,b,i,j);
			
			return q1+q2;
		}
		
		
		
	}

}
