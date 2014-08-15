package CF;
import java.util.*;
public class CF215_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
		int d= sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		Arrays.sort(a);
		int m = sc.nextInt();
		int ans =0;
		for (int i = 0; i < m; i++) {
			if(i<a.length)
				ans+=a[i];
			else
				ans-=d;
		}
		System.out.println(ans);
		sc.close();
	}

}
