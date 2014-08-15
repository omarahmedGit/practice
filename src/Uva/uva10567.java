package Uva;
import java.util.*;
public class uva10567 {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		char[] avi=sc.next().toCharArray();
		ArrayList<Integer>[] vec=new ArrayList[256];
		for(int i=0;i<256;i++) vec[i]=new ArrayList<Integer>();
		for(int i=0;i<avi.length;i++) vec[avi[i]].add(i);
		int loop=sc.nextInt();
		char[] in;
		for(int i=0;i<loop;i++)
		{
			in=sc.next().toCharArray();
			int idx=-1;
			int start=0;
			boolean ch=true;
			for(int j=0;j<in.length;j++)
			{
				
				if(vec[in[j]].size()==0)
				{
					ch=false;
					break;
				}
				int h=vec[in[j]].size()-1,l=0,m;
				while(h!=l)
				{
					m=(l+h)/2;
					if(vec[in[j]].get(m)<=idx)
						l=m+1;
					else
						h=m;
				}
				if(vec[in[j]].get(l)<=idx)
				{
					
					ch=false;
					break;
				}
				idx=vec[in[j]].get(l);
				if(j==0) start=idx;
			}
			if(ch)
				System.out.printf("Matched %d %d\n",start,idx);
			else
				System.out.println("Not matched");
			
			
		}
	}
}
