package CF;
import java.util.*;
public class CFA_210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextInt();
		double  k= sc.nextInt();
		
		int step = (int)Math.ceil((k/n)-0.5);
		int plus = (int)k-(step*(int)(n-1));
		
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
			{
				if(j==i)
					System.out.print(plus);
				else
					System.out.print(step);
				if(j==n-1)
					System.out.println();
				else
					System.out.print(" ");
			}
		sc.close();

	}

}
