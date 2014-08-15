package CF;
import java.util.*;
public class CF_246_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] arr = new int[6];
		for (int i =0; i<n ;i++ ) {
			arr[5 - sc.nextInt()]++;
		}

		int teams = 0;

		int idx = k;

		while(idx<6)
		{
			teams = teams + ( arr[idx]/3 ) ;
			arr[idx] = arr[idx] % 3 ;
			idx ++; 
		}

		idx = 5;
		int count = 0;
		while(idx>=k)
		{
			count+=arr[idx];
			if(count>=3)
			{
				teams++;
				count%=3;
			}
			idx--;
		}

		System.out.println(teams);
		sc.close();

	}

}
