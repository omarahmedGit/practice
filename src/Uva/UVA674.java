package Uva;
import java.util.*;

public class UVA674 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] coins = { 1, 5, 10, 25, 50 };
		long[] ways = new long[7489+1];
		ways[0]=1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = coins[i]; j < ways.length; j++) {
				ways[j] += ways[j-coins[i]];
			}
		}
		
		while(sc.hasNext())
		{
			int x = sc.nextInt();
			System.out.println(ways[x]);
		}
		
		sc.close();
	}

}
