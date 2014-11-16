package Uva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UVa686 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashSet<Integer> hash = new HashSet<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();

		boolean[] check = new boolean[33000];
		Arrays.fill(check, true);
		check[0] = check[1] = false;
		for (int i = 2; i*i < 33000; i++) {
			if (check[i]) {
				for (int j = i * i; j < 33000; j += i) {
					check[j] = false;
				}
			}
		}
		for (int i = 0; i < 33000; i++) {
			if (check[i]) {
				primes.add(i);
				hash.add(i);
			}
		}
		
		int count, n,size = primes.size(),p;
		while (sc.hasNext()) {
			n = sc.nextInt();
			if(n==0) break;
			count = 0;
			for(int i=0;i<size;i++) {
				p = primes.get(i);
				if(p>n) break;
				if(hash.contains(n-p)&&p<=n-p) {
					count++;
				}
			}
			System.out.println(count);
		}
		
		sc.close();
	}

}
