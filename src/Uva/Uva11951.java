package Uva;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Uva11951 {
	static long[][] prises = new long[105][105];
	static int n,m,kk,tt;
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int testcases = Integer.parseInt(st.nextToken());
		for (tt = 0; tt < testcases; tt++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			kk = Integer.parseInt(st.nextToken());
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					prises[i][j] = Long.parseLong(st.nextToken());
				}
			}
			area();
		}
		
		br.close();
	}
	
	
	static void area()
	{
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(i>0) prises[i][j] += prises[i-1][j];
				if(j>0) prises[i][j] += prises[i][j-1];
				if(i>0 && j>0) prises[i][j] -= prises[i-1][j-1];
			}
		}
		long maxarea = 0;
		long pri = 0;
		for (int i = 0; i < n; i++) {
			
			int prearea1 = (n-i)*(m);
			if(prearea1<maxarea) break; 
			
			for (int j = 0; j < m; j++) {
				
				int prearea2 = (n-i)*(m-j);
				if(prearea2<maxarea) break;
				
				for (int j2 = i; j2 < n; j2++) {
					for (int k = j; k < m; k++) {
						long sum = prises[j2][k];
						
						if(i>0) sum -= prises[i-1][k];
						if(j>0) sum -= prises[j2][j-1];
						if(i>0 & j>0) sum += prises[i-1][j-1];
						
						int areaval = (Math.abs(i-j2)+1) * (Math.abs(j-k)+1);
						if(areaval>=maxarea&&sum<=kk)
						{
							if((maxarea==areaval&&sum<pri)|(maxarea!=areaval))
								pri = sum;
							
							maxarea = areaval;
						}
					}
				}
			}
		}
		
		
		System.out.printf("Case #%d: %d %d\n",tt+1,maxarea, pri);
		
		
	}
	

}
