package faceBookHackerCup;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class SqaureDetector {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("probA.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("outprobA.txt"));
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			boolean[][] sq = new boolean[n][n];
			for (int j = 0; j < n; j++) {
				char[] line = sc.next().toCharArray();
				for (int j2 = 0; j2 < n; j2++) {
					sq[j][j2]=line[j2]=='#'?true:false;
				}
			}
			
			int hlx = -1,hly=-1,hry=-1;
			boolean block = true;
			for (int j = 0; j < sq.length; j++) {
				for (int j2 = 0; j2 < sq.length; j2++) {
					if(block)
					{
						if(sq[j][j2]&&hlx==-1)
						{
							hlx = j;
							hly = j2;
						}
						else if(j2==n-1&&sq[j][j2])
						{
							hry = j2;
							block = false;
						}
						else if(!sq[j][j2]&&hlx!=-1)
						{
							hry = j2-1;
							block = false;
						}
					}
				}
			}
			if((hry-hly+1+hlx>n)||(hlx==-1))
			{
				pw.printf("Case #%d: NO\n",i+1);
				continue ;
			}
			boolean[][] tester = new boolean[n][n];
			for (int j = hlx; j <= hry-hly+hlx; j++) {
				for (int j2 = hly; j2 <= hry; j2++) {
					tester[j][j2] = true;
				}
			}
			boolean b = true;
			for (int j = 0; j < n; j++) {
				for (int j2 = 0; j2 < n; j2++) {
					if(b&sq[j][j2]!=tester[j][j2])
					{
						pw.printf("Case #%d: NO\n",i+1);
						b = false;
					}
				}
			}
			if(b)
				pw.printf("Case #%d: YES\n",i+1);
		}
		sc.close();
		pw.close();
	}

}
