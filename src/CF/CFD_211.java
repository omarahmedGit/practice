package CF;
import java.util.*;
public class CFD_211 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int bo = sc.nextInt();
		int bi = sc.nextInt();
		int spare = sc.nextInt();
		
		int[] boy = new int[bo];
		int[] bik = new int[bi];
		for (int i = 0; i < bo; i++) boy[i] = sc.nextInt();
		for (int i = 0; i < bi; i++) bik[i] = sc.nextInt();
		Arrays.sort(boy);
		Arrays.sort(bik);
		
		
		int low = 0, high =Math.min(bo, bi) , ans = low;
		for (int i = 0; i < 50; i++) {
			int mid = (low+high)/2;
			boolean check = true;
			int s2 = spare;
			for (int j = bo-mid,k=0; j < bo; j++) {
				if(k==bi) 
				{
					check = false;
					break;
				}
				if(boy[j]<bik[k]&&s2+boy[j]>=bik[k])
				{
					s2 -= bik[k]-boy[j];
					k++;
				}
				else if(boy[j]>=bik[k])
				{
					k++;
				}
				else
				{
					check = false;
					break;
				}
			}
			if(check)
			{
				low = mid+1;
				ans = mid;
			}
			else
			{
				high = mid;
			}
		}
		int c = 0;
		for (int i = 0; i < ans; i++) {
			c += bik[i];
		}
		System.out.println(ans+" "+Math.max(c-spare, 0));
		sc.close();

	}

}
