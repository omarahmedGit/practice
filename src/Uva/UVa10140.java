package Uva;

import java.util.*;

public class UVa10140 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int SQR = 47000; // a little greater than the square root of Integer.MAX_VALUE 
		
		ArrayList<Integer> primes = new ArrayList<Integer>();

		// Ordinary Sieve
		// generate the prime factors to the sqrt of Integer.MAX_VALUE
		boolean[] pcheck = new boolean[SQR];
		Arrays.fill(pcheck, true);
		pcheck[0] = pcheck[1] = false;
		for (int i = 2; i * i < SQR; i++) {
			if (pcheck[i]) {
				for (int j = i * i; j < SQR; j+=i) {
					pcheck[j] = false;
				}
			}
		}
		// adding the primes in the primes array
		for(int i=0;i<SQR;i++) if(pcheck[i]) primes.add(i);
		
		int l,u,p;
		while (sc.hasNext()) {
			l = sc.nextInt();
			u = sc.nextInt();
			
			if(l<2) l = 2;
			
			if(u<l) u = l;
			
			// array for the interval to check the primes in the interval 
			boolean[] check = new boolean[u-l+1];
			
			Arrays.fill(check, true);
			
			for (int j = 0; j < primes.size(); j++) {
				p = primes.get(j);
				// get the first index that is multiple of prime p inside the interval
				int start = (int)Math.ceil((l/(double)p));

				// check if p >= l ( the prime is inside the interval )
				if(start==1) start++;
				
				for (int i = start; i*p-l < check.length; i++) {
					check[i*p-l] = false;
				}
			}
			
			
			int a=-1,b=-1,max=0,min=Integer.MAX_VALUE,mx_1=0,mx_2=0,mn_1=0,mn_2=0;
			
			for (int i = 0; i < check.length; i++) {
				if(check[i]) {
					a = i;
					if(b!=-1) {
						if(a-b>max) {
							max = a-b;
							mx_1 = b+l;
							mx_2 = a+l;
						}
						
						if(a-b < min) {
							min = a-b;
							mn_1 = b+l;
							mn_2 = a+l;
						}
					}
					b = a;
				}
			}
			
			if(max==0) {
				System.out.println("There are no adjacent primes.");
			} else {
				System.out.printf("%d,%d are closest, %d,%d are most distant.\n",mn_1,mn_2,mx_1,mx_2);
			}
			
		}

		sc.close();
	}

}
