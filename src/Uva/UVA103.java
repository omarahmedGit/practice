package Uva;
import java.util.*;
public class UVA103 {
	static int n,d;
	static node[] arr;
	static int[][] dp = new int[33][33];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			n = sc.nextInt();
			d = sc.nextInt();
			arr = new node[n+1];
			for (int i = 0; i < 33; i++) {
				for (int j = 0; j < 33; j++) {
					dp[i][j] =-1;
				}
			}
			arr[0] = new node(-1);
			for (int i = 0; i < d; i++) {
				arr[0].dim.add(-1);
			}
			for (int i = 1; i <= n; i++) {
				arr[i] = new node(i-1);
				for (int j = 0; j < d; j++) {
					int di = sc.nextInt();
					arr[i].dim.add(di);
				}
				Collections.sort(arr[i].dim);
			}
			Arrays.sort(arr);
			System.out.println(LIS(1,0));
			trace(1,0);
		}
		
		
		sc.close();		
	}
	
	static int LIS(int i,int j)
	{
		if(i==arr.length) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int choice1 = LIS(i+1,j);
		int choice2 = 0;
		
		if(ch(i,j))
			choice2 = 1+ LIS(i+1,i);
		
		return dp[i][j] = Math.max(choice1, choice2);
	}
	
	
	static void trace(int i,int j)
	{
		if(i==arr.length) return ;
		
		int choice1 = LIS(i+1,j);
		int choice2 = 0;
		
		if(ch(i,j))
			choice2 = 1+ LIS(i+1,i);
		
		if(choice1<=choice2)
		{
			System.out.print(arr[i].index+1);
			if(choice2==1){
				System.out.println();
				return ;
			}
			System.out.print(" ");
			trace(i+1,i);
			return ;
		}
		trace(i+1,j);
	}
	
	static boolean ch(int i,int j)
	{
		for (int j2 = 0; j2 < d; j2++) {
			if(arr[i].dim.get(j2)<=arr[j].dim.get(j2)) return false;
		}
		return true;
	}
	
	public static class node implements Comparable<node>
	{
		ArrayList<Integer> dim ;
		int index;
		public node(int idx) {
			dim = new ArrayList<Integer>();
			index = idx;
		}
		@Override
		public int compareTo(node o) {
			for (int i = 0; i < dim.size(); i++) {
				if(dim.get(i)!=o.dim.get(i))
					return dim.get(i)- o.dim.get(i);
			}
			return 0;
		}
	}

}
