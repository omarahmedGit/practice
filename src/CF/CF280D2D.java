package CF;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class CF280D2D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		long x = sc.nextLong();
		long y = sc.nextLong();

		while (n-- > 0) {
			long t = sc.nextLong();
			long l = 0;
			long h = 1000000000000000000L;

			while (l < h) {
				long m = (l + h) / (2L);
				long s = (m / x) + (m / y);
				if (s >= t)
					h = m;
				else
					l = m + 1;
			}

			long ty = l / y * y;
			long tx = l / x * x;
			
			if(ty==tx)
				pw.println("Both");
			else if(ty<tx)
				pw.println("Vova");
			else
				pw.println("Vanya");
			
		}
		sc.close();
		pw.close();

	}

}
