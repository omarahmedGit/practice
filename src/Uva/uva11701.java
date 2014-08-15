package Uva;
import java.util.*;
public class uva11701 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String in;
		while(sc.hasNext())
		{
			in=sc.next();
			if(in.charAt(0)=='E') break;
			
			double f=Double.parseDouble(in);
			if(f==0||f==1) 
			{
				System.out.println("MEMBER");
				continue;
			}
			int i=0;
			while(((f*=3)!=0))
			{
				if(i>6) break;
				int c=(int) f;
				f-=c;
				if(c==1)
				{
					System.out.println("NON-MEMBER");
					break;
				}
				i++;
			}
			if(i>6)
				System.out.println("MEMBER");
			
		}
		sc.close();
	}

}
