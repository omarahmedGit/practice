package CF;
import java.util.*;
public class CFA_213 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		char[] in ;
		int counter = n;
		for (int i = 0; i < n; i++) {
			in = sc.next().toCharArray();
			boolean[] t = new boolean[10];
//			boolean chk = false;
			for (int j = 0; j < in.length; j++) {
				t[in[j]-'0']= true;
//				if(in[j]>k+'0')
//				{
//					counter--;
//					chk = true;
//					break;
//				}
			}
			boolean te = true;
			for (int j2 = 0; j2 <= k; j2++) {
				if(!t[j2]) te = false;
			}
			if(!te) counter--;
		}
		System.out.println(counter);
		sc.close();

	}
	
	public int GCD(int a, int b)
	{
	   if (b==0) return a;
	   return GCD(b,a%b);
	}
	public int LCM(int a, int b)
	{
	   return b*a/GCD(a,b);
	}
}
