package CF;
import java.util.*;
public class CF260_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		int mod = getModFour(str.toCharArray());
		System.out.println(func(mod));
	}
	
	static int func(int mod)
	{
		return (1+power(2,mod)+power(3,mod)+power(4,mod))%5;
	}
	
	
	private static int power(int i, int mod) {
		int ret = 1;
		for (int j = 0; j < mod; j++) {
			ret*=i;
		}
		return ret;
	}

	static int getModFour(char[] in)
	{
		long x = 0;
		int idx ;
		for (int i = 0; i < in.length; i++) {
			idx = in[i]-'0';
			if(i==in.length-2) {
				x+= ((2*(idx%4))%4);
			} else if(i==in.length-1) {
				x+= ((1*(idx%4))%4);
			}
		}
		
		return (int)(x%4);
	}

}
