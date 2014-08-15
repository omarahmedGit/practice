package Uva;
import java.util.*;
public class uva507 {
	static int[] a ;
	static int maxcounter,s;
	boolean t = false;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			a = new int[n-1];
			for (int j = 0; j < n-1; j++) {
				a[j] = sc.nextInt();
			}
			int ans = maxSum();
			if(ans == 0)
				System.out.printf("Route %d has no nice parts\n",i+1);
			else
				System.out.printf("The nicest part of route %d is between stops %d and %d\n",i+1,s+1,s+maxcounter+1);
		}
		sc.close();
	}
	
	
	
	
	public static int maxSum()
	{
		int sum = 0 , ans = 0, ss = 0, counter = 0;
		for (int i = 0; i < a.length; i++) {
			
			sum+=a[i];
			if(sum<0)
			{
				ss = i+1;
				counter = sum = 0;
			}
			else counter++;
//			System.out.println(counter+" "+sum +" "+ ans);
			if(sum>ans)
			{
//				System.out.println(i);
					s = ss;
					maxcounter = counter;
			} else if(sum==ans)
			{
				if(counter>maxcounter)
				{
					s = ss;
					maxcounter = counter;
				}
			}
			ans = Math.max(ans, sum);
			
		}
		return ans;
	}

}
