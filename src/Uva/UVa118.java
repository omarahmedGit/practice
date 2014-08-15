package Uva;
import java.util.*;
public class UVa118 {
	static boolean[][] world = new boolean[55][55];
	static int topx ,topy;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		topx = sc.nextInt();
		topy = sc.nextInt();
		
		while(sc.hasNext())
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			String c = sc.next();
			String order = sc.next();
			robot(a, b, c.charAt(0), order);
		}
		sc.close();
	}
	
	
	static void robot(int x,int y,char n, String order)
	{
		node cur = new node(x,y,n);
		for(char z : order.toCharArray())
		{
			if(!cur.status) break;
			if(z=='F'){
				if(cur.check()) cur.changePos(z);
			} else { cur.changePos(z); }
		}
		if(cur.status)
			System.out.printf("%d %d %c\n",cur.x,cur.y,node.dir[cur.z]);
		else
			System.out.printf("%d %d %c LOST\n",cur.x,cur.y,node.dir[cur.z]);
	}
	
	
	public static class node
	{
		int x,y,z;
		static char[] dir = {'S','E','N','W'};
		static int[] xs = {0,1,0,-1};
		static int[] ys = {-1,0,1,0};
		boolean status;
		
		public node(int x,int y,char z) {
			this.x= x;
			this.y= y;
			this.z = z=='S'?0:z=='E'?1:z=='N'?2:3;
			status = true;
		}
		
		public void changePos(char k)
		{
			if(!status) return ;
			if(k=='F')
			{
				x+=xs[z];
				y+=ys[z];
			} else if(k=='R') {
				z--;
				if(z<0) z= 3;
			} else if(k=='L') {
				z++;
				z=z%4;
			}
		}
		
		public boolean check()
		{
			int x1 = x+xs[z];
			int y1 = y+ys[z];
			if(x1<0|x1>topx|y1<0|y1>topy)
			{
				if(world[x][y]) return false;
				status = false;
				world[x][y]=true;
				return false;
			}
			return true;
		}
		
	}
	
	
	

}
