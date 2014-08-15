package Uva;
import java.util.*;
public class Uva216 {
	static int n;
	static node[] network= new node[10];
	static double[][] dp = new double[10][300];
	static int[][] trace = new int[10][300];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a,b,idx=1;
		while(sc.hasNext())
		{
			n = sc.nextInt();
			if(n==0) break;
			System.out.println("**********************************************************");
			System.out.printf("Network #%d\n",idx++);
			for (int i = 0; i < n; i++) {
				a = sc.nextInt();
				b = sc.nextInt();
				network[i] = new node(a,b);
			}
			for (int i = 0; i < 10; i++)
				Arrays.fill(dp[i], -1);
			double ans = 1000000000;
			int minidx = 0;
			for (int i = 0; i < n; i++) {
				double sol = cable(i,1<<i);
				if(sol<ans)
					minidx = i;
				ans = Math.min(ans, sol);
			}
			ans += (16*(n-1));
			sqrtrace(minidx);
			System.out.printf("Number of feet of cable required is %.2f.\n",ans);
		}
		
		
		
		
		sc.close();
	}
	
	public static double cable(int pos, int mask)
	{
		if(mask==((1<<n)-1))
			return 0;
		
		if(dp[pos][mask]>-0.5) return dp[pos][mask];
		
		double min = 1000000000;
		int minidx = pos;
		for (int i = 0; i < n; i++) {
			if((mask&(1<<i))==0)
			{
				double sol = sqrdis(pos,i)+cable(i,(mask|(1<<i)));
				if(min>sol)
					minidx = i;
				min = Math.min(min, sol);
			}
		}
		trace[pos][mask] = minidx;
		return dp[pos][mask] = min;
	}
	
	static void sqrtrace(int start)
	{
		int s=start,e,mask = 1<<start;
		for (int i = 0; i < n-1; i++) {
			e = trace[s][mask];
			System.out.printf("Cable requirement to connect ");
			System.out.printf("(%d,%d) to (%d,%d) is ",network[s].x,network[s].y,network[e].x,network[e].y);
			System.out.printf("%.2f feet.\n",(16+sqrdis(s, e)));
			s = e;
			mask = mask|1<<e;
		}
		
	}
	
	static double sqrdis(int idx1, int idx2)
	{
		int a = Math.abs(network[idx1].x-network[idx2].x);
		int b = Math.abs(network[idx1].y-network[idx2].y);
		return Math.sqrt((a*a)+(b*b));
	}
	
	
	public static class node
	{
		int x,y;
		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
