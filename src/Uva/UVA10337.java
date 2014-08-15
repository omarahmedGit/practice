package Uva;
import java.util.*;
public class UVA10337 {
	static int[][] w = new int[10][1000];
	static int k;
	static int[][] dp = new int[10][1000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int x = sc.nextInt();
			k = x/100;
			for (int j = 0; j < 10; j++) {
				for (int j2 = 0; j2 < k; j2++) {
					dp[j][j2]=-1;
				}
			}
			
			for (int j = 9; j >= 0; j--) {
				for (int j2 = 0; j2 < k; j2++) {
					w[j][j2] = sc.nextInt();
				}
			}
			
			System.out.println(flight(0,0));
			System.out.println();
		}
		
		sc.close();
	}
	
	
	
	static int flight(int x,int al)
	{
		if(x==k&al==0) return 0;
		
		if(x==k||al>9||al<0) return 1000000000;
		
		if(x!=0&al==0) return 1000000000;
		
		if(dp[al][x]!=-1) return dp[al][x];
		
		int wind = -w[al][x];
		
		
		int a = flight(x+1,al) + 30;
		int b = flight(x+1,al+1) + 60;
		int c = flight(x+1,al-1) + 20;
		
		
		return dp[al][x] = wind + min(a,b,c);
	}
	static int min(int a,int b ,int c)
	{
		return Math.min(a, Math.min(b, c));
	}

}
