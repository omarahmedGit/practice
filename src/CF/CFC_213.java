package CF;
import java.util.*;
public class CFC_213 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 40; i++) {
			System.out.println(i);
		}
		long x = sc.nextLong();
		char[] a = sc.next().toCharArray();
		long[][] b = new long[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				b[i][j] = (a[i]-'0')*(a[j]-'0');
				if(i>0) b[i][j] += b[i-1][j];
				if(j>0) b[i][j] += b[i][j-1];
				if(i>0&&j>0) b[i][j] -=b[i-1][j-1];
				b[j][i] = b[i][j];
			}
		}
		long c = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				for (int j2 = i; j2 < a.length; j2++) {
					for (int k = j2; k < a.length; k++) {
						long sum = b[j2][k];
						if(i>0) sum -=b[i-1][k];
						if(j>0) sum -=b[j2][j-1];
						if(i>0&&j>0) sum +=b[i-1][j-1];
						if(sum==x)
						{
							if(i==j&&j2==k) c++;
							else c+=2;
						}
					}
				}
			}
		}
		System.out.println(c);
		sc.close();
	}

}
