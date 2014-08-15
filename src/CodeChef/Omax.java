package CodeChef;
import java.util.*;

/*
 * 
 * http://www.codechef.com/problems/OMAX
 * Didn't solved yet - not understanding it well
 * 
 */
public class Omax {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		long[][] col, row;
		while (sc.hasNext()) {
			m = sc.nextInt();
			n = sc.nextInt();
			if (m == 0 && n == 0)
				break;
			long[][] max = new long[m][n];
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					max[i][j] = sc.nextLong();

			row = new long[m][n];
			col = new long[m][n];
			for (int i = 0; i < m; i++)
				for (int j = 1; j < n; j++)
					row[i][j] = row[i][j - 1] + max[i][j];

			for (int i = 0; i < n; i++)
				for (int j = 1; j < m; j++)
					col[j][i] = col[j - 1][i] + max[j][i];

			long omax = -1000000000;
			for (int i = 0; i + 2 < m; i++)
				for (int j = 0; j + 2 < n; j++) {

					for (int j2 = i + 2; j2 < m; j2++) {
						for (int k = j + 2; k < n; k++) {
							long sum = row[i][k] - row[i][j] + max[i][j]
									+ row[j2][k] - row[j2][j] + max[j2][j];
							sum = sum + col[j2][j] - col[i][j] - max[j2][j]
									+ col[j2][k] - col[i][k] - max[i][k];
							omax = Math.max(omax, sum);
						}
					}
				}
			System.out.println(omax);
			sc.close();

		}
	}

}
