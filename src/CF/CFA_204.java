package CF;
import java.util.*;
public class CFA_204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = sc.nextInt();
		int f=0,z=0;
		for (int i = 0; i < in; i++) {
			int x = sc.nextInt();
			if(x==5) f++;
			else z++;
		}
		sc.close();

		int lo = f/9;
		if(z==0)
		{
			System.out.println(-1);
			return ;
		}
		if(lo==0)
		{
			System.out.println(0);
			return ;
		}
		
		for (int i = 0; i < lo; i++) {
			System.out.print(555555555);
		}
		
		for (int i = 0; i < z; i++) {
			System.out.print(0);
		}
		System.out.println();

		
	}

}
