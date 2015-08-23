package CF;
import java.util.*;
public class CF281D2C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextLong();
		}
		
		int m = sc.nextInt();
		long[] b = new long[m];
		
		for (int i = 0; i < b.length; i++) {
			b[i] = sc.nextLong();
		}
		sc.close();
		
		
		Arrays.sort(a);
		Arrays.sort(b);
		
		long max = (n*3)-(m*3);
		long maxa = n*3;
		long maxb = m*3;
		
		for (int i = 0,j=0; i <= a.length && j<=b.length;) {
			long suma = ((n-i)*3)+((i)*2);
			long sumb = ((m-j)*3)+((j)*2);
			
			
			if(max<suma-sumb) {
				max = suma-sumb;
				maxa = suma;
				maxb = sumb;
			}
			

			if(i==a.length&&j==b.length) 
				break;
			if(i==a.length) {
				j++;
				continue;
			}
			if(j==b.length) {
				i++;
				continue;
			}
			
			
			if(a[i]<b[j]) {
				do{i++;}while(i<a.length&&(i==0||(a[i]==a[i-1])));
			} else if (a[i]>b[j]) {
				do{j++;}while(j<b.length&&(j==0||(b[j]==b[j-1])));
			} else {
				do{i++;}while(i<a.length&&(i==0||(a[i]==a[i-1])));
				do{j++;}while(j<b.length&&(j==0||(b[j]==b[j-1])));
			}
		}
		
		
		System.out.println(maxa+":"+maxb);
		
		
	}

}