package CF;
import java.util.*;
public class CF255_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		int max = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			boolean check = false;
			for (int j = 0; j < k; j++) {
				int x = sc.nextInt();
				if(x<max) check = true ;
			}
			if(check)
				list.add(i+1);
		}
		
		System.out.println(list.size());
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
			if(i!=list.size()-1)
				System.out.print(" ");
		}
		
		
		sc.close();
	}

}
