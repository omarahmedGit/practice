package Uva;
import java.util.*;
public class UVA10130 {
	static int k;
	static int[] wg= new int[1005];
	static int[] val= new int[1005];
	static int[][] dp = new int[1000][105];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			k = sc.nextInt();
			for (int j = 0; j < 1000; j++) {
				for (int j2 = 0; j2 < 105; j2++) {
					dp[j][j2] = -1;
				}
			}
			for (int j = 0; j < k; j++) {
				val[j] = sc.nextInt();
				wg[j] = sc.nextInt();
			}
			int fa = sc.nextInt();
			int sum =0;
			int[] fam = new int[fa];
			for (int j = 0; j < fa; j++) {
				fam[j] = sc.nextInt();
			}
			Arrays.sort(fam);
			for (int j = fa-1; j>-1; j--) {
				sum+=supersale(0,fam[j]);
			}
			System.out.println(sum);
		}
		sc.close();
	}
	
	static int supersale(int i ,int rem)
	{
		if(i==k) return 0;
		
		if(dp[i][rem]!=-1) return dp[i][rem];
		
		int choise1 = supersale(i+1,rem);
		int choise2 = 0;
		
		if(wg[i]<=rem)
			choise2 = val[i]+supersale(i+1,rem-wg[i]);
		
		return dp[i][rem] = Math.max(choise1, choise2);
	}

}
