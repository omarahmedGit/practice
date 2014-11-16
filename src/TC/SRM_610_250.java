package TC;
import java.util.*;

public class SRM_610_250 {
	static ArrayList<Integer> numbers ;
	static boolean[] vis ;
	static boolean check ;

	public static void main(String args[])
	{
		//int[] a = {6,2,18};
		System.out.println(1);
	}

	public static int CountNumbers(int[] a)
	{
		numbers = new ArrayList<Integer>();
		vis = new boolean[101];
		for(int i=0;i<a.length;i++){
			vis[a[i]] = true;
			numbers.add(a[i]);
		}
		

		vis[0] = true;
		check = true;
		while(check)
		{
			redo();
		}

		return numbers.size();
	}


	public static void redo()
	{
		check = false;
		for (int i=0; i<numbers.size();i++) {
			for(int j=0;j<numbers.size();j++)
			{
				if(i!=j)
				{
					int d = numbers.get(i)/numbers.get(j);
					if(!vis[d])
					{
						numbers.add(d);
						vis[d] = true;
						check = true;
					}
				}
			}
		}
	}

}