package Uva;
import java.util.*;
public class UVA147 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int COINS = 11, MAX_COINS = 30000+1;
		long[][] mem = new long[COINS][MAX_COINS];
		
		int[] coins = {5,10,20,50,100,200,500,1000,2000,5000,10000} ;
		
		for (int i = 0; i < coins.length; i++) {
			mem[i][0] = 1;
		}
		
		
		for (int coin = coins[0]; coin < MAX_COINS; coin+=5) {
			for (int j = 0; j < coins.length; j++) {
				if(j!=0)
					mem[j][coin] = mem[j-1][coin];
				if(coin-coins[j]>=0)
					mem[j][coin]+= mem[j][coin-coins[j]];
			}
		}

		while(true)
		{
			double d = sc.nextDouble();
			int x =(int) (d*100);
			if(x==0) break ;
			int i = (x)-(int)d;
			int j = x/100;
			String s = mem[10][x]+"";
//			for (int f = 0; s.length() < 17; f++) {
//				s = " "+ s;
//			}
			System.out.printf("%3d.%2d%s\n",j,i,s);
			
		}
		
		sc.close();
	}

}
