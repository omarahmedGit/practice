package CF;
import java.util.*;
public class CF280D2B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int street = sc.nextInt();
		int[] m = new int[n];
		
		for (int i = 0; i < n; i++) {
			m[i] = sc.nextInt();
		}
		Arrays.sort(m);
		sc.close();
		
		int zero,end,max=-1;
		
		zero = m[0];
		end = street-m[n-1];
		
		for (int i = 0; i < n-1; i++) {
			max = Math.max(max,m[i+1]-m[i]);
		}
		
		double mmax = Math.max(Math.max(zero, end),(double)max/2.0);
		
		System.out.printf("%.10f\n",mmax);
	}
}
