package Uva;
import java.util.*;
public class UVa10285 {
	private static int[][] degree   = new int[100][100];
	private static int[][] hights = new int[100][100];
	private static int[][] weights = new int[100][100];
	private static int R,C;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int ii=0;ii<t;ii++)
		{
			String name = sc.next();
			R = sc.nextInt();
			C = sc.nextInt();
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					hights[i][j] = sc.nextInt();
					weights[i][j] = 0;
				}
			}
			
			
			int solution = snowBoard(); // solution
			System.out.printf("%s: %d\n",name,solution);
		}
		
		sc.close();
	}
	
	public static int snowBoard()
	{
		int[] x = {1,-1,0,0};
		int[] y = {0,0,-1,1};
		
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int indegree = 0;
				for (int j2 = 0; j2 < 4; j2++) {
					int xx = i+x[j2];
					int yy = j+y[j2];
					
					if(xx>=0&xx<R&&yy>=0&&yy<C)
					{
						if(hights[xx][yy]>hights[i][j])
						{
							indegree++;
						}
					}
				}
				degree[i][j] = indegree; 
				q.add(new Node(i,j,indegree));
			}
		}
		Node cur ;
		int max = 0;
		
//		System.out.println(q.size());
		
		while(!q.isEmpty())
		{
			cur = q.poll();
			
			if(cur.b!=0) continue;
			for (int i = 0; i < 4; i++) {
				int xx = cur.i + x[i];
				int yy = cur.j + y[i];
				if(xx>=0&xx<R&&yy>=0&&yy<C)
				{
					if(hights[cur.i][cur.j]>hights[xx][yy])
					{
						int in = --degree[xx][yy];
						q.add(new Node(xx,yy,in));
						
						if(weights[xx][yy]<=weights[cur.i][cur.j])
						{
							weights[xx][yy] = 1 + weights[cur.i][cur.j];
							max = Math.max(max, weights[xx][yy]);
						}
					}
					
				}
			}
			
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(weights[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return max+1;
	}
	
	public static class Node implements Comparable<Node>
	{
		int i,j,b;
		public Node(int i,int j,int b)
		{
			this.i = i;
			this.j = j;
			this.b = b;
		}
		
		public int compareTo(Node o)
		{
			return this.b-o.b;
		}
	}

}
