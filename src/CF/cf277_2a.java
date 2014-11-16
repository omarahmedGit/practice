package CF;
import java.util.*;

public class cf277_2a {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();

		if(n%2==0) {
			System.out.println(n/2L);
		} else {
			long res = (n/2L) - n;
			System.out.println(res);
		}
	}

}