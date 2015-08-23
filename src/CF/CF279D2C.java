package CF;

import java.util.*;
import java.io.*;

public class CF279D2C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		char[] inp = sc.nextLine().toCharArray();
		int[] str = new int[inp.length];
		for (int i = 0; i < str.length; i++) {
			str[i] = inp[i] - '0';
		}

		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();
		int[] pow = new int[1000002];
		int[] rema = new int[str.length];
		int[] remb = new int[str.length];

		pow[0] = 1;
		for (int i = 1; i <= str.length; i++) {
			pow[i] = (pow[i - 1] * 10) % b;
		}

		rema[0] = str[0] % a;
		for (int i = 1; i < rema.length; i++) {
			rema[i] = (((rema[i - 1] * 10) % a) + (str[i] % a)) % a;
		}

		remb[str.length - 1] = (str[str.length - 1]) % b;
		for (int i = str.length - 2; i > -1; i--) {
			int p = pow[str.length - i - 1];
			remb[i] = ((str[i] * p) + remb[i + 1]) % b;
		}

		int pos = -1;

		for (int i = 0; i < str.length - 1; i++) {
			if (rema[i] == 0 && remb[i + 1] == 0 && str[i + 1] != 0) {
				pos = i;
				break;
			}
		}

		if (pos == -1) {
			pw.println("NO");
		} else {
			pw.println("YES");
			for (int i = 0; i <= pos; i++) {
				pw.print(str[i]);
			}
			pw.println();
			for (int i = pos + 1; i < str.length; i++) {
				pw.print(str[i]);
			}
			pw.println();
		}
		pw.close();
	}

}
