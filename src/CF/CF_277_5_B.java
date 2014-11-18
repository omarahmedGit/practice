package CF;
import java.util.*;
public class CF_277_5_B {
	static int[] b,g;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		b = new int[n];
		for (int i = 0; i < n; i++) {
			b[i]=sc.nextInt();
		}
		int m = sc.nextInt();
		g = new int[m];
		for (int i = 0; i < m; i++) {
			g[i] = sc.nextInt();
		}
		
		sc.close();
		
		Arrays.sort(b);
		Arrays.sort(g);
		
		boolean[] v = new boolean[m];
		int res = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!v[j] && Math.abs(b[i]-g[j])<=1) {
					v[j] = true;
					res++;
					break;
				}
			}
		}
		System.out.println(res);
		
	}
	
	
	
	
	
	
	
}
