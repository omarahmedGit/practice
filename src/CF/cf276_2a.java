package CF;
import java.util.*;

public class cf276_2a {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		long a = sc.nextInt();
		long b = sc.nextInt();
		boolean ch = false;
		for (int i=0 ; i<b ;i++) {
			a += (a%b);
			//System.out.println(a);
			if(a%b == 0) {
				ch = true;
				break;
			}
		}

		if(ch)
			System.out.println("Yes");
		else System.out.println("No");



		sc.close();
	}

}