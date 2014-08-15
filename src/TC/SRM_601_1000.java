package TC;

public class SRM_601_1000 {

	public static void main(String[] args) {
		String[] aa = {"x"};
		String[] bb = {"x","y"};
		String[] cc = {"x"};
		
		System.out.println(getNumber(aa, bb, cc));
	}
	
	
	public static int  getNumber(String[] aa, String[] bb,String[] cc)
	{
		String x = "",y="",z="";
		for (int i = 0; i < aa.length; i++) {
			x+=aa[i];
		}
		a = x.toCharArray();
		for (int i = 0; i < bb.length; i++) {
			y+=bb[i];
		}
		b = y.toCharArray();
		for (int i = 0; i < cc.length; i++) {
			z+=cc[i];
		}
		c = z.toCharArray();
		
		resetdp();
		
		
		return max(0,0,0);
	}
	
	public static void resetdp()
	{
		for (int i = 0; i < 2500; i++) {
			for (int j = 0; j < 2500; j++) {
				for (int j2 = 0; j2 < 2500; j2++) {
					dp[i][j][j2] = -1;
				}
			}
		}
	}
	
	static char[] a,b,c;
	static int[][][] dp = new int[2501][2501][2501]; // java Out of Memory heap ...
	public static int max(int i,int j, int k)
	{
		if(i>=a.length|j>=b.length|k>=c.length)
			return 0;
		
		
		if(a[i]==b[j]&&b[j]==c[k])
			return dp[i][j][k] = 1+max(i+1,j+1,k+1);
		
		int ch1 =0,ch2=0,ch3=0;
		
		if(a[i]==c[k])
			ch1 = max(i,j+1,k);
		else if(b[j]==c[k])
			ch2 = max(i+1,j,k);
		
		for (int l = 0; l < c.length; l++) {
			if(l==k+1) ch3 = Math.max(ch3, 1+max(i,j,k+1));
			else ch3 = Math.max(ch3, max(i, j, l+1));
		}
		
		return dp[i][j][k] = Math.max(ch1, Math.max(ch2, ch3));
	}

}
