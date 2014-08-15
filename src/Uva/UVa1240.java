package Uva;

import java.io.*;
import java.util.StringTokenizer;

public class UVa1240 {
	static int[][] val = new int[3][15];
	static int[][][] dp = new int[3][4100][281];
	static int problems;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			problems = Integer.parseInt(st.nextToken());
			
			
			for (int j = 0; j < 3; j++) {
				st = new StringTokenizer(br.readLine());
				for (int j2 = 0; j2 < problems; j2++) {
					val[j][j2] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int j = 0; j < 3; j++) {
				for (int j2 = 0; j2 < 281; j2++) {
					for (int k = 0; k < 4100; k++) {
						dp[j][k][j2] = -1;
					}
				}
			}
			
			pw.println(team(-1, 0, 280));
		}

		pw.close();
		br.close();

	}

	static int team(int pla, int p, int time) {
		if (time == 0 || (p+1)==(1<<problems))
			return 0;
		
		if(pla!=-1&&dp[pla][p][time]!=-1) return dp[pla][p][time]; 

		int max = 0;

		for (int i = 0; i < 3; i++) {
			if (i != pla)
				for (int j = 0; j < problems; j++) {
					int calc = time - val[i][j];
					if ((p & (1 << j)) == 0 & calc >= 0)
						max = Math.max(max, 1+team(i, p|(1 << j), calc));
				}
		}

		if(pla!=-1) dp[pla][p][time] = max;
		return  max;
	}

}
