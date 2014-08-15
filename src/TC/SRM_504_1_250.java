package TC;

public class SRM_504_1_250 {
	public static int countBlack(String ballSequence, int repetitions)
	{
		char[] word = ballSequence.toCharArray();
		int countB = 0;
		
		int start = 0, end = (word.length*repetitions)-1;
		boolean side = true ; // true if pull from start else false
		boolean sameColor = true; // true if the same color
		int num;
		
		while(start<=end)
		{
			num = side ? start++ :end-- ;
			num%=word.length;
			if((word[num]=='B'&&sameColor)|(word[num]=='W'&!sameColor))
			{
				sameColor = !sameColor;
				countB++;
			}
			else {side = !side;}
		}
		return countB;
	}

}
