package CF;
import java.util.*;
public class CFA_238 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int size = sc.nextInt();

		int[] down = new int[size];
		int[] right = new int[100];
		int max = 0;
		for (int i=0;i<size;i++) {
			down[i] = sc.nextInt();
			max = Math.max(down[i], max);
			for (int j=0;j<down[i];j++) {
				right[j]++;
			}
			down[i] = 0;
		}
		
		for (int j=max-1; j>=0; j--) {
			for(int i=0;i<right[j];i++)
			{
				if(down[size-1-i]==0)
					down[size-1-i] = j+1;
			}
		}
		
		for(int i=0;i<size;i++)
		{
			System.out.print(down[i]);
			if(i!=size-1)
				System.out.print(" ");
		}
		System.out.println();
		




		sc.close();
	}

}
