package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
ID: omarahm1
LANG: JAVA
TASK: numtri 
*/


public class numtri {
	static int[][] dp , data;
	static int n;
	
	static int path(int i,int j) {
		if(i==n) return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		return dp[i][j] = data[i][j]+Math.max(path(i+1,j),path(i+1,j+1));
	}
	
	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new FileReader("numtri.in"));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dp[i], -1);
		}
		data = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int co = st.countTokens();
			for (int j = 0; j < co; j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		int res = path(0,0);
		PrintWriter pw = new PrintWriter(new FileWriter("numtri.out"));
		pw.println(res);
		pw.close();
		
	}

}
