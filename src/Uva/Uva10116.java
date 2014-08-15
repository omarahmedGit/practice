package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Uva10116 {
	static int x,y,s;
	static char[][] map = new char[12][12];
	static boolean[][] mapvis = new boolean[12][12];
	static int[][] dis = new int[12][12];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if(x==0&y==0&s==0) break;
			
			for (int i = 0; i < x; i++) {
				st = new StringTokenizer(br.readLine());
				char[] in = st.nextToken().toCharArray();
				for (int j = 0; j < in.length; j++) {
					map[i][j] = in[j];
				}
			}
			reset();
			loop();
		}
		
		br.close();
	}
	public static void reset()
	{
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
				mapvis[i][j] = false;
				dis[i][j] = 0;
			}
		}
	}
	public static void loop()
	{
		// n,s,w,e
		int[] ys = {0,0,-1,1};
		int[] xs = {-1,1,0,0};
		x--; y--;
		boolean looptest = false;
		node cur = new node(0,s-1);
		
		while(true)
		{
			if(looptest|cur.x<0|cur.x>x|cur.y<0|cur.y>y) break;
			if(mapvis[cur.x][cur.y]) {cur.loop=true;  break;}
			mapvis[cur.x][cur.y]=true;
			dis[cur.x][cur.y] = cur.counter++;
			if(map[cur.x][cur.y]=='N')
			{
				cur.x+=xs[0];
				cur.y+=ys[0];
			} else if (map[cur.x][cur.y]=='S') {
				cur.x+=xs[1];
				cur.y+=ys[1];
			} else if (map[cur.x][cur.y]=='W') {
				cur.x+=xs[2];
				cur.y+=ys[2];
			} else {
				cur.x+=xs[3];
				cur.y+=ys[3];
			}
		}
		
		if(!cur.loop)
		{
			System.out.printf("%d step(s) to exit\n",cur.counter);
		}
		else
		{
			int a = dis[cur.x][cur.y];
			int b = cur.counter-a;
			System.out.printf("%d step(s) before a loop of %d step(s)\n",a,b);
		}
		
		
		
	}

	
	public static class node
	{
		int x,y,counter;
		boolean loop;
		int loopcounter;
		public node(int x,int y) {
			this.x = x;
			this.y = y;
			loop=false;
			counter = 0;
			loopcounter = 0;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
