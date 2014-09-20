package CF;
import java.util.*;
public class CF263_B2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextInt();
		
		char[] ar = sc.next().toCharArray();
		
		long[] nn = new long[26];
		
		for (int i = 0; i < ar.length; i++) {
			nn[ar[i]-'A']++;
		}
		
		Arrays.sort(nn);
		
		long sol = 0;
		for (int i = 25; i >-1; i--) {
			if(nn[i]>=k)
			{
				sol+= (k*k);
				break;
			} else {
				sol+=(nn[i]*nn[i]);
				k-=nn[i];
			}
		}
		
		System.out.println(sol);
		sc.close();
	}

}
