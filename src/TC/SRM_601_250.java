package TC;
import java.util.*;
public class SRM_601_250 {

	public static void main(String[] args) {
		int[] a = {4,7,4};
		System.out.println(getNumber(a, 3));
	}
	
	
	public static int getNumber(int[] a, int k)
	{
		int min = 1<<30;
		
		
		Arrays.sort(a);
		
		for (int i = a.length-1; i >= 0; i--) {
			if(i>=k-1)
			{
				int dif = 0;
				for (int j = i,h = 1;h<k&j> 0;h++, j--) {
					dif+=(a[j]-a[j-1]);
				}
				min = Math.min(dif, min);
			}
		}
		
		return min;
	}

}
