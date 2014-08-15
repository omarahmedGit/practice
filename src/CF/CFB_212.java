package CF;
import java.util.*;
public class CFB_212 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k  = sc.nextInt();
		int n = sc.nextInt();
		int[] m = new int[n];
		
		for (int i = 0; i < n; i++) {
			m[i]=sc.nextInt();
		}
		Arrays.sort(m);
		sc.close();

		if(n==0)
		{
			
			System.out.println("YES");
			return ;
		}
		if(m[n-1]==k||m[0]==1)
		{
			System.out.println("NO");
			return ;
		}
		for (int i = 0; i+2 < m.length; i++) {
			if(m[i]+1==m[i+1]&&m[i+1]+1==m[i+2])
			{
				System.out.println("NO");
				return ;
			}
		}
		System.out.println("YES");
	}

}
