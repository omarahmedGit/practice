package CF;
import java.util.*;
public class CFA_GOODBYE {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ans = 0;
		int c =0;
		while(a>0)
		{
			a--;
			ans++;
			c++;
			if(c==b) {a++; c=0;}
		}
		System.out.println(ans);
		
		sc.close();
	}

}
