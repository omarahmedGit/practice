package Uva;
import java.util.*;
public class uva10742 {
	static int tar;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		gen_primes();
		int t=1;
		while(tar<1000009)
		{
			tar=sc.nextInt();
			if(tar==0) break;
			// binary search to get the lowwer bound
			int l=0,h=pri.size()-1,m;
			while(h>l)
			{
				m=(l+h)/2;
				if(pri.get(m)>tar)
					h=m-1;
				else if(pri.get(m)<tar)
					l=m+1;
				else
				{
					h=m-1;
					break;
				}
			}
			//2 3 5 7 11 13 17 23
			l=0;
			long ans=0;
			while(l!=h)
			{
				if(pri.get(l)+pri.get(h)<=tar)
				{
					ans+=h-l;
					l++;
				}
				else
					h--;
			}
			System.out.printf("Case %d: %d\n",t++,ans);
		}
	}
	
	static long count(int idx,int sum,int sig)
	{
		if(sum==0&&sig==2)
		{
			return 1;
		}
		if(sig>2||pri.get(idx)>sum||sum<0||idx==pri.size()) return 0;
		return count(idx==0?idx:idx+1,sum-pri.get(idx),idx==0?sig:sig+1)+count(idx+1,sum,sig);
	}
	
	
	static boolean[] primes=new boolean[1000009];
	static ArrayList<Integer> pri=new ArrayList<Integer>();
	static void gen_primes()
	{
		for(long i=2;i<1000009;i++)
		{
			if(!primes[(int)i])
			{
				for(long j=i*i;j<1000009;j+=i)
					primes[(int)j]=true;
				
				pri.add((int)i);
			}
		}
	}

}
