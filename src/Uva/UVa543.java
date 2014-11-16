package Uva;

import java.io.*;
import java.util.*;

public class UVa543 {

	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static HashSet<Integer> hash = new HashSet<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		// generate Primes between 1 and 1000000 ( number of primes in this
		// range is 78498 )
		generatePrimes();

		int size = primes.size(); // 78498

		while (true) {

			int in = Integer.parseInt(br.readLine());

			if (in == 0)
				break;
			
			boolean check = true;
			for (int i = 0; i < size; i++) {
				// iterate through primes list to get the minimum a
				int a = primes.get(i);
				if (a > in) {
					pw.println("Goldbach's conjecture is wrong.");
					check = false;
					break;
				}

				if (hash.contains(in - a)) {
					pw.printf("%d = %d + %d\n", in, a, in - a);
					check = false;
					break;
				}
			}
			// if the number is greater than the greatest prime in the range and
			// violate the rule.
			if (check)
				pw.println("Goldbach's conjecture is wrong.");

		}
		pw.close();

		br.close();
	}

	static void generatePrimes() {

		int maxN = 1000000;

		boolean[] isPrime = new boolean[maxN];

		for (int i = 0; i < maxN; i++)
			isPrime[i] = true;

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i * i < maxN; i++) {
			if (isPrime[i]) {
				for (int j = 2 * i; j < maxN; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 0; i < maxN; i++) {
			if (isPrime[i]) {
				primes.add(i);
				hash.add(i);
			}
		}

	}

}
