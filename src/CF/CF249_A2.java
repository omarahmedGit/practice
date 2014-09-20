package CF;

import java.util.*;

public class CF249_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int curcapcaity = m;
		int count = 1;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a <= curcapcaity) {
				curcapcaity -= a;
			} else {
				curcapcaity = m-a;
				++count;
			}
		}

		System.out.println(count);
		
		
		sc.close();
	}

}
