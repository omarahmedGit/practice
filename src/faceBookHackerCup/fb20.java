package faceBookHackerCup;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class fb20 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("a.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("aout.txt"));
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int C = sc.nextInt();
			int ans = coins(N,K,C);
			pw.printf("Case #%d: %d\n",i+1,ans);
		}
		sc.close();
		pw.close();
	}
	
	static int coins(int n, int k ,int c)
	{
		
		if(n==1)
			return c;
		
		if(n==2)
		{
			if(c!=k)
				return c;
			else
				return k%2==0?c:c+1;
		
		}
		if(k<=n)
			return n-(k-c);
		
		
		if(k>n&&k<(n*2)-1)
		{
			if(c<n+1) return c;
			return 1+coins(n-1,k,c);
		}
		
		if(k==(n*2)-1)
		{
			if(c<=n) return c;
			return c+1;
		}
		
		
		if(k%n==0)
			return c;
		
		int div = k/n;
		div*=n;
		
		if(c>div)
			return c+1;
		
		return c;
	}

}
