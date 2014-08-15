package Uva;
import java.util.*;

public class UVA10066 {
	static int s1, s2;
	static int[][] dp = new int[105][105];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int c =1;
		while (true) {
			s1 = sc.nextInt();
			s2 = sc.nextInt();
			
			for (int i = 0; i <= s1; i++) {
				for (int j = 0; j <= s2; j++) {
					dp[i][j] = -1;
				}
			}
			
			if (s1 == 0 && s2 == 0)
				break;
			for (int i = 0; i < s1; i++) {
				a[i] = sc.nextInt();
			}
			for (int i = 0; i < s2; i++) {
				b[i] = sc.nextInt();
			}
			System.out.printf("Twin Towers #%d\n",c++);
			System.out.printf("Number of Tiles : %d\n",tower(0,0));
			System.out.println();
		}
		sc.close();
	}

	static int[] a = new int[105], b = new int[105];

	static int tower(int i, int j) {
		if (i == s1 || j == s2)
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		if (a[i] == b[j])
			return dp[i][j] =  1 + tower(i + 1, j + 1);

		int choice1 = tower(i + 1, j);
		int choice2 = tower(i, j + 1);

		return dp[i][j] = Math.max(choice1, choice2);
	}

}
