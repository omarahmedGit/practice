package Uva;
import java.util.*;
/*
 * this binary search problem easy one the hole difficulty is in getting the right number after the binary search 
 * again only c++ passed java same code TLE -_- 
 */
public class uva10611 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int g=sc.nextInt();
		int[] data=new int[g];
		for(int i=0;i<g;i++) data[i]=sc.nextInt();
		int b=sc.nextInt();
		int[] q=new int[b];
		for(int i=0;i<b;i++)
		{
			int l=0,h=g-1,m;
			int target=sc.nextInt();
			while(l!=h)
			{
				m=(l+h) / 2;
				
				if(data[m]<target)
					l=m+1;
				else
					h=m;
			}
			if(data[l]==target)
	        {
	            int ch=l;
	            while(ch>-1)
	            {
	                if(data[ch]<target) break;
	                ch--;
	            }
	            if(ch==-1)
	                System.out.printf("X ");
	            else
	            	System.out.printf("%d ",data[ch]);
	            ch=l;
	            while(ch<g)
	            {
	                if(data[ch]>target) break;
	                ch++;
	            }
	            if(ch==g)
	            	System.out.printf("X\n");
	            else
	            	System.out.printf("%d\n",data[ch]);

	        }
	        else if(data[l]<target)
	        {
	            int ch=l;
	            System.out.printf("%d ",data[ch]);
	            while(ch<g)
	            {
	                if(data[ch]>target) break;
	                ch++;
	            }
	            if(ch==g)
	            	System.out.printf("X\n");
	            else
	            	System.out.printf("%d\n",data[ch]);
	        }
	        else
	        {
	            int ch=l;
	            while(ch>-1)
	            {
	                if(data[ch]<target) break;
	                ch--;
	            }


	            if(ch==-1)
	            	System.out.printf("X ");
	            else
	            	System.out.printf("%d ",data[ch]);
	            System.out.printf("%d\n",data[l]);
	        }
		}
	}

}
