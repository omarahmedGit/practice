package Uva;
import java.util.*;
public class UVa11957 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] checker = new int[100][100];
		boolean[][] place = new boolean[100][100];
		boolean[][] vis   = new boolean[100][100];
		int s,r=0,c=0,idx=0;
		int cases = sc.nextInt();
		
		while(idx++<cases)
		{
			PriorityQueue<IntegerPair> q = new PriorityQueue<IntegerPair>();
			s  = sc.nextInt();
			for (int i = 0; i < s; i++) {
				char[] in = sc.next().toCharArray();
				for (int j = 0; j < s; j++) {
					if(in[j]=='B')
					{
						place[i][j] = true;
					} else
					{
						place[i][j] = false;
						if(in[j]=='W')
						{
							r = i;
							c = j;
						}
					}
					checker[i][j] = 0;
					vis[i][j] = false;
				}
			}
			
			checker[r][c] = 1;
			q.add(new IntegerPair(r,c));
			IntegerPair cur ;
			
			while(!q.isEmpty())
			{
				cur = q.poll();
				if(vis[cur.f1][cur.f2]) continue ;
				vis[cur.f1][cur.f2] = true ;
//				System.out.println("x : "+cur.f1+" y: "+cur.f2);
				if(cur.f1-1>=0&cur.f2-1>=0)
				{
					if(place[cur.f1-1][cur.f2-1])
					{
						if(cur.f1-2>=0&cur.f2-2>=0)
						{
							if(!place[cur.f1-2][cur.f2-2])
							{
								checker[cur.f1-2][cur.f2-2] = (checker[cur.f1-2][cur.f2-2]%1000007+checker[cur.f1][cur.f2]%1000007)%1000007;
								q.add(new IntegerPair(cur.f1-2,cur.f2-2));
							}
						}
					} else {
						checker[cur.f1-1][cur.f2-1]=(checker[cur.f1-1][cur.f2-1]%1000007+ checker[cur.f1][cur.f2]%1000007)%1000007;
						q.add(new IntegerPair(cur.f1-1,cur.f2-1));
					}
				}
				
				if(cur.f1-1>=0&cur.f2+1<s)
				{
					if(place[cur.f1-1][cur.f2+1])
					{
						if(cur.f1-2>=0&cur.f2+2<s)
						{
							if(!place[cur.f1-2][cur.f2+2])
							{
								checker[cur.f1-2][cur.f2+2] = (checker[cur.f1-2][cur.f2+2]%1000007+checker[cur.f1][cur.f2]%1000007)%1000007;
								q.add(new IntegerPair(cur.f1-2,cur.f2+2));
							}
						}
					} else {
						checker[cur.f1-1][cur.f2+1] = (checker[cur.f1-1][cur.f2+1]%1000007+checker[cur.f1][cur.f2]%1000007)%1000007;
						q.add(new IntegerPair(cur.f1-1,cur.f2+1));
					}
				}
			}
			int solution = 0;
			for (int k = 0; k < s; k++) {
				solution = (solution%1000007+checker[0][k]%1000007)%1000007;
			}
			System.out.printf("Case %d: %d\n",idx,solution);
			
		}
		
		
		sc.close();
	}
	public static class IntegerPair implements Comparable<IntegerPair>
	{
		int f1,f2;
		public IntegerPair(int a,int b)
		{
			f1 = a;
			f2 = b;
		}
		public int compareTo(IntegerPair o)
		{
			return o.f1-this.f1;
		}
	}

}
