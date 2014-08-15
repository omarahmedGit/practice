package SPOJ;

import java.util.*;
import java.io.*;

public class LITE {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		segment_tree tree = new segment_tree(n);
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(t==0)
			{
				tree.update_tree(1, 0, n-1, a-1, b-1);
			} else {
				long ans = tree.query_tree(1, 0, n-1, a-1, b-1);
				pw.println(ans);
			}
		}
		
		pw.close();
		br.close();
	}
	
	public static class segment_tree {
		int[] tree ;
		boolean[] lazy ;
		segment_tree(int n)
		{
			tree = new int[4*n];
			lazy = new boolean[4*n];
		}
		
		
		void update_tree(int node,int a,int b,int i,int j)
		{	
			if(lazy[node])
			{
				tree[node] = Math.abs((b-a+1)-tree[node]);
				if(a!=b)
				{
					lazy[node*2]^=true;
					lazy[1+node*2]^=true;
				}
				lazy[node] = false;
			}
			if(a>b||a>j||b<i) return ;
			
			if(a>=i&&b<=j)
			{
				tree[node]=Math.abs((b-a+1)-tree[node]);
				
				if(a!=b)
				{
					lazy[node*2]^=true;
					lazy[1+node*2]^=true;
				}
				
				return ;
			}
			
			update_tree(node*2,a,(a+b)/2,i,j);
			update_tree(1+node*2,1+(a+b)/2,b,i,j);
			
			tree[node] = tree[node*2] + tree[1+node*2];
		}
		
		int query_tree(int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i) return 0;
			
			if(lazy[node])
			{
				tree[node] = Math.abs((b-a+1)-tree[node]);
				if(a!=b)
				{
					lazy[node*2]^=true;
					lazy[1+node*2]^=true;
				}
				lazy[node] = false;
			}
			
			if(a>=i&&b<=j) return tree[node];
			
			int q1 = query_tree(node*2,a,(a+b)/2,i,j);
			int q2 = query_tree(1+node*2,1+(a+b)/2,b,i,j);
			
			return q1+q2;
		}
		
		
	}

}
