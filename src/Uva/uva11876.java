package Uva;
import java.util.*;
public class uva11876 {
	/*
	 * i used 2 ways of to solve this problem 
	 * first binary search 
	 * second cumulative sum both java TLE and cpp AC  
	 */
	public static void main(String[] args) {
		gen_divisors();
		Scanner sc=new Scanner(System.in);
		int loop=sc.nextInt();
		long c=1;
		while(loop-->0)
		{
			
			int a=sc.nextInt();
			int b=sc.nextInt();
//			int aa=binary_search(a);
//			int bb=lower_bound(b);
			int sec=com[a]==com[a-1]?0:1;
//			System.out.printf("Case %d: %d\n",c++,bb-aa+1);
			System.out.printf("Case %d: %d\n",c++,com[b]-com[a]+sec);
		}
		sc.close();
	}
	
	
	
	
	
	static int binary_search(int x)
	{
		int h=nod.size(),l=0,m;
		while(h!=l)
		{
			m=(h+l)/2;
			if(nod.get(m)<x)
				l=m+1;
			else
				h=m;
		}
		return h;
	}
	static int lower_bound(int x)
	{
		int h=nod.size()-1,l=0,m;
		while(h>l)
		{
			
			m=(h+l)/2;
			if(h==l+1)
				if(nod.get(h)>x) return l;
				else return h;
			if(nod.get(m)>x)
				h=m-1;
			else
				l=m;
			
		}
		return nod.get(h)>x?l:h;
	}
	/*
	 * 1 2 4 7 9 12 18
	 * 0 1 2 3 4 5 6
	 */
	static int[] numberOfDivisors=new int[1000010];
	static ArrayList<Integer> nod=new ArrayList<Integer>();
	static int[] com=new int[1000010];
	static void gen_divisors()
	{
		for(int i=1;i<1000001;i++)
			for(int j=i;j<1000001;j+=i)
				numberOfDivisors[j]++;
		nod.add(1);
		int n;
		for(int i=1;i<1000001;i++)
		{
			n=nod.get(i-1);
			if(n>1000000) break;
			nod.add(n+numberOfDivisors[n]);
		}
		com[0]=0;
		com[1]=1;
		for(int i=2,j=1;i<1000001;i++)
		{
			com[i]+=com[i-1];
			if(j<nod.size()&&nod.get(j)==i)
			{
				com[i]++;
				j++;
			}
		}
	}
}
