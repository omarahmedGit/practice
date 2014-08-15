package CF;
import java.util.*;
public class CFA_236 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k,a,b,v,boxs=0, cur_div;
		
		k = sc.nextInt() - 1;
		a = sc.nextInt();
		b = sc.nextInt();
		v = sc.nextInt();
		
		while(a>0)
		{
			if(k<=b)
			{
				cur_div = k;
				b-=k;
			} else {
				cur_div = b;
				b = 0;
			}
			
			a = a - ((cur_div+1)*v);
			boxs++;
		}
		
		System.out.println(boxs);
		
		
		sc.close();
	}

}
