package Uva;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class UVa10940 {

	static boolean isPrime(long x) {
		for (long i = 2; i * i <= x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}

	static long pow(long x, long a) {
		long temp = 1;
		for (int i = 0; i < a; i++) {
			temp *= x;
		}
		return temp;
	}

	static long getPerfect(long x) {
		return pow((long) 2, x - 1) * (pow((long) 2, x) - (long) 1);
	}

	public static void main(String[] args) {
//		for (int i = 0; i <= 31; i++) {
//			System.out.print(isPrime(pow(2, i) - 1) + ",");
//		}
//		System.out.println();
//		System.out.println("finii");

		boolean[] chk = { true, true, true, true, false, true, false, true,
				false, false, false, false, false, true, false, false, false,
				true, false, true, false, false, false, false, false, false,
				false, false, false, false, false, true };

		boolean[] primes = new boolean[32];
		Arrays.fill(primes, true);
		primes[0] = primes[1] = true;
		for (int i = 2; i * 1 < primes.length; i++) {
			if (primes[i]) {
				for (int j = i * i; j < primes.length; j += i) {
					primes[j] = false;
				}
			}
		}

		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			if (chk[n]) {
				pw.printf("Perfect: %d!\n", getPerfect(n));
			} else {
				if (primes[n]) {
					pw.println("Given number is prime. But, NO perfect number is available.");
				} else {
					pw.println("Given number is NOT prime! NO perfect number is available.");
				}
			}
		}
		pw.close();
		sc.close();
	}

}
