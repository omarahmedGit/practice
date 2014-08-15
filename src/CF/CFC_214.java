package CF;
import java.util.Scanner;

public class CFC_214 {
	static int[] a;
	static int[] b;
	static int k, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		a = new int[n];
		b = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
		int sum = 0;
		int suma = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] % k == 0&&(a[i]+sum)%((suma+b[i])*k)==0) {
				sum += a[i];
			}
		}
		if (sum == 0)
			System.out.println(-1);
		else
			System.out.println(sum);
		sc.close();
	}

}
