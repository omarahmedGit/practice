package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class KGSS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		segment_tree tree = new segment_tree(n,arr);
		
		st = new StringTokenizer(br.readLine());
		int q = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			
			char c = st.nextToken().charAt(0);
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(c=='Q')
			{
				pair out = tree.query_tree(1, 0, n-1, a-1, b-1);
				long result = out.a+out.b;
				pw.println(result);
			} else {
				tree.update_tree(1, 0, n-1, a-1, a-1, b);
			}
			
		}
		
		br.close();
		pw.close();
	}
	
	public static class segment_tree {
		pair[] tree ;
		int[]  arr ;
		int[] lazy ;
		segment_tree(int n,int[] a)
		{
			tree = new pair[4*n];
			lazy = new int[4*n];
			arr  = new int[n];
			for(int i=0;i<n;i++) arr[i]=a[i];
			for(int i=0;i<4*n;i++) lazy[i]=-1;
			
			build_tree(1,0,n-1);
		}
		
		void build_tree(int node,int a,int b)
		{
			if(a>b) return ;
			
			if(a==b)
			{
				tree[node] = new pair(arr[a],-Integer.MAX_VALUE);
				return ;
			}
			
			build_tree(node*2,a,(a+b)/2);
			build_tree(1+node*2,1+(a+b)/2,b);
			
			int[] val = {tree[node*2].a,tree[node*2].b,tree[1+node*2].a,tree[1+node*2].b};
			Arrays.sort(val);
			tree[node] = new pair(val[2], val[3]);
		}
		
		pair query_tree(int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i) return new pair(-Integer.MAX_VALUE,-Integer.MAX_VALUE);
			
			if(lazy[node]>=0)
			{
				if(a!=b)
				{
					tree[node].a=tree[node].b=lazy[node];
					lazy[node*2] = lazy[1+node*2] = lazy[node];
				} else {
					tree[node].a=lazy[node];
					tree[node].b=-Integer.MAX_VALUE;
				}
				lazy[node] = -1;
			}
			
			
			if(a>=i&&b<=j)
				return tree[node];
			
			pair q1 = query_tree(node*2, a, (a+b)/2, i, j);
			pair q2 = query_tree(1+node*2,1+(a+b)/2,b, i, j);
			
			int[] val = {q1.a,q1.b,q2.a,q2.b};
			Arrays.sort(val);
			
			return new pair(val[2],val[3]);
		}
		
		
		void update_tree(int node,int a,int b,int i,int j,int value)
		{
			if(lazy[node]>=0)
			{
				if(a!=b)
				{
					tree[node].a=tree[node].b=lazy[node];
					lazy[node*2] = lazy[1+node*2] = lazy[node];
				} else {
					tree[node].a=lazy[node];
					tree[node].b=-Integer.MAX_VALUE;
				}
				lazy[node] = -1;
			}
			
			if(a>b||a>j||b<i) return ;
			
			if(a>=i&&b<=j)
			{
				if(a!=b)
				{
					tree[node].a=tree[node].b=value;
					lazy[node*2] = lazy[1+node*2] = value;
				} else {
					tree[node].a=value;
					tree[node].b=-Integer.MAX_VALUE;
				}
				return ;
			}
			
			update_tree(node*2,a,(a+b)/2,i,j,value);
			update_tree(1+node*2,1+(a+b)/2,b,i,j,value);
			
			int[] val = {tree[node*2].a,tree[node*2].b,tree[1+node*2].a,tree[1+node*2].b};
			Arrays.sort(val);
			
			tree[node] = new pair(val[2], val[3]);
		}
		
		
		
	}
	
	public static class pair {
		int a,b;
		pair(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
	}
}
