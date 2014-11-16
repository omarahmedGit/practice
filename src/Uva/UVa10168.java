package Uva;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UVa10168 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

		// 10000000
		int N = 10000005;
		boolean[] check = new boolean[N];
		Arrays.fill(check, true);

		check[0] = check[1] = false;

		for (int i = 2; i * i < check.length; i++) {
			if (check[i]) {
				for (int j = i * i; j < check.length; j += i) {
					check[j] = false;
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		HashSet<Integer> hash = new HashSet<Integer>();
		
		for (int i = 0; i < N; i++)
			if (check[i]) {
				primes.add(i);
				hash.add(i);
			}
		
		int n,p;
		
		while(sc.hasNext()) {
			n = sc.nextInt();
			if(n==0) break;
			if(n<8) {
				pw.println("Impossible.");
				continue;
			}
			
			if(n%2==0) {
				n-=4;
				pw.print("2 2 ");
			} else {
				n-=5;
				pw.print("2 3 ");
			}
			
			
			for (int i = 0; i < primes.size(); i++) {
				p = primes.get(i);
				if(hash.contains(n-p)&&p<=n-p) {
					pw.printf("%d %d\n",p,n-p);
					break;
				}
			}
			
		}
		pw.close();
		sc.close();
	}

}
