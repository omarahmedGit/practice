package Uva;
import java.util.*;
import java.io.*;
public class UVa10139 {

	static int sqr = 46400;

	static boolean[] primes = new boolean[sqr];
	static ArrayList<Integer> pri = new ArrayList<Integer>();
	public static void main(String[] args) throws IOException {
		make_primes();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		while(true)
		{
			String r ;
			if((r = br.readLine())==null||r.length()==0) break;
			st = new StringTokenizer(r);
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int c = b;
			if(c==0) c = 1;
			if(a!=0&factorial(a, c))
			{
				pw.printf("%d divides %d!\n",a,b);
			} else {
				pw.printf("%d does not divide %d!\n",a,b);
			}
		}
		
		
		pw.close();
		br.close();
	}

	static boolean factorial(int a,int b)
	{
		ArrayList<Integer> factors = new ArrayList<Integer>();
		ArrayList<Integer> powers  = new ArrayList<Integer>();
		
		int n = a;
		for(int x:pri)
		{
			if(n<=1) break;
			
			if(n%x==0)
			{
				int count = 0;
				while(n%x==0)
				{
					n/=x;
					count++;
				}
				factors.add(x);
				powers.add(count);
			}
		}
		if(n>1)
		{
			factors.add(n);
			powers.add(1);
		}
		int idx = 0;
		boolean check = true ;
		for(int x:factors)
		{
			if(x>b) {
				check = false;
				break;
			} else {
				int pow = powers.get(idx);
				int ct = 0,xx= x;
				
				while(true)
				{
					if(b/xx==0||xx<2) break;
					ct+=((b/xx));
					xx*=x;
				}
				
				if(ct<pow)
				{
					check = false;
					break;
				}
			}
			idx++;
		}
		return check;
	}
	
	
	static void make_primes() {
		primes[0] = primes[1] = true;
		for (int i = 2; i < sqr; i++) {
			if (!primes[i]) {
				pri.add(i);
				for (int j = 2 * i; j < sqr; j += i) {
					primes[j] = true;
				}
			}
		}
	}

}
