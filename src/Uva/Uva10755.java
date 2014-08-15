package Uva;
import java.util.*;
public class Uva10755 {
	static long[][][] gar= new long[32][32][32];;
	static int a,b,c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nn = n;
		while(n>0)
		{
			if(n!=nn)
				System.out.println();
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					for (int j2 = 0; j2 < c; j2++) {
						gar[i][j][j2] = sc.nextLong();
					}
				}
			}
			System.out.println(garb());
			n--;
		}
		
		sc.close();
	}
	
	
	static long garb()
	{
		ArrayList<Long> kan = new ArrayList<Long>();
		long[][] step = new long[a][b];
		for (int i = 0; i < c; i++) {
			
			for (int j = 0; j < a; j++) {
				for (int j2 = 0; j2 < b; j2++) {
					step[j][j2] = gar[j][j2][i]; 
					if(j>0)  step[j][j2] += step[j-1][j2];
					if(j2>0) step[j][j2] += step[j][j2-1];
					if(j>0&&j2>0) step[j][j2] -= step[j-1][j2-1];
				}
			}
			
			long max = Long.MIN_VALUE;
			for (int j = 0; j < a; j++) {
				for (int j2 = 0; j2 < b; j2++) {
					for (int k = j; k < a; k++) {
						for (int k2 = j2; k2 < b; k2++) {
							long subrec = step[k][k2];
							if(j>0) subrec -= step[j-1][k2];
							if(j2>0) subrec -= step[k][j2-1];
							if(j>0&j2>0) subrec += step[j-1][j2-1];
							max = Math.max(max, subrec);
						}
					}
				}
			}
			kan.add(max);
		}
		
		long sum = 0,ans = 0;
		
		for (int i = 0; i < c; i++) {
			sum +=kan.get(i);
			ans = Math.max(ans, sum);
			if(sum<0) sum = 0;
		}
		if(ans==0)
		{
			ans = Long.MIN_VALUE;
			for (int i = 0; i < c; i++) {
				ans = Math.max(ans, kan.get(i));
			}
		}
		return ans;
	}

}
