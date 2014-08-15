package Uva;
import java.io.*;
import java.util.StringTokenizer;
public class Uva10739 {
	static char[] word;
	static int[][] dp = new int[1001][1001];
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testcases = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < testcases; i++) {
			st = new StringTokenizer(br.readLine());
			word = st.nextToken().toCharArray();
			resetDP(word.length);
			pw.printf("Case %d: %d\n",i+1,palindrome(0, word.length-1));
		}
		br.close();
		pw.close();
	}
	
	public static void resetDP(int max_length)
	{
		for (int i = 0; i <= max_length; i++) {
			for (int j = 0; j < max_length; j++) {
				dp[i][j] = -1;
			}
		}
	}
	
	static int palindrome(int i , int j)
	{
		if(i>=j)
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		
		int ch1 = palindrome(i+1, j-1) + (word[i]==word[j]?0:1);
		int ch2 = palindrome(i, j-1) +1;
		int ch3 = palindrome(i+1, j) +1;
		
		return dp[i][j] = Math.min(ch1, Math.min(ch2,ch3));
	}

}
