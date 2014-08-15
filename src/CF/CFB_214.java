package CF;
import java.util.*;
public class CFB_214 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] a = new int[n];
		int p = sc.nextInt();
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		boolean[] cover = new boolean[n];
		int sol =0,max=Integer.MAX_VALUE;
		for (int i = 0; i < cover.length; i++) {
			if(!cover[i])
			{
				int sum = 0;
				for (int j = i; j < cover.length;) {
					if(cover[j]) break;
					sum+=a[j];
					cover[j]=true;
					j+=p;
					j%=n;
				}
				if(sum<max)
				{
					max=sum;
					sol=i;
				}
			}
		}
		System.out.println(sol+1);
		
		
		sc.close();
	}

}
