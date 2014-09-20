package CF;
import java.util.*;
public class CF263_C2 {
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n = sc.nextInt();
		Long[] ar = new Long[n];
		
		for (int i = 0; i < ar.length; i++) {
			ar[i] = sc.nextLong();
		}
		
		Arrays.sort(ar);
		long sol = 0;
		for (int i = 0; i < ar.length; i++) {
			sol+= ar[i];
		}
		
		int inilen = n;
		
		long val = sol;
		int idx  = 0;
		while(inilen>1)
		{
			if(inilen==2) {
				val+=(sol);
				inilen=0;
			}else {
				val+=sol;
				sol-=ar[idx++];
				inilen--;
			}
		}
		
		System.out.println(val);
		
		sc.close();
	}

}
