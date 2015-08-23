package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
ID: omarahm1
LANG: JAVA
TASK: crypt1 
*/

public class crypt1 {
	static boolean[] on = new boolean[10];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("crypt1.out"));
		StringTokenizer st ;
		int n = Integer.parseInt(br.readLine());
		int[] digits = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			digits[i] = Integer.parseInt(st.nextToken());
			on[digits[i]] = true;
		}
		
		pw.println(generateSolutions(digits));
		br.close();
		pw.close();
	}
	
	static int generateSolutions(int[] di) {
		int solutions = 0;
		
		for (int i = 0; i < di.length; i++) {
			for (int j = 0; j < di.length; j++) {
				for (int j2 = 0; j2 < di.length; j2++) {
					
					
					for (int k = 0; k < di.length; k++) {
						for (int k2 = 0; k2 < di.length; k2++) {
							
							int a = di[i]+(di[j]*10)+(di[j2]*100);
							//int b = di[k]+(di[k2]*10);
							int p1 = a*di[k];
							int p2 = (a*di[k2])*10;
							int fi = p1+p2;
							
							/*
							System.out.println(a);
							System.out.println(b);
							System.out.println(p1);
							System.out.println(p2);
							System.out.println(fi);
							*/
							
							
							if(p1<1000&&p2<10000&&fi<10000) {
								if(check(p1)&&check(p2/10)&&check(fi)) {
									solutions++;
								}
							}

						}
					}
					
					
				}
			}
		}
		
		
		return solutions;
	}

	private static boolean check(int x) {
		
		while(x>0) {
			int mod = x%10;
			if(!on[mod]) return false;
			x/=10;
		}
		
		return true;
	}

}
