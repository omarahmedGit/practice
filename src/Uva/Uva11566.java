package Uva;
import java.util.*;
public class Uva11566 {
	static int a,b,c,d;
	static int[] pr;
	static int[] fal;
	static int test = 0;
	static int[][][] dp = new int[101][1105][23];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			a = sc.nextInt(); // number of friends
			b = sc.nextInt(); // number of dollers per person
			c = sc.nextInt(); // tea charge
			d = sc.nextInt(); // number of dim sums
			if(a==0&b==0&c==0&d==0) break;
			a++;
			pr = new int[d];
			fal = new int[d];
			for (int i = 0; i < d; i++) {
				pr[i] = sc.nextInt();
				int sum = 0;
				for (int j = 0; j < a; j++) sum += sc.nextInt();
				fal[i] = sum;
			}
			fill();
			double sol = dimsum(0, a*c, 0);
			sol/=a;
			System.out.printf("%.2f\n",sol);
			
		}
		
		sc.close();
	}
	static void fill()
	{
		for (int i = 0; i <= d; i++) {
			for (int j = 0; j <= a*b; j++) {
				for (int j2 = 0; j2 <= 2*a; j2++) {
					dp[i][j][j2] =-1;
				}
			}
		}
	}
	static int neg = -1000000000;
	static int dimsum(int idx,int mon,int dish)
	{
		if(mon>a*b | dish > 2*a)
			return neg;
		
		if(idx==d)
		{
			double y = mon;
			y = Math.ceil(y + (10*y)/100);
			int sol = (int) y;
			if(sol>a*b) return neg;
			return 0;
		}
		if(dp[idx][mon][dish]!=-1) return dp[idx][mon][dish];
		int ch1 = dimsum(idx+1, mon , dish);
		int ch2 = fal[idx] + dimsum(idx+1, mon+pr[idx], dish+1);
		int ch3 = 2*fal[idx] + dimsum(idx+1, mon+(2*pr[idx]),dish+2);
		
		return dp[idx][mon][dish]= Math.max(ch1, Math.max(ch2, ch3));
	}
	
}
