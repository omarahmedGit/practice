package TC;

import java.util.Arrays;

public class TC_500_250 {

	public static void main(String[] args) {
		int[] a = {10, 11, 12, 13, 14, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		System.out.println(maxTurns(a));
	}
	
	
	public static int maxTurns(int[] cards)
	{
		Arrays.sort(cards);
		int turns = 0;
		for(int i=0;i<cards.length;i++)
		{
			if(i<cards.length-1)
				if(cards[i]+1==cards[i+1])
					i++;
			turns++;
		}
		
		
		return turns;
	}

}
