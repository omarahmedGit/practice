package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Uva10377 {
	static int row,col,in_x,in_y;
	static boolean[][] world = new boolean[62][62];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		int testCases = Integer.parseInt(st.nextToken());
		while(testCases-->0)
		{
			st = new StringTokenizer(br.readLine()) ;
			st = new StringTokenizer(br.readLine()) ;
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			for (int i = 0; i < row; i++) {
				char[] a = br.readLine().toCharArray();
				for (int j = 0; j < a.length; j++) if(a[i]!='*') world[i][j]=true;
			}
			st = new StringTokenizer(br.readLine()) ;
			in_x = Integer.parseInt(st.nextToken());
			in_y = Integer.parseInt(st.nextToken());
			String read ,order ="";
			boolean re = true;
			while(re)
			{
				read = br.readLine();
				if(read.charAt(read.length()-1)=='Q') re=false;
				order = order + read;
			}
			robot();
		}
		
		br.close();
	}
	
	public static void robot()
	{
		
	}

}
