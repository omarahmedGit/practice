package Uva;
import java.util.*;
import java.io.*;
public class UVa10489 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		while(n-->0)
		{
			st = new StringTokenizer(br.readLine());
			int friends = Integer.parseInt(st.nextToken());
			int bigbox = Integer.parseInt(st.nextToken());
			long product = 1,allp = 0;
			for (int i = 0; i < bigbox; i++) {
				product = 1;
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				for (int j = 0; j < k ;j++) {
					int a = Integer.parseInt(st.nextToken());
					product = ((product%friends)*(a%friends))%friends;
				}
				allp =((allp%friends)+(product%friends))%friends;
			}
			
			pw.println(allp%friends);
		}
		
		
		pw.close();
		br.close();
	}

}
