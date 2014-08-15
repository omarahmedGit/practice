package TC;
import java.util.Arrays;

/*
 * http://community.topcoder.com/stat?c=problem_statement&pm=12836
 */

public class SRM596DIV2_250 {
	
	public static void main(String[] args) {
		int[] test = {2,-3,5,7,-11,-13,17,-19,23,29,-31,-37,-41,43,-47,-53,-59,61,-67,71};
		System.out.println(getMin(test));
	}
	
	
	public static int getMin(int[] in)
	{
		int min = Integer.MAX_VALUE;
		
		for(int i=1;i+1<in.length;i++)
			min = Math.min(min, (int)skip(in,i));
		
		return min;
	}
	
	public static long skip(int[] in,int index)
	{
		long sum = 0;
		int[] work = new int[in.length-1];
		
		for(int i=0,j=0;i<in.length;i++)
			if(i!=index) work[j++]=in[i];
		System.out.println(Arrays.toString(work));
		for(int i=0;i+1<work.length;i++)
			sum += Math.abs(work[i]-work[i+1]);
		
		return sum;
	}
	
	
	
	
}
