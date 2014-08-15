package TC;
/*
 * http://community.topcoder.com/stat?c=problem_statement&pm=12794
 */
public class SRM595DIV2_250 {
	
	public static int getNumber(String s)
	{
		char[] input = s.toCharArray();
		int l=0,counter=0;
		char last='R';
		for(int i=0;i<input.length;i++)
		{
			if(i==0)
			{
				last = input[counter++];
			}
			else
			{
				if(input[i]==last)
					counter++;
				else
				{
					if(counter>l) l=counter;
					counter =1;
					last=input[i];
				}
			}
		}
		if(counter>l) l=counter;
		return input.length-l;
	}
}
