package Uva;
import java.util.*;
public class uva957 {
	/*
	 *  this problem a kind of complete search i check all the lengths and get the max with in range
	 *  checking all the acceptable lengths starting from index i. 
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext())
		{
			int y=sc.nextInt();
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++) a[i]=sc.nextInt();
			int first=0,last=0,max=0;
			for(int i=0,j;i<n;i++)
			{
				j=i;
				int count=0;
				while(j<n&&a[j]-a[i]<=y-1)
				{
					count++;
					j++;
				}
				if(count>max)
				{
					first=a[i];
					last=a[j-1];
					max=count;
				}
			}
			System.out.printf("%d %d %d\n",max,first,last);
		}
	}

}
