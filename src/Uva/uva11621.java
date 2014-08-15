package Uva;
import java.util.*;
public class uva11621 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		gen_set();
		int n;
		while(true)
		{
			n=sc.nextInt();
			if(n==0) break;
			int h=set.size(),l=0,m;
			while(h!=l)
			{
				m=(l+h)/2;
				if(set.get(m)<n)
					l=m+1;
				else
					h=m;
			}
			System.out.println(set.get(h));
		}
		sc.close();
	}
	
	static ArrayList<Long> set=new ArrayList<Long>();
	static void gen_set()
	{
		for(int i=0;i<31;i++)
		{
			for(int j=0;j<31;j++)
			{
				long number=(long)(Math.pow(2, i)*Math.pow(3, j));
				if(number<=0)
					break;
				set.add(number);
			}
		}
		Collections.sort(set);
	}

}
