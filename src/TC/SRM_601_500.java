package TC;
import java.util.*;
public class SRM_601_500 {

	public static void main(String[] args) {
		int[] a = {1,3,2};
		
		System.out.println(getNumber(a));
	}
	
	
	
	public static int getNumber(int[] a)
	{
		int[] b = new int[51];
		for (int i = 0; i < a.length; i++) {
			b[a[i]]++;
		}
		int n = 0;
		b[0] = 1;
		for (int i = 1; i < b.length; i++) {
			if(b[i]==0) break;
			n+=(b[i]*b[i-1]);
			b[i] = (b[i]*b[i-1]); 
		}
		
		
		return n;
	}

}
