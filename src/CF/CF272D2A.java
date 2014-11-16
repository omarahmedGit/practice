package CF;
import java.util.*;
public class CF272D2A {
	static int min = 100000;
	static int[][] dp = new int[10005][10];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int d = n%2==0? n/2 : (n/2)+1;
		boolean flag = false;
		
		while(d%m!=0) {
			d++;
			if(d>n) {
				flag = true;
				break;
			}
		}
		
		if(flag)
			System.out.println(-1);
		else
			System.out.println(d);
		
		sc.close();
	}
}
