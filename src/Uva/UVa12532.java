package Uva;

import java.util.*;
import java.io.*;

public class UVa12532 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		
		while(true)
		{
			String re = br.readLine();
			if(re==null) break;
			st = new StringTokenizer(re);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			int[] ar = new int[n];
			
			for (int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(st.nextToken());
			}
			
			segment_tree tree = new segment_tree(n,ar);
			
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				
				char command = st.nextToken().charAt(0);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(command=='C')
				{
					tree.update_tree(1, 0, n-1, a-1, a-1, b);
				} else {
					int val = tree.query_tree(1, 0, n-1, a-1, b-1);
					if(val==0)
						pw.print(0);
					else if(val<0)
						pw.print("-");
					else
						pw.print("+");
				}
				
			}
			pw.println();
		}
		
		
		
		
		pw.close();
		br.close();
	}
	
	
	public static class segment_tree {
		int[] tree ;
		int[] arr  ;
		
		segment_tree(int n,int[] a)
		{
			tree = new int[4*n];
			arr  = new int[n];
			for (int i = 0; i < a.length; i++) {
				arr[i]=a[i];
			}
			build_tree(1,0,n-1);
		}
		
		void build_tree(int node,int a,int b)
		{
			if(a>b) return ;
			if(a==b)
			{
				tree[node] = arr[a]==0?0:arr[a]>0?1:-1;
				return ;
			}
			build_tree(node*2,a,(a+b)/2);
			build_tree(1+node*2,1+(a+b)/2,b);
			
			tree[node] = tree[node*2]*tree[1+node*2];
		}
		
		void update_tree(int node,int a,int b,int i,int j,int val)
		{
			if(a>b||a>j||b<i) return ;
			
			if(a==b)
			{
				tree[node] = val==0?0:val>0?1:-1;
				return ;
			}
			
			update_tree(node*2, a, (a+b)/2, i, j, val);
			update_tree(1+node*2,1+(a+b)/2,b, i, j, val);
			
			tree[node] = tree[node*2]*tree[1+node*2];
		}
		
		int query_tree(int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i) return 1;
			
			if(a>=i&&b<=j)
				return tree[node];
			
			int q1 = query_tree(node*2, a, (a+b)/2, i, j);
			int q2 = query_tree(1+node*2, 1+(a+b)/2,b, i, j);
			return q1*q2;
		}
		
		
		
	}

}
