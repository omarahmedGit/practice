package CF;
import java.util.*;
import java.io.*;


public class CFC_169 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		int[] val = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < val.length; i++) {
			val[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(val);
		int a,b;
		segment_tree tree = new segment_tree(n);
		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			tree.update_tree(1, 0, n-1, a-1, b-1);
		}
		Long[] ar = new Long[n];
		for (int i = 0; i < val.length; i++) {
			ar[i]=tree.query_tree(1, 0, n-1, i, i);
		}
		Arrays.sort(ar);
//		System.out.println(Arrays.toString(ar));
		long sum = 0;
		
		for (int i = 0; i < val.length; i++) {
			sum+=(ar[i]*val[i]);
		}
		System.out.println(sum);
		
		br.close();
	}
	
	
	public static class segment_tree {
		int[] tree ;
		int[] lazy ;
		segment_tree(int n){
			tree = new int[4*n];
			lazy = new int[4*n];
		}
		
		void update_tree(int node,int a,int b,int i,int j)
		{
			if(lazy[node]!=0)
			{
				tree[node]+=lazy[node];
				if(a!=b)
				{
					lazy[2*node] += lazy[node];
					lazy[1+2*node] += lazy[node];
				}
				lazy[node] = 0;
			}
			if(a>b||a>j||b<i) return ;
			
			if(a>=i&&b<=j)
			{
				tree[node]++;
				if(a!=b)
				{
					lazy[node*2]++;
					lazy[1+node*2]++;
				}
				return ;
			}
			update_tree(node*2,a,(a+b)/2,i,j);
			update_tree(1+node*2,1+(a+b)/2,b,i,j);
			
			tree[node] = tree[node*2] + tree[1+node*2];
		}
		
		long query_tree(int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i) return 0;
			
			if(lazy[node]!=0)
			{
				tree[node]+=lazy[node];
				if(a!=b)
				{
					lazy[2*node] += lazy[node];
					lazy[1+2*node] += lazy[node];
				}
				lazy[node] = 0;
			}
			if(a>=i&&b<=j) return tree[node] ;
			
			long q1 = query_tree(node*2,a,(a+b)/2,i,j);
			long q2 = query_tree(1+node*2,1+(a+b)/2,b,i,j);
			
			return q1+q2;
		}
		
		
	}

}
