package CF;
import java.util.Scanner;

public class CFB_210 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		sc.close();

		if (n == k) {
			System.out.println(-1);
			return ;
		}
		else if(k==n-1)
		{
			for(int i=1;i<=n;i++)
			{
				System.out.print(i);
				if(i==n)
					System.out.println();
				else
					System.out.print(" ");
			}
			return ;
		}
		System.out.print(n+" ");
		for (int i = 1,g =k+2, c = 0, j = 2; i <n; i++) {
			if (c< k)
				System.out.print(j++);
			else if(c==k)
				System.out.print(1);
			else
				System.out.print(g++);
			if(i==n-1)
				System.out.println();
			else
				System.out.print(" ");
			c++;
		}
		
	}

}
