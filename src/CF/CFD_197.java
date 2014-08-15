package CF;
import java.util.*;
import java.io.*;
public class CFD_197 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n,k,m;
		
		k = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		n = 1<<k;
		
		int[] arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		segment_tree tree = new segment_tree(n,k,arr);
		int a,b;
		long ans ;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			tree.update(1, 0, n-1, a-1, a-1, b, k);
			ans = tree.query();
			pw.println(ans);
		}
		
		
		
		pw.close();
		br.close();
	}
	
	
	public static class segment_tree {
		long[] tree ;
		long[] arr  ;
		
		segment_tree(int n,int k,int[] r)
		{
			tree = new long[4*n];
			arr  = new long[n];
			for(int i=0;i<n;i++) arr[i] = r[i];
			build(1,0,n-1,k);
		}
		
		void build(int node,int a,int b,int k)
		{
			if(a>b) return ;
			
			if(a==b)
			{
				tree[node] = arr[a];
				return ;
			}
			
			build(node*2,a,(a+b)/2,k-1);
			build(1+node*2,1+(a+b)/2,b,k-1);
			
			if(k%2==1)
			{
				tree[node] = tree[node*2] | tree[1+node*2] ;
			} else {
				tree[node] = tree[node*2] ^ tree[1+node*2] ; 
			}
			
			
		}
		
		long query()
		{
			return tree[1];
		}
		
//		long query(int node,int a,int b,int i,int j,int k)
//		{
//			if(a>b||a>j||b<i) return 0;
//			
//			if(a>=i&&b<=j)
//				return tree[node];
//			
//			long q1 = query(node*2, a, (a+b)/2, i, j, k-1);
//			long q2 = query(1+node*2,1+(a+b)/2,b, i, j, k-1);
//
//			if(k%2==1)
//				return q1|q2;
//			else return q1^q2;
//		}
		
		void update(int node,int a,int b,int i,int j,int v,int k)
		{
			if(a>b||a>j||b<i) return ;
			
			if(a==b)
			{
				tree[node] = v ;
				return ;
			}
			
			update(node*2,a,(a+b)/2,i,j,v,k-1);
			update(1+node*2,1+(a+b)/2,b,i,j,v,k-1);
			
			if(k%2==1)
			{
				tree[node] = tree[node*2] | tree[1+node*2] ;
			} else {
				tree[node] = tree[node*2] ^ tree[1+node*2] ; 
			}	
		}
		
	}

}
