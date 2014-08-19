package CF;

import java.util.*;

public class CF261_B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long n = sc.nextLong();
		long min = 10000000000L,xmin = 0;
		long max = -1, xmax = 0;

		int in;
		for (int i=0;i<n;i++) {
			in = sc.nextInt();
			if(in==min)
			{
				xmin++;
			} else if(in<min)
			{
				min = in;
				xmin = 1;
			}

			if(in==max)
			{
				xmax++;
			} else if(in>max) {
				max = in;
				xmax = 1;
			}
		}
		
		

		if(min==max)
			System.out.printf("%d %d\n",0,(n*(n-1))/2);
		else
			System.out.printf("%d %d\n",max-min,xmin*xmax);

		sc.close();
	}
}