package Uva;
import java.util.*;
public class Uva11248 {
	static int[][] roads = new int[52][52];
	static int[][] dp = new int[52][4100];
	static final int inf = 1000000000; 
	static int number_of_stors,number_of_tracks;
	static node[] data = new node[15];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		int number_of_roads ;
		while(testcases-->0)
		{
			number_of_stors = sc.nextInt();
			number_of_roads = sc.nextInt();
			for (int i = 0; i < 52; i++) {
				for (int j = 0; j < 52; j++) {
					if(i==j) roads[i][j] = 0;
					else roads[i][j] = inf;
				}
			}
			for (int i = 0; i < number_of_roads; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				double val = sc.nextDouble();
				int val2 = (int)(val*100+(1e-9));
				roads[y][x] = roads[x][y] = Math.min(roads[x][y], val2);
			}
			number_of_tracks = sc.nextInt();
			for (int i = 0; i < number_of_tracks; i++) {
				int x = sc.nextInt();
				double y = sc.nextDouble();
				int yy = (int)(y*100+(1e-9));
				data[i] = new node(x,yy); 
			}
			
			floyed(); // all pairs shortest path
			int maxnumber = (1<<number_of_tracks);
			for (int i = 0; i <= number_of_stors; i++) {
				for (int j = 0; j <= maxnumber; j++) {
					dp[i][j] = -1;
				}
			}
			
			int sol1 = TSP(0,0) ;
			int sol2 = getAllFromAmazon();
			int sol3 = sol2-sol1;
			int firstpart = sol3/100;
			int secondpart= sol3%100;
			if(sol1<sol2)
			{
				System.out.printf("Daniel can save $%d",firstpart);
				if(secondpart<10)
					System.out.printf(".0%d\n",secondpart);
				else
					System.out.printf(".%d\n",secondpart);
			}else
				System.out.println("Don't leave the house");
			
		}
		
		
		
		sc.close();
	}
	
	static int TSP(int pos,int mask)
	{
		if(mask==(1<<number_of_tracks)-1)
		{
			if(pos==0)
				return 0;
			else
				return roads[pos][0];
		}
		
		if(dp[pos][mask]!=-1) return dp[pos][mask];
		
		int min = inf;
		
		for (int i = 0; i < number_of_tracks; i++) {
			if((mask&(1<<i))==0)
			{
				int ch1 = roads[pos][data[i].x] + TSP(data[i].x,mask|1<<i);
				int ch2 = roads[pos][0] + data[i].pri +TSP(0,mask|1<<i);
				min = Math.min(min, Math.min(ch1, ch2));
			}
		}
		
		return dp[pos][mask] = min;
	}
	
	static int getAllFromAmazon()
	{
		int sum = 0;
		for (int i = 0; i < number_of_tracks; i++) {
			sum+=data[i].pri;
		}
		return sum;
	}
	
	
	public static class node
	{
		int x;
		int pri;
		public node(int x, int pri) {
			this.x = x;
			this.pri = pri;
		}
	}
	static void floyed()
	{
		for (int i = 0; i <= number_of_stors; i++) {
			for (int j = 0; j <= number_of_stors; j++) {
				for (int j2 = 0; j2 <= number_of_stors; j2++) {
					roads[j][j2] = Math.min(roads[j][j2], roads[j][i]+roads[i][j2]);
				}
			}
		}
	}

}
