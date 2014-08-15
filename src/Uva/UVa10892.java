package Uva;
import java.util.*;
import java.io.*;
public class UVa10892 {

	static int gcd(int a,int b)
	{
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	
	static int lcm(int a,int b)
	{
		return a*(b/gcd(a,b));
	}
	
	static long div(int n)
	{
		int x = (int)Math.sqrt(n);
		ArrayList<Integer> di = new ArrayList<Integer>();
		for (int i = 1; i <= x; i++) {
			if(n%i==0)
			{
				di.add(i);
				if(i!=n/i) di.add(n/i);
			}
		}
		long count = 0;
		for (int i = 0; i < di.size(); i++) {
			for (int j = i; j < di.size(); j++) {
				if(lcm(di.get(i),di.get(j))==n)
					count++;
			}
		}
		return count ;
	}
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n==0) break;
			pw.printf("%d %d\n",n,div(n));
		}
		
		pw.close();
		br.close();
	}
	
	
	
	

}
