package CF;
import java.util.*;
public class CF263_A2 {
	static boolean[][] board ;
	static int n;
	static int[] x = {1,-1,0,0}, y = {0,0,1,-1};
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		n = sc.nextInt();
		board =new boolean[n][n];
		
		for (int i = 0; i < n; i++) {
			char[] in = sc.next().toCharArray();
			for (int j = 0; j < in.length; j++) {
				if(in[j]=='o')
					board[i][j] = true;
			}
		}
		
		boolean check = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int count = 0;
				for (int j2 = 0; j2 < 4; j2++) {
					if(checkpos(i+x[j2],j+y[j2]))
					{
						count++;
					}
				}
				if(count%2!=0)
				{
					check = false;
					break;
				}
			}
		}
		
		
		if(check)
			System.out.println("YES");
		else
			System.out.println("NO");
		
		sc.close();
	}
	private static boolean checkpos(int i, int j) {
		if(i>=0&&j>=0&&i<n&&j<n) return board[i][j];
		return false;
	}
	
	
	

}
