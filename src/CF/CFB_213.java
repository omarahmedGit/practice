package CF;
import java.util.*;
public class CFB_213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int maxlen=1;
		int cur = 1 ;
		a[0]=sc.nextInt();
		for (int i = 1; i < n; i++) {
			a[i]=sc.nextInt();
			if(cur<2)
			{
				cur++;
			}
			else
			{
				if(a[i]==a[i-1]+a[i-2])
				{
					cur++;
				}
				else
				{
					cur = 2;
				}
			}
			if(cur>maxlen)
				maxlen = cur;
		}
		System.out.println(maxlen);
		sc.close();

	}

}
