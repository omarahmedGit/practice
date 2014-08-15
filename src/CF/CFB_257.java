package CF;

import java.util.*;
import java.io.*;

public class CFB_257 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long f_2 = Long.parseLong(st.nextToken());
		long f_1 = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		long[] res = new long[6];
		long m = 1000000007;
		
		res[0] = f_2;
		res[1] = f_1;
		res[2] = f_1 - f_2;
		res[3] = -f_2;
		res[4] = -f_1;
		res[5] = f_2 - f_1;

		pw.println(((res[(n - 1) % 6]) % m + m) % m);

		pw.close();
		br.close();
	}

}
