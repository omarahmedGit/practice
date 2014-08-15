package CF;

import java.util.*;
import java.io.*;

public class CFE_6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] ar = new int[n];
		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(st.nextToken());
		}
		
		segment_tree tree = new segment_tree(n,ar,k);
		
		
		ArrayList<pair> ans = tree.sol;
		int a = 0,b=0;
		if(ans.size()>0)
		{
			pair f = ans.get(0);
			b = tree.sol.size();
			a = Math.abs(f.b-f.a+1);
		}
		
		pw.printf("%d %d\n",a,b);
		for(pair x:tree.sol)
		{
			pw.printf("%d %d\n",x.a+1,x.b+1);
		}
		
		
		pw.close();
		br.close();
	}
	
	
	public static class segment_tree {
		pair[] tree ;
		int[] val; 
		int k;
		ArrayList<pair> sol ;
		
		segment_tree(int n,int[] r,int k)
		{
			sol = new ArrayList<pair>();
			tree = new pair[4*n];
			val  = new int[n];
			this.k = k;
			for(int i=0;i<n;i++) val[i] = r[i];
			build(1,0,n-1);
			search(n);
		}
		
		void build(int node,int a,int b)
		{
			if(a>b) return ;
			
			if(a==b)
			{
				tree[node] = new pair(val[a],val[a]);
				return ;
			}
			
			build(node*2,a,(a+b)/2);
			build(1+node*2,1+(a+b)/2,b);
			
			tree[node] = new pair(Math.min(tree[node*2].a, tree[1+node*2].a),Math.max(tree[node*2].b, tree[1+node*2].b));
		}
		
		pair query(int node,int a,int b,int i,int j)
		{
			if(a>b||a>j||b<i)
				return new pair(1000000000,0);
			
			if(a>=i&&b<=j)
				return tree[node];
			
			pair q1 = query(node*2,a,(a+b)/2,i,j);
			pair q2 = query(1+node*2,1+(a+b)/2,b,i,j);
			
			
			return new pair(Math.min(q1.a, q2.a),Math.max(q1.b,q2.b));
			
		}
		
		void search(int n)
		{
			boolean found = false;
			int f = 0;
			int l=1,h=n;
			int a = -1;
			int i,j;
			while(l<=h)
			{
				f = (l+h)/2;
				i=0; j=f-1;
				
				while(j<n)
				{
					if(check(query(1,0,n-1,i,j)))
					{
						found = true;
					}
					i++;j++;
				}
				
				if(found)
				{
					found = false;
					a = f;
					l = f+1;
				} else {
					h = f-1;
				}
			}
			
			i = 0; j = a-1;
			while(j<n)
			{
				if(check(query(1,0,n-1,i,j)))
				{
					sol.add(new pair(i,j));
				}
				i++;j++;
			}
			
		}
		boolean check(pair ch)
		{
			return (Math.abs(ch.b-ch.a)>this.k)?false:true ;
		}
		
		
		
	}
	
	public static class pair {
		int a,b;
		pair(int a,int b)
		{
			this.a = a ;
			this.b = b ;
		}
	}

}
