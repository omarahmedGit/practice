package CF;
import java.util.*;

public class CFB_211 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i]= sc.nextInt();
		}
		long insum =0;
		for(int i=0;i<k;i++)
		{
			insum+=a[i];
		}
		long count = insum;
		int reset= 0;
		for(int i=k;i<n;i++)
		{
			count+=a[i];
			count-=a[i-k];
			if(count<insum)
			{
				insum = count;
				reset = i-k+1;
			}
		}
		System.out.println(reset+1);
		sc.close();

	}

}
