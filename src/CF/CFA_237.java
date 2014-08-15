package CF;
import java.util.*;
public class CFA_237 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		char[][] input = new char[size][size];

		

		for (int i =0;i<size;i++) {
			input[i] = sc.next().toCharArray();
		}

		char d = input[0][0];
		char o = input[0][1];

		sc.close();
		if(d==o)
		{
			System.out.println("NO");
			return ;
		}
		for(int i=0 ; i<size ;i++)
		{
			for(int j=0;j<size;j++)
			{
				if(j==i|j==size-1-i)
				{
					if(input[i][j]!=d)
					{
						System.out.println("NO");
						return ;
					}

				} else {
					if(input[i][j]!=o)
					{
						System.out.println("NO");
						return ;
					}
				}

			}
			
		}

		System.out.println("YES");
	}

}
