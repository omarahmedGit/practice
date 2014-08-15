package Uva;

import java.util.*;
import java.io.*;
public class UVa10484 {
	static int sqr = 46350;
	static ArrayList<Integer> pr = new ArrayList<Integer>();
	static boolean[] primes = new boolean[sqr];
	
	static ArrayList<Integer>[] ff = new ArrayList[101];
	static ArrayList<Integer>[] pp = new ArrayList[101];
	
	
	
	static void precal()
	{
		for (int i = 0; i < 101; i++) {
			ff[i] = new ArrayList<Integer>();
			pp[i] = new ArrayList<Integer>();
		}
		
		for (int i = 2; i < 101; i++) {
			fil(i);
		}
	}
	
	
	static void fil(int i) {
		for (int j = 0; j < pr.size(); j++) {
			int x = pr.get(j);
			if(x>i)
				break;
			int count = 0;
			long xx = x;
			while(true)
			{
				long sum = i/xx;
				if(sum==0)
					break;
				count+=sum;
				xx*=((long)x);
			}
			ff[i].add(x);
			pp[i].add(count);
		}
	}


	static long factorize(int n,int fy)
	{
		ArrayList<Integer> fac = new ArrayList<Integer>();
		ArrayList<Integer> pow = new ArrayList<Integer>();
		
		int nn = n;
		for (int x : pr) {
			if(!(nn>1)) break;
			if(nn%x==0)
			{
				fac.add(x);
				int count = 0;
				while(nn%x==0)
				{
					nn/=x;
					++count;
				}
				pow.add(count);
			}
		}
		if(nn>1)
		{
			fac.add(nn);
			pow.add(1);
		}
		long count = 1 ;
		int[] ret = new int[ff[fy].size()];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = pp[fy].get(i);
		}
		
		for (int i = 0,j=0; i < fac.size();) {
			if(j==ret.length)
				return 0;
			if(fac.get(i)==ff[fy].get(j))
			{
				if(pow.get(i)>ret[j])
				{
					return 0;
				}
				ret[j] -= pow.get(i);
				i++; j++;
			}else if(fac.get(i)>ff[fy].get(j)) {
				j++;
				continue;
			} else {
				return 0;
			}
		}
		for (int i = 0; i < ret.length; i++) {
			count*=(1+ret[i]);
		}
		return count;
	}
	static void pri() {
		Arrays.fill(primes, true);
		primes[0] = primes[1] = false;

		for (int i = 2; i < sqr; i++) {
			if (primes[i]) {
				pr.add(i);
				for (int j = 2 * i; j < sqr; j+=i) {
					primes[j] = false;
				}
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		pri();
		precal();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =new PrintWriter(new PrintWriter(System.out));
		StringTokenizer st ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Math.abs(Integer.parseInt(st.nextToken()));
			if(a==0&b==0)
				break;
			if(a==0||a==1)
			{
				if(b==1)
					pw.println(1);
				else
					pw.println(0);
			}else
				pw.println(factorize(b,a));	
		}
		pw.close();
		br.close();
		factorize(3, 9);
	}

}
