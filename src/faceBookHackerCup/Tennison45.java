package faceBookHackerCup;
import java.util.Scanner;

public class Tennison45 {
	static double s1, s2, s3, s4;
	static int k;
	static double s, r;
	static double[][][] dp = new double[151][151][4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int ii = 0; ii < t; ii++) {
			for (int i = 0; i < 151; i++) {
				for (int j = 0; j < 151; j++) {
					dp[i][j][0] = -1.0;
					dp[i][j][1] = -1.0;
					dp[i][j][2] = -1.0;
					dp[i][j][3] = -1.0;
				}
			}
			k = sc.nextInt();
			s = sc.nextDouble();
			r = sc.nextDouble();
			double ps = sc.nextDouble();
			s1 = sc.nextDouble();
			s2 = sc.nextDouble();
			s3 = sc.nextDouble();
			s4 = sc.nextDouble();
			System.out.printf("Case #%d: %.6f\n", ii + 1, KISS(0, 0, 0, ps));
		}
		sc.close();
	}

	public static double KISS(int lose, int win, int st, double ps) {
		if (lose == k)
			return 0;
		if (win == k)
			return 1;
		if (dp[win][lose][st] > -0.5)
			return dp[win][lose][st];
		double w = (s * ps) + (r * (1 - ps));
		double l = 1 - w;
		double psw = ps + s1;
		double psl = ps - s3;
		if (psw > 1)
			psw = 1;
		if (psl < 0)
			psl = 0;
		double ans = w
				* (s2 * KISS(lose, win + 1, 0, psw) + (1 - s2)
						* KISS(lose, win + 1, 1, ps))
				+ l
				* ((s4 * KISS(lose + 1, win, 2, psl)) + (1 - s4)
						* KISS(lose + 1, win, 3, ps));
		return dp[win][lose][st] = ans;
	}

}
