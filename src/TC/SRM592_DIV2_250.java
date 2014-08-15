package TC;
import java.util.Arrays;


public class SRM592_DIV2_250 {
	public static void main(String[] args) {
		int[] a = {1,2};
		System.out.println(getNumber(a, 1));
	}
	public static int getNumber(int[] pages,int number)
	{
		Arrays.sort(pages);
		int sum = 0;
		for (int i = 0; i+1< number;i++) sum+=pages[i];
		sum+=pages[number];
		return sum;
	}
}
