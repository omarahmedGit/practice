package CF;
import java.util.*;
public class CFA_214 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] a = new int[4][4];
		boolean d = false;
		for (int i = 0; i < 4; i++) {
			a[i][0]= sc.nextInt();
			a[i][1]= sc.nextInt();
			a[i][2]= sc.nextInt();
			a[i][3]= sc.nextInt();
		}
		
		for (int i = 0; i < 4; i++) {
			int b = Math.min(a[i][0], a[i][1]);
			int c = Math.min(a[i][2], a[i][3]);
			if(b+c<=n)
			{
				System.out.printf("%d %d %d\n",i+1,b,n-b);
				d = true;
				break;
			}
		}
		if(!d)
			System.out.println(-1);
		
		sc.close();
	}

}
