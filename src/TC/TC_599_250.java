package TC;
import java.util.Arrays;


public class TC_599_250 {

	public static void main(String[] args) {
		int[] a = {200, 50, 200, 50, 200, 50, 200, 50};
		System.out.println(maxMikan(a, 4800));
	}
	
	
	public static int maxMikan(int[] a,int b)
	{
		int rem = 5000-b;
		Arrays.sort(a);
		int sum = 0;
		int n=0;
		
		for (int i = 0; i < a.length; i++) {
			if(sum+a[i]>rem) break;
			n++;
			sum+=a[i];
		}
		return n;
	}
	

}
