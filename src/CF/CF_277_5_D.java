package CF;
import java.util.*;
public class CF_277_5_D {
	static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	static int[] ret ;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // intersections
		int m = sc.nextInt();
		ret = new int[n+1];
		for (int i = 0; i <= n; i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < m; i++) {
			int f = sc.nextInt();
			int t = sc.nextInt();
			adj.get(f).add(t);
		}
		sc.close();
		
		long sol = 0;
		for (int i = 1; i <= n; i++) {
			dfs(i,i);			
			for (int j = 1; j <= n; j++) {
				
				sol += sum(ret[j]-1);
				ret[j]=0;
			}
			
			
		}
		System.out.println(sol);
		
		
	}
	
	private static long sum(int i) {
		return (i*(i+1))/2;
	}

	static void dfs(int a,int b) {
		ArrayList<Integer> ne = adj.get(b);
		for (int i = 0; i < ne.size(); i++) {
			int c = ne.get(i);
			if(c!=a) {
				if(a==b) {
					dfs(a,c);
				} else {
					ret[c]++;
				}
			}
		}
	}

}
