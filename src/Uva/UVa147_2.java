package Uva;

public class UVa147_2 {

	public static void main(String[] args) {
		System.out.println(coins(0,2000,"20:"));
	}
	
	
	static int[] coin = {5,10,20,50,100,200,500,1000,2000,5000,10000};
	
	static int coins(int index,int rem,String rs) {
		
		if(rem==0) {
			System.out.println(rs);
			return 1;
		}
		
		if(rem<0||index==coin.length)
			return 0;
		
		int ret = coins(index+1,rem,rs);
		
		
		int val = rem;
		
		while(val>0) {
			val-=coin[index];
			rs = rs+ " " + coin[index];
			ret+=coins(index+1,val,rs);
		}
		
		return ret;
	}

}
