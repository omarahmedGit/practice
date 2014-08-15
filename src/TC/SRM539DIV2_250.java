package TC;
/*
 * http://community.topcoder.com/stat?c=problem_statement&pm=12780
 */
public class SRM539DIV2_250 {

	// "............"
	public static int calc(String s) {
		char[] in = s.toCharArray();
		int counter = 0;
		for (char x : in)
			if (x == 'c')
				counter++;
		if (counter % 2 == 1)
			return 0;
		if (counter == 0)
			return in.length - 1;
		int c2 = 0;
		int s3 = 0;
		for (int i = 0; i < in.length; i++) {
			if (in[i] == 'c')
				c2++;
			if (c2 == counter / 2) {
				for (int j = i + 1; j < in.length; j++) {
					if (in[j] == 'c')
						break;
					s3++;
				}
				return s3 + 1;
			}
		}
		return s3;
	}
}
