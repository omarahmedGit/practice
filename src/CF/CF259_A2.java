package CF;
import java.util.*;
public class CF259_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		int a , k = 1;
		for (int i = 1; i <= n; i++) {
			a = (n-k)/2;
			
			for (int j = 0; j < a; j++) {
				System.out.print('*');
			}
			
			for (int j = 0; j < k; j++) {
				System.out.print('D');
			}
			
			for (int j = 0; j < a; j++) {
				System.out.print('*');
			}
			System.out.println();
			
			if(i>n/2)
				k-=2;
			else
				k+=2;
			
		}
	}

}
