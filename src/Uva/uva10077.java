package Uva;
import java.util.*;
public class uva10077 {
	/*
	 * a very nice and cool idea using binary search (Level 3)
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a,b;
		while(true)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			if(a==1&b==1) break;
			long ha=1,hb=0;
			long la=0,lb=1;
			long ma,mb,x;
			String sol="";
			while(true)
			{
				ma=ha+la;
				mb=hb+lb;
				if(ma==a&&b==mb) break;
				else if((b*ma)<(mb*a))
				{
					sol+="R";
					la=ma;
					lb=mb;
				}
				else
				{
					sol+="L";
					ha=ma;
					hb=mb;
				}
			}
			System.out.println(sol);
		}
	}
	
	
	static long gcd(long a,long b)
	{
		if(a==0) return b;
		return gcd(b%a,a);
	}
	static long lcm(long a,long b)
	{
		return b*a/gcd(a,b);
	}

}
