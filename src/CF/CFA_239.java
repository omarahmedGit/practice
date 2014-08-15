package CF;
import java.util.*;
public class CFA_239 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int queues = sc.nextInt();
		int[] p = new int[queues];
		
		int[] sol = new int[queues];
		for(int i=0;i<queues;i++) p[i] = sc.nextInt();
		
		for (int i = 0; i < sol.length; i++) {
			int b = 0;
			for (int j = 0; j < p[i]; j++) {
				b = b + sc.nextInt();
			}
			sol[i] = (b*5) + (p[i]*15);
		}
		
		Arrays.sort(sol);
		
		
		System.out.println(sol[0]);
		sc.close();
	}

}
