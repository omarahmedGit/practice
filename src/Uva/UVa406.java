package Uva;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UVa406 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		boolean[] primes = new boolean[1005];
		Arrays.fill(primes, true);
		
		primes[0] = false;
		
		for (int i = 2; i*i < primes.length; i++) {
			if(primes[i]) {
				for (int j = i*i; j < primes.length; j+=i) {
					primes[j] = false;
				}
			}
		}
		
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0;i<primes.length;i++) if(primes[i]) arr.add(i);
		
		int[] comu = new int[1005];
		
		comu[0] = 0;
		
		for(int i=1;i<comu.length;i++) {
			comu[i] = comu[i-1];
			if(primes[i]) comu[i]++;
		}
		
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int c = sc.nextInt();
			
			int pr ;
			if(comu[n]%2==1) {
				pr =  c*2 - 1;
			} else {
				pr = c*2;
			}
			
			if(pr>comu[n]) pr = comu[n];
			
			
			int start = (comu[n] - pr) / 2;
			pw.printf("%d %d:",n,c);
			for(int i=start,count=0;count<pr;i++,count++) {
				pw.printf(" %d",arr.get(i));
			}
			pw.print("\n\n");
		}
		
		
		
		
		pw.close();
		sc.close();
	}
}
