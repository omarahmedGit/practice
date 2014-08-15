package CF;
import java.util.*;

public class CFC_FF {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int max = -1;
		int n = sc.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		int[] l = new int[n];
		int[] r = new int[n];
		
		l[0] = r[n-1] = 1;
		
		for (int i = 1; i < l.length; i++)
			if(input[i-1]<input[i]) l[i] = l[i-1]+1;
			else l[i] = 1;
		
		for (int i = n-2; i > -1; i--)
			if(input[i]<input[i+1]) r[i] =r[i+1]+1;
			else r[i] = 1;
			
		if(r[0]!=n)
			max = Math.max(l[n-1]+1, r[0]+1);
		else max = n;
		
		for(int i=1;i<n-1;i++)
		{
			max = Math.max(max, l[i-1]+1);
			max = Math.max(max, r[i+1]+1);
			if(input[i-1]<input[i+1])
				max = Math.max(max, l[i-1]+1+r[i+1]);
		}
		
		System.out.println(max);
		
		sc.close();
	}

}
