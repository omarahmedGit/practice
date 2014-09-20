package CF;
import java.util.*;
public class CF256_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cups = 0,medals = 0,n=0;
		
		for (int i = 0; i < 3; i++) {
			cups+=sc.nextInt();
		}
		for (int i = 0; i < 3; i++) {
			medals+=sc.nextInt();
		}
		
		n = sc.nextInt();
		sc.close();
		
		int x = cups/5;
		int y = (cups%5==0)?0:1;
		
		int sum = x+y;
		
		
		x = medals/10;
		y = (medals%10==0)?0:1;
		
		sum+=(x+y);
		
		
		if(sum<=n)
			System.out.println("YES");
		else
			System.out.println("NO");
	}

}
