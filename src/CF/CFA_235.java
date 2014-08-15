package CF;
import java.util.*;
public class CFA_235 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cards = sc.nextInt();
		int abs   = sc.nextInt();
		int sum =0, sol =0;


		for(int i=0;i<cards;i++)
			sum  = sum + sc.nextInt();

		sum = Math.abs(sum);

		while(sum>0)
		{
			if(sum>=abs){
				sum-=abs;
				sol++;
			}
			else
				abs = sum;
		}

		System.out.println(sol);



		sc.close();
	}

}
