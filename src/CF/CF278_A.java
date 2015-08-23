package CF;
import java.util.*;
public class CF278_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long s = sc.nextLong();
		int res = 0;
		for (int i = 0; i < 30; i++) {
			res++;
			s++;
			if(isLucky(s)) {
				break;
			}
		}
		
		System.out.println(res);
		
		sc.close();
	}
	
	static boolean isLucky(long n) {
		String s = Long.toString(n);
		if(s.contains("8")) return true;
		return false;
	}

}
