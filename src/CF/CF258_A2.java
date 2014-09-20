package CF;
import java.util.*;
public class CF258_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.close();
		
		if(Math.min(n, m)%2==1)
			System.out.println("Akshat");
		else
			System.out.println("Malvika");
	}

}
