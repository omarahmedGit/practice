package Uva;
import java.util.*;
import java.io.*;

public class UVa10948 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int N = 1000000;
		
		boolean[] check = new boolean[N];
		Arrays.fill(check, true);
		check[0] = check[1] = false;
		for (int i = 2; i*i < check.length; i++) {
			if(check[i]) {
				for (int j = i*i; j < check.length; j+=i) {
					check[j] = false;
				}
			}
		}
		ArrayList<Integer> primes = new ArrayList<Integer>();
		HashSet<Integer> hash = new HashSet<Integer>();
		for (int i = 0; i < check.length; i++) {
			if(check[i]) {
				hash.add(i);
				primes.add(i);
			}
		}
		
		int n,p;
		boolean ch ;
		while(sc.hasNext()) {
			n = sc.nextInt();
			
			if(n==0) break;
			
			ch = false;
			
			pw.printf("%d:\n",n);
			
			for (int i = 0; i < primes.size(); i++) {
				p = primes.get(i);
				if(p>n)  {
					break;
				}
				
				if(hash.contains(n-p)&&p<=n-p) {
					pw.printf("%d+%d\n",p,n-p);
					ch = true;
					break;
				}
			}
			if(!ch) pw.println("NO WAY!");
		}
		
		pw.close();
		sc.close();
	}

}
