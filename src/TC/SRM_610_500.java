package TC;

public class SRM_610_500 {
	
	static boolean[][] board;
	
	
	public static void main(String[] args) {
		String[] a = {"001", "000", "100"};
		System.out.println(MaxArea(a));
	}
	
	public static int MaxArea(String[] a)
	{
		int res = 0;
		board = new boolean[a.length][a[0].length()];
		for (int i=0;i<a.length;i++) {
			for (int j=0;j<a[0].length();j++) {
				board[i][j]= a[i].charAt(j)=='0'?false:true;
			}
		}
		
		int w = board[0].length , h = board.length;
		for (int i=0;i<w;i++) {
			char[] row = new char[h];
			for (int j=i;j<w;j++) {

				if(j==i)
				{
					for(int k=0;k<h;k++)
						row[k] = board[k][i]?'1':'0';
				}
				else 
				{
					for (int k=0;k<h;k++) {
						if(board[k][j]==board[k][j-1])
							row[k] = 'x';
					}
				}

				int mh = 0, ch = 0;
				for (int k=0;k<h;k++) {
					if(row[k]=='x')
						ch = 0;
					else if((ch>0)&&(row[k]!=row[k-1]))
						ch++;
					else
						ch = 1;
					mh = Math.max(mh,ch);
				}
				res = Math.max(res, (j-i+1)*mh);
			}
		}
		return res;
	}
}
