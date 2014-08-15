package Uva;
import java.io.*;

public class UVa11401 {
	static long[] S = new long[1000010];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		count();
		while(true)
		{
			String r = br.readLine();
			int n = Integer.parseInt(r);
			if(n==0) break;
			pw.println(S[n]);
		}
		
		pw.close();
		br.close();
	}
	
	
	
	static void count()
	{
		S[3] = 0;
		S[4] = 1;
		for(int i=5; i<=1000000; i++)
		{
		      long b = i/2+1;
		      long R = i*(i-1)-(i+1)*(i-b)-b*(b-1);
		      S[i] = S[i-1] + R;
		}
	}

}
