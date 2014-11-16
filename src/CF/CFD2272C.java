package CF;
import java.util.*;
public class CFD2272C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		sc.close();
		
		long modulo = 1000000007L;
		long k, left, right,x;
		long ret = 0;
		long level = b;
		boolean check = true;
		while(check) {
			for(long i=1;i<b;i++) {
				x =  level+i;
				right = x - ((x/b)*b);
				left = x/b;
				k = left/right;
				if(k*right==left&&k<=a) {
					ret = (ret%modulo+x%modulo)%modulo;
					System.out.println(ret);
				}
				if(k>a)
					check = false;
			}
			level+=b;
		}
		System.out.println(ret);
		
	}

}
