package Uva;
import java.util.*;
import java.io.*;
public class UVA10100 {
	static ArrayList<String> a,b;
	static int[][] dp = new int[1001][1001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int idx =1;
		while((line=br.readLine())!=null)
		{
			a = parse(line);
			String d = br.readLine();
			b = parse(d);
			for (int i = 0; i < a.size(); i++) {
				for (int j = 0; j < b.size(); j++) {
					dp[i][j] =-1;
				}
			}
			int sol = LCS(0,0);
			System.out.printf("%2d. ",idx++);
			if(sol==0&&(line.length()==0|d.length()==0))
				System.out.println("Blank!");
			else
				System.out.printf("Length of longest match: %d\n",sol);
		}
		
		br.close();
	}
	
	
	static ArrayList<String> parse(String line)
	{
		char[] l = line.toCharArray();
		ArrayList<String> sol = new ArrayList<String>();
		String v ="";
		for (char x: l) {
			if((x>64&&x<91)||(x>96&&x<123)||(x>47&&x<58))
			{
				v = v+x;
			}
			else
			{
				if(v.length()>0)
					sol.add(v);
				v="";
			}
		}
		if(v.length()>0)
			sol.add(v);
		return sol;
	}
	
	static int LCS(int i,int j)
	{
		if(i==a.size()||j==b.size())
			return 0;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		String a1 = a.get(i);
		String a2 = b.get(j);
		
		if(a1.equals(a2))
			return dp[i][j] = 1+LCS(i+1,j+1);
		
		int ch1 = LCS(i+1,j);
		int ch2 = LCS(i,j+1);
		
		
		
		return dp[i][j] =  Math.max(ch1, ch2);
	}
	

}
