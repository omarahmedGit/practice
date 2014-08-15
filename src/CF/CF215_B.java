package CF;
import java.util.*;

public class CF215_B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		boolean[] a = new boolean[100003];
		int[] b = new int[n];
		int last = 0;
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		int[] sol = new int[n];
		for (int i = n-1; i > -1; i--) {
			if(a[b[i]])
			{
				sol[i] = last;
			}
			else
			{
				a[b[i]] = true;
				sol[i] = ++last;
			}
		}
		for (int i = 0; i < m; i++) {
			int d = sc.nextInt();
			System.out.println(sol[d-1]);
		}
		sc.close();
	}

}
