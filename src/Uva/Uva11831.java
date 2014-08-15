package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Uva11831 {
	static int n,m,s;
	static int[][] world = new int[101][101];
	static char[] order ;
	static int[] xs = {-1,0,1,0},ys={0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char[] re;
		char ii ;
		int xx=0,yy=0,zz=0;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			if(n==0&m==0&s==0) break;
			// * -> 3 sticker 
			// # -> 2 block
			// else normal 
			for (int i = 0; i < n; i++) {
				re = br.readLine().toCharArray();
				for (int j = 0; j < re.length; j++) {
					ii=re[j];
					world[i][j] = (ii=='*')?3:(ii=='#')?2:1;
					if(ii=='N'|ii=='S'|ii=='L'|ii=='O'){
						xx=i;
						yy=j;
						zz=(ii=='N')?0:(ii=='S')?2:(ii=='L')?1:3;
					}
				}
			}
			order = br.readLine().toCharArray();
			robot(xx,yy,zz);
		}
		
		
		br.close();
	}
	static void robot(int x,int y,int z)
	{
		int _x,_y,collect = 0;
		for(char d:order)
		{
			if(d=='E')
				z= z==0?3:z-1;
			else if(d=='D')
				z= z==3?0:z+1;
			else
			{
				_x = xs[z]+x;
				_y = ys[z]+y;
				if(_x<0||_y<0||_x>=n||_y>=m) continue;
				else if(world[_x][_y]==2) continue;
				else {
					x=_x;
					y=_y;
					if(world[_x][_y]==3){collect++; world[_x][_y]=1;}
				}
			}
		}
		System.out.println(collect);
	}

}
