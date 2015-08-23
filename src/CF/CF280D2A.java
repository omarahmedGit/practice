package CF;
import java.util.*;
public class CF280D2A {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long[] ar = new long[10005];
		long[] arr = new long[10005]; 
		ar[1] = 1;
		arr[1]= 1;
		for (int i = 2; i < ar.length; i++) {
			arr[i] = arr[i-1]+i;
			ar[i] = ar[i-1]+arr[i];
		}
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i]>n) {
				ans = i-1;
				break;
			}
		}
		System.out.println(ans);
		sc.close();
		
	}

}
