package CF;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CFE_257 {
	static boolean[] prime = new boolean[100010];
	static boolean[] taken = new boolean[100010];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() ;
		theive();
		ArrayList<Integer> rem = new ArrayList<Integer>();
		ArrayList<Integer> gro = new ArrayList<Integer>();
		ArrayList<Pair> sol = new ArrayList<Pair>();
		for (int i = 3; i <= n/2; i++) {
			gro.clear();
			
			if(prime[i])
			{
				for (int j = i; j <= n; j+=i) {
					if(!taken[j])
					{
						taken[j] = true ;
						gro.add(j);
					}
				}
				if(gro.size()%2==1)
				{
					rem.add(i*2);
					gro.remove(1);
				}
				for (int j = 0; j < gro.size()-1; j+=2) {
					sol.add(new Pair(gro.get(j),gro.get(j+1)));
				}
			}
		}
		
		for (int j = 2; j < n; j+=2) {
			if(!taken[j])
				rem.add(j);
		}
		int start = 0;
		if(rem.size()%2==1)
			start = 1;
		
		for (int j = start; j < rem.size()-1; j+=2) {
			sol.add(new Pair(rem.get(j), rem.get(j+1)));
		}
		System.out.println(sol.size());
		for (Pair pair : sol) {
			System.out.println(pair.a+" "+pair.b);
		}
		
		sc.close();
	}
	
	static class Pair {
		int a,b;
		Pair(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
	}
	
	
	static void theive()
	{
		Arrays.fill(prime, true);
		prime[0] = prime [1] = false ;
		
		
		for (int i = 2; i*i < 100001; i++)
			if(prime[i])
				for (int j = 2*i; j < 100001; j+=i)
					prime[j] = false ;
	}

}
