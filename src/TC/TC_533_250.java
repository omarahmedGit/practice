package TC;

public class TC_533_250 {

	public static void main(String[] args) {
		int[] a = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(maxEnergy(a));
	}
	
	static int[] enr;
	static int[][] dp = new int[55][55];
	public static int maxEnergy(int[] a)
	{
		enr = a;
		for (int i = 0; i < 55; i++) {
			for (int j = 0; j < 55; j++) {
				dp[i][j] = -1;
			}
		}
		return energy(0,a.length-1);
	}
	
	
	public static int energy(int s,int e)
	{
		if(s+1==e||s==e)
			return 0;
		if(dp[s][e]!=-1) return dp[s][e];
		
		int power = enr[s]*enr[e];
		int max = -1;
		for (int i = s+1; i < e; i++) {
			max = Math.max(max, power+energy(s,i)+energy(i,e));
		}
		
		return dp[s][e] = max;
	}
	
	

}
