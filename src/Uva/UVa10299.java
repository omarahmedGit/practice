package Uva;

import java.util.*;
import java.io.*;

public class UVa10299 {
	static boolean[] f = new boolean[32000];
	static ArrayList<Integer> ar, fa,primes;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		primes = new ArrayList<Integer>();
		prime();
		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0)
				break;
			if(n==1){
				
				pw.println(0);
				continue ;
			}
			ar = new ArrayList<Integer>();
			fa = new ArrayList<Integer>();

			factoriez(n);

			pw.println(gen());
		}
		pw.close();
		br.close();
	}

	static long gen() {
		long val = 1;

		for (int i = 0; i < ar.size(); i++) {
			int p = ar.get(i);
			int po = fa.get(i);
			long ppo = pow(p, po);
			long t = ppo - (ppo / p);

			val *= t;
		}
		return val;
	}

	static long pow(int a, int b) {
		long v = 1;
		for (int i = 0; i < b; i++)
			v *= a;
		return v;
	}

	static void factoriez(int n) {
		int cout = 0;
		for (int idx :primes) {
			if(!(n>1))
				break;
			cout = 0;
			if (n % idx == 0) {
				ar.add(idx);
				while (n % idx == 0) {
					n /= idx;
					cout++;
				}
				fa.add(cout);
			}

		}
		if (n != 1) {
			ar.add(n);
			fa.add(1);
		}
	}

	static void prime() {
		f[0] = true;
		f[1] = true;
		for (int i = 2; i < 32000; i++) {
			if (!f[i]) {
				primes.add(i);
				for (int j = 2 * i; j < 32000; j += i) {
					f[j] = true;
				}
			}
		}
	}
}
