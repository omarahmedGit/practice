package CF;

import java.util.*;

public class CF258_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextLong();
		}
		
		sc.close();

		boolean check = true ;
		long start = 1, end = 1;
		for (int i = 0; i < a.length-1; i++) {
			if(a[i]>a[i+1])
			{
				if(!check){
					System.out.println("no");
					return ;
				}
				check = false;
				int len = 1;
				for (int j = i+1; j < a.length; j++) {
					if(a[j]<a[j-1])
					{
						len++;
					} else {
						break;
					}
				}
				if((i>0)&&(a[i+len-1]<a[i-1]))
				{
					System.out.println("no");
					return ;
				}
				start = i+1;
				end = i+len;
				long temp ;
				int index = (len+1)/2;
				for (int j = i,k=0; k<index & j < a.length; k++,j++) {
					temp = a[j];
					a[j] = a[j+len-1];
					a[j+len-1] = temp;
					len-=2;
				}
				
			}
		}
		System.out.printf("yes\n%d %d\n",start,end);
		
	}

}
