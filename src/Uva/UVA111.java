package Uva;
import java.util.*;

public class UVA111 {
	static int[] arr, student;
	static int[][] dp = new int[22][22];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			int a =sc.nextInt();
			arr[a-1]=i+1;
		}
		while(sc.hasNext()) {
			for (int j = 0; j <22; j++) {
				Arrays.fill(dp[j], -1);
			}
			student = new int[n];
			
			for (int j = 0; j < n; j++) {
				int a =sc.nextInt();
				student[a-1] = j+1;
			}

			System.out.println(LCS(0, 0));
		}

		sc.close();
	}

	static int LCS(int i, int j) {
		if (i == student.length || j == arr.length)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		if (student[i] == arr[j])
			return dp[i][j] = 1 + LCS(i + 1, j + 1);

		int choice1 = LCS(i, j + 1);
		int choice2 = LCS(i + 1, j);

		return dp[i][j] = Math.max(choice1, choice2);
	}

}
