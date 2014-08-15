package CF;
import java.util.*;
public class CFA_212 {
	static boolean[][] board = new boolean[8][8];
	static boolean[][][][] ex = new boolean[8][8][8][8];
	static int[][] ke1 = new int[8][8];
	static int[][] ke2 = new int[8][8];
	static int index=0;
	static int[][] kk = new int[2][2];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		for (int i = 0; i < t; i++) {
			index =0;
			for (int j = 0; j < 8; j++) {
				char[] in = sc.next().toCharArray();
				for (int k = 0; k < 8; k++) {
					if(in[k]=='K')
					{
						if(index==0)
						{
							kk[0][0] = j;
							kk[0][1] = k;
						}
						else if(index==1)
						{

							kk[1][0] = j;
							kk[1][1] = k;
						}
						index++;
					}
					else if(in[k]=='#')
					{
						board[j][k]=true;
					}
				}
			}
			
			if(check(kk[0][0],kk[0][1],kk[1][0],kk[1][1],0))
				System.out.println("YES");
			else
				System.out.println("NO");
			ke1 = new int[8][8];
			ke2 = new int[8][8];
			board = new boolean[8][8];
			ex = new boolean[8][8][8][8];
		}
		sc.close();

	}
	public static boolean check(int x,int y,int x1,int y1, int z)
	{
		if(x>7||x<0||y<0||y>7||x1<0||x1>7||y1<0||y1>7) return false;
		if(ex[x][y][x1][y1]) return false;
		ex[x][y][x1][y1]=true;
		if(z==0)
		{
			if(x==x1&&y==y1&&!board[x][y]) return true;

			if(check(x+2,y+2,x1,y1,1)) return true;
			if(check(x+2,y-2,x1,y1,1)) return true;
			if(check(x-2,y+2,x1,y1,1)) return true;
			if(check(x-2,y-2,x1,y1,1)) return true;
			return false;
		}
		else
		{
//			if(x==x1&&y==y1&&!board[x][y]) return true;
			if(check(x,y,x1+2,y1+2,0)) return true;
			if(check(x,y,x1+2,y1-2,0)) return true;
			if(check(x,y,x1-2,y1+2,0)) return true;
			if(check(x,y,x1-2,y1-2,0)) return true;
		}
		return false;
	}

}
