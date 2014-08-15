package CF;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CFA_FF {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		boolean[] hash = new boolean[350];
		
		
		int p = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int in , sol = -1 ;
		boolean ch = true;
		for (int i = 0; i < n; i++) {
			in = Integer.parseInt(br.readLine());
			if(hash[in%p]&&ch){
				sol = i+1;
				ch = false;
			}
			else
				hash[in%p] = true;
		}
		
		pw.println(sol);
			
		
		pw.close();
		br.close();
	}

}
