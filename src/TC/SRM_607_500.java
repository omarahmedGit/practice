package TC;

public class SRM_607_500 {

	static int[][] dp = new int[5001][5001];
	static char[] st ;
	
	public static void main(String args[])
	{
		
		String[] a = {"a","a",""};
		String[] b = {"a"};
		
		System.out.println(check(a,b));
		
		
	}
	static int check(String[] a, String[] b){
		int x = 0;
		int y = 0;
		for (int i = 0; i < 5001; i++) {
			for (int j = 0; j < 5001; j++) {
				dp[i][j]=-1;
			}
		}
		
		st = new char[5001];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length(); j++) {
				st[x++] = a[i].charAt(j);
			}
			pal(y,x-1);
			y+=a[i].length();
		}
		
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length(); j++) {
				st[x++] = b[i].charAt(j);
			}
			pal(y,x-1);
			y+=a[i].length();
		}
		
		return pal(0,y);
	}
	
	static int pal(int i,int j)
	{
		System.out.println(i+" "+ j);
		
		if(j<i)  return 0;
		if(j==i) return dp[i][j] = 1;
		
		if(dp[i][j]!=-1) return dp[i][j];
		
		
		int a , b, c, d;
		a = b= c = d = 0;
		if(st[i]==st[j])
			a = 1+pal(i+1,j-1);
		b = pal(i+1,j);
		c = pal(i,j-1);
		d = pal(i+1,j-1);
		
		
		
		return dp[i][j] = a+b+c-(2*d);
	}

}
