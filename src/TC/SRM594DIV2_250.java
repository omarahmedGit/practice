package TC;
/*
 * http://community.topcoder.com/stat?c=problem_statement&pm=12811
 */
public class SRM594DIV2_250 {

	public static String ableTo(int n, int m) {
		// O(n*m) solution 
		boolean[][] fox = new boolean[n][m];
		int inext = 0, jnext = 0;
		int counter = 0;
		while (true) {
			if (fox[inext][jnext]) {
				break;
			}
			counter++;
			fox[inext][jnext] = true;
			inext = (inext + 1) % n;
			jnext = (jnext + 1) % m;
		}
		if (counter == n * m)
			return "Possible";
		
		return "Impossible";
	}

}
