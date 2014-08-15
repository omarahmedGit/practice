package Uva;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;
public class uva12192 {
	static int row,col;
	static int[][] gar=new int[1001][510];
	static int[] pos=new int[1001];
	static int a,b;
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc=new Scanner(new FileReader("input.in"));
		PrintWriter pw=new PrintWriter(System.out);
		while(true)
		{
			row=sc.nextInt();
			col=sc.nextInt();
			if(row==0&&col==0) break;
			for(int i=0;i<1001;i++) pos[i]=0;
			for(int i=0;i<row;i++)
				for(int j=0;j<col;j++)
					gar[j-i+row-1][pos[j-i+row-1]++]=sc.nextInt();
			int q=sc.nextInt();
			
			for(int i=0;i<q;i++)
			{
				int max=-1;
				a=sc.nextInt();
				b=sc.nextInt();
				
				for(int j=0;j<row+col-1;j++)
				{
					int aa=lower_bound(j);
					int bb=upper_bound(j);
					int ans=aa-bb;
					if(ans<0) ans=0;
					else if(gar[j][aa]>=a) ans++;
					max=Math.max(max,ans);
				}
				pw.println(max);
			}
			pw.println("-");
		}
		pw.close();
	}
	static int upper_bound(int x)
	{
		int h=pos[x]-1,l=0,m;
		while(h>l+1)
		{
			m=(h+l)/2;
			if(gar[x][m]<a)
				l=m+1;
			else
				h=m;
		}
		return gar[x][l]<a?h:l;
	}
	static int lower_bound(int x)
	{
		int h=pos[x]-1,l=0,m;
		while(h>l+1)
		{
			m=(h+l)/2;
			if(gar[x][m]>b)
				h=m-1;
			else
				l=m;
		}
		return gar[x][h]>b?l:h;
	}
}
