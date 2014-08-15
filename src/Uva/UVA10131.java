package Uva;
import java.util.*;

public class UVA10131 {
	static ArrayList<node> group;
	static int[][] dp = new int[1005][1005];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		group = new ArrayList<node>();
		int idx = 0;
		while (sc.hasNext()) {
			int a = sc.nextInt();
			if(a==0) break;
			int b = sc.nextInt();
			group.add(new node(++idx,a,b));
		}
		group.add(new node(0,0,10001));
		Collections.sort(group);
		for (int i = 0; i < 1003; i++) {
			for (int j = 0; j < 1003; j++) {
				dp[i][j] = -1;
			}
		}
		
		bigger(1, 0);
		System.out.println(bigger(1, 0));
		trace(1, 0);
		sc.close();
	}

	
	static int bigger(int i,int j)
	{
		if(i==group.size())
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int choice1 = bigger(i+1, j);
		int choice2 = 0;
		
		node n = group.get(i);
		node p = group.get(j);
		
		if(n.w>p.w&&n.s<p.s)
			choice2 = 1+bigger(i+1, i);
		
		return dp[i][j] = Math.max(choice1, choice2);
	}
	
	static void trace(int i,int j)
	{
		if(i==group.size())
			return ;
		
		int choice1 = bigger(i+1,j);
		int choice2 = 0;
		
		node n = group.get(i);
		node p = group.get(j);
		
		if(n.w>p.w&&n.s<p.s)
			choice2 = 1+bigger(i+1, i);
		
		if(choice1<=choice2)
		{
			System.out.println(n.idx);
			if(choice2==1) return ;
			trace(i+1,i);
			return ;
		}
		trace(i+1,j);
	}
	
	
	
	
	public static class node implements Comparable<node> {
		int idx, w, s;

		public node(int index, int wight, int smart) {
			idx = index;
			w = wight;
			s = smart;
		}

		@Override
		public int compareTo(node o) {
			if (o.w == this.w)
				return this.s - o.s;
			return this.w - o.w;
		}
	}

}
