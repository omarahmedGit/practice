package CF;

import java.util.*;

public class CFC_257 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long m = sc.nextLong();
		long k = sc.nextLong();

		if (n + m - 2L < k) {
			System.out.println(-1);
			sc.close();
			return;
		}
		
		long res = 0;
		double x, y;
		x = (n - 1 - k) >= 0 ? k : n - 1;
		y = k - x;
		res = ((long)Math.floor(n / (x + 1)) * (long)Math.floor(m / (y + 1)));
		y = (m - 1 - k) >= 0 ? k : m - 1;
		x = k - y;
		res = Math.max(res,((long)Math.floor(n / (x + 1)) * (long)Math.floor(m / (y + 1))));
		System.out.println(res);
		sc.close();
	}
}
