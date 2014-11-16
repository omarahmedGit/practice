package CF;
import java.util.*;
public class cf277_2d {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static long[] f;
	static long[] w;
	static boolean[] visited;
	static int d,n;
	static long mod = 1000000007;
	
	static void dfs(int u,int root) {
		visited[u] = true;
		f[u]=1;
		int size = adj.get(u).size();
		ArrayList<Integer> lis = adj.get(u);
		for (int i = 0; i < size; i++) {
			int v = lis.get(i);
			if(!visited[v]) {
				if(w[v]<w[root]||w[v]>w[root]+d) continue;
				if(w[v]==w[root]&&v<root) continue;
				dfs(v,root);
				f[u] = ((f[u]%mod)*((f[v]+1)%mod))%mod;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		d = sc.nextInt();
		n = sc.nextInt();
		w = new long[n];
		f = new long [n];
		visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			w[i]=sc.nextLong();
		}
		
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n-1; i++) {
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			adj.get(a).add(b);
			adj.get(b).add(a);
		}
		
		long ret = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[j] = false;
				f[j] = 0;
			}
			dfs(i,i);
			
			ret = ((ret%mod)+(f[i]%mod))%mod;
		}
		
		System.out.println(ret);
		
		sc.close();
	}

}
