package CF;
import java.util.*;

public class CF264_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n+1];
		a[0]=0;
		for (int i = 1; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		
		int en = 0;
		int dollers = 0;
		int dif;
		for (int i = 1; i < a.length; i++) {
			dif = Math.abs(a[i]-a[i-1]);
			if(a[i-1]<a[i]) {
				en-=dif;
				if(en<0)
				{
					dollers+=Math.abs(en);
					en = 0;
				}
			} else {
				en+=dif;
			}
		}
		
		System.out.println(dollers);
		
		sc.close();
	}

}
