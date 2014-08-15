package CF;
import java.util.*;
public class CFB_23 {
	
	public static void main(String args[])
	{
		Scanner sc =  new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			if(n<3)
				n=0;
			else n-=2;
			System.out.println(n);
		}
		
		sc.close();
	}

}
