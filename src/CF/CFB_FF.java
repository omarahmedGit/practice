package CF;
import java.util.*;

public class CFB_FF {

	static long sum(long x)
	{
		return x*(x+1)/2;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] abc = new int[26];
		char[] in = sc.next().toCharArray();
		int n = sc.nextInt();
		
		for(int i=0;i<26;i++) abc[i] = sc.nextInt();
		
		int max = -1;
		
		for (int i = 0; i < 26; i++)
			if(abc[i]>max)
				max= abc[i];
		
		long count = 0;
		for (int i = 0; i < in.length; i++) {
			count += (abc[(in[i]-'a')]*(i+1));
		}
		
		long coef = n==0?0:sum(in.length+n)  - sum(in.length);
		count+=(coef*max);
		
		System.out.println(count);
		
		sc.close();
	}

}
