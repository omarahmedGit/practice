package Uva;
import java.util.*;
public class uva10684 {
	static int[] a = new int[10000];
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		while(sc.hasNext())
		{
			n = sc.nextInt();
			if(n==0) break;
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			int ans = maxSum();
			if(ans!=0)
				System.out.printf("The maximum winning streak is %d.\n",ans);
			else
				System.out.println("Losing streak.");
			
		}
		sc.close();
	}
	
	public static int maxSum()
	{
		int ans = 0, sum = 0;
		for (int i = 0; i < n; i++) {
			sum+=a[i];
			ans = Math.max(sum, ans);
			if(sum<0) sum = 0;
		}
		return ans;
	}
	
	
}
