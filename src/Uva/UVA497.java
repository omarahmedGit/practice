package Uva;
import java.util.*;

public class UVA497 {
	static ArrayList<Integer> ar;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		int t = Integer.parseInt(in);
		sc.nextLine();
		for (int i = 0; i < t; i++) {
			if (i != 0)
				System.out.println();
			ar = new ArrayList<Integer>();
			ar.add(-99999999);
			while (sc.hasNext()) {
				in = sc.nextLine().trim();
				if (in.length() == 0)
					break;
				ar.add(Integer.parseInt(in));
			}
			dp = new int[ar.size()][ar.size()];
			for (int j = 0; j < ar.size(); j++) {
				Arrays.fill(dp[j], -1);
			}
			System.out.printf("Max hits: %d\n", LIS(1, 0));
			trace(1, 0);
		}

		sc.close();
	}

	static void trace(int i, int j) {
		if (i == ar.size() || j == ar.size())
			return;

		int choice1 = LIS(i + 1, j);
		int choice2 = 0;

		if (ar.get(i) >= ar.get(j))
			choice2 = 1 + LIS(i + 1, i);
		
		if(choice1==0&&choice2==0) return ;
		
		if (choice1 < choice2) {
			System.out.println(ar.get(i));
			trace(i + 1, i);
			return;
		}
		trace(i + 1, j);

	}

	static int LIS(int i, int j) {
		if (i == ar.size() || j == ar.size())
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		int choice1 = LIS(i + 1, j);
		int choice2 = 0;

		if (ar.get(i) > ar.get(j))
			choice2 = 1 + LIS(i + 1, i);

		return dp[i][j] = Math.max(choice1, choice2);
	}

}
