package Uva;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;
public class Uva11404 {
	static char[] word ;
	static int[][] dp = new int[1001][1001];
	static int[][] memo = new int[1001][1001];
	static int[][] f = new int[1010][26];
	static int[][] b = new int[1010][26];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		while(sc.hasNext())
		{
			word = sc.next().toCharArray();
			resetDP(word.length);
			pw.println(trace());
		}
		sc.close();
		pw.close();
	}
	
	static void resetDP(int max_length)
	{
		for (int i = 0; i <= max_length; i++) {
			for (int j = 0; j <= max_length; j++) {
				dp[i][j] = -1;
			}
		}
	}
	
	static int minpalindrom(int i ,int j)
	{
		if(i>=j) return i==j ?1:0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		int ch1 = minpalindrom(i+1, j-1) + (word[i]==word[j]? 2 : 0);
		int ch2 = minpalindrom(i  , j-1) ;
		int ch3 = minpalindrom(i+1,   j) ;
		
		return dp[i][j] = Math.max(ch1, Math.max(ch2, ch3)) ;
	}
	
	static int inf = 1<<28;
	
	static String trace()
	{
		String ret = "";
		
		for (int i = word.length-1; i >= 0; i--)
			for (int j = 0; j < 26; j++)
				f[i][j] = (char) (j+'a') == word[i] ? i : ((i==word.length-1) ? inf : f[i+1][j]);
		
		for (int i = 0; i < word.length; i++)
			for (int j = 0; j < 26; j++)
				b[i][j] = (char) (j+'a') == word[i] ? i : ((i==0) ? -inf : b[i-1][j]);
		
		int length = minpalindrom(0, word.length-1);
		int l= 0,r = word.length - 1;
		boolean odd= false;
		while(length>0)
		{
			for (int c = 0; c < 26; c++) {
				int x = f[l][c];
				int y = b[r][c];
				if(length==1)
				{
					if(x<=y)
					{
						length--;
						ret = ret + (char)(c+'a')+ flib(ret.toCharArray());
						odd = true;
						break;
					}
				}
				else
				{
					if(x<y&&length-2==minpalindrom(x+1, y-1))
					{
						length-=2;
						ret+=(char)(c+'a');
						l = x+1;
						r = y-1;
						break;
					}
				}
				
			}
		}
		
		return odd? ret : ret+flib(ret.toCharArray());
	}
	
	static String flib(char[] a)
	{
		String x = "";
		for (int i = a.length-1; i > -1; i--)
			x += a[i];
		return x;
	}
	
}
