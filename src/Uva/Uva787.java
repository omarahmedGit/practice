package Uva;
import java.math.BigInteger;
import java.util.*;


public class Uva787 {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			ArrayList<Integer> a = new ArrayList<Integer>();
			while(true)
			{
				int num = sc.nextInt();
				if(num ==-999999) break;
				a.add(num);
			}
			System.out.println(product(a));
		}
		
		sc.close();
	}
	
	static BigInteger product(ArrayList<Integer> a )
	{
		
		String val = ""+ a.get(0);
		
		BigInteger maxfinal = new BigInteger(val);
		BigInteger max = new BigInteger(val);
		BigInteger min = new BigInteger(val);
		BigInteger mmax,mmin,cur;
		for (int i = 1; i < a.size(); i++) {
			val = ""+ a.get(i);
			cur = new BigInteger(val);
			mmax = new BigInteger(max.toString());
			mmin = new BigInteger(min.toString());
			BigInteger com = new BigInteger(cur.toString());
			com = com.max(mmax.multiply(cur));
			max = com.max(mmin.multiply(cur));
			com = new BigInteger(cur.toString());
			com = com.min(mmin.multiply(cur));
			min = com.min(mmax.multiply(cur));
			maxfinal = maxfinal.max(max);
		}
		
		return maxfinal;
	}

	static long product2(ArrayList<Integer> a )
	{
		long maxfinal = -1000000000;
		long max =1,min=1;
		if(a.size()>0)
			maxfinal = max = min = a.get(0);
		for (int i = 1; i < a.size(); i++) {
			int d = a.get(i);
			long mmax = max,mmin = min;
			max = Math.max(d, Math.max(d*mmax, d*mmin));
			min = Math.min(d, Math.min(d*mmax, d*mmin));
			if(maxfinal<max)
				maxfinal = max;
		}
		
		return maxfinal;
	}
}
