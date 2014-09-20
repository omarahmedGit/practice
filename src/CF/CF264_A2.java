package CF;
import java.util.*;

public class CF264_A2 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt()*100;
		int sol = -1;
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = (a*100)+b;
			if(c<=s){
				int _sol = (s-c)%100;
				if(_sol>sol)
					sol = _sol;
			}
		}
		
		System.out.println(sol);
		
		sc.close();
	}

}
