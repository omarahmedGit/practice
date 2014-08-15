package CF;
import java.io.*;
import java.util.*;
public class CFC_1 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		segment_tree tree = new segment_tree(n,arr);
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int a,b,c;
			if(st.countTokens()==3)
			{
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				if(b<a)
				{
					tree.update_tree(1, 0, n-1, a, n-1, c);
					tree.update_tree(1, 0, n-1, 0,   b, c);
				} else {
					tree.update_tree(1, 0, n-1, a, b, c);
				}
			} else {
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				if(b<a)
				{
					long v1 = tree.query_tree(1, 0, n-1, a, n-1);
					long v2 = tree.query_tree(1, 0, n-1, 0,   b);
					pw.println(Math.min(v1,v2));
				} else {
					pw.println(tree.query_tree(1, 0, n-1, a, b));
				}
			}
		}
		
		pw.close();
		br.close();
	}
	
	public static class segment_tree {
		long[] tree ;
		long[] val	;
		long[] lazy ;
		segment_tree(int n,int[] arr)
		{
			tree = new long[4*n];
			lazy = new long[4*n];
			val  = new long[n];
			for (int i = 0; i < arr.length; i++) {
				val[i]=arr[i];
			}
			build_tree(1,0,n-1);
		}
		
		void build_tree(int node, int a,int b)
		{
			if(a>b) return ;
			if(a==b)
			{
				tree[node] = val[a];
				return ;
			}
			build_tree(node*2,a,(a+b)/2);
			build_tree(1+node*2,1+(a+b)/2,b);
			
			tree[node] = Math.min(tree[node*2],tree[1+node*2]);
		}
		
		void update_tree(int node,int a,int b,int i,int j,int value)
		{
			if(lazy[node]!=0)
			{
				tree[node]+=lazy[node];
				
				if(a!=b)
				{
					lazy[node*2] += lazy[node];
					lazy[1+node*2] += lazy[node];
				}
				lazy[node] = 0;
			}
			
			if(a>b||a>j||b<i) return ;
			
			if(a>=i&&b<=j)
			{
				tree[node] +=value;
				
				if(a!=b)
				{
					lazy[node*2] += value;
					lazy[1+node*2] += value;
				}
				return ;
			}
			
			update_tree(node*2,a,(a+b)/2,i,j,value);
			update_tree(1+node*2,1+(a+b)/2,b,i,j,value);
			
			tree[node] = Math.min(tree[node*2], tree[1+node*2]);
			
		}
		
		long query_tree (int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i) return Long.MAX_VALUE;
			
			if(lazy[node]!=0)
			{
				tree[node]+=lazy[node];
				if(a!=b)
				{
					lazy[node*2]+=lazy[node];
					lazy[1+node*2]+=lazy[node];
				}
				lazy[node]=0;
			}
			
			if(a>=i&&b<=j)
				return tree[node];
			
			long q1 = query_tree(node*2,a,(a+b)/2,i,j);
			long q2 = query_tree(1+node*2,1+(a+b)/2,b,i,j);
			
			return Math.min(q1, q2);
		}
		
	}

}
