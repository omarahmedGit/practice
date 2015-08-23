package CF;
import java.util.*;
public class CF281D2B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		long suma = 0,sumb = 0;
		boolean last = true;
		for (int i = 0; i < n; i++) {
			int inn = sc.nextInt();
			if(inn<0) {
				b.add((-1*inn));
				sumb-= inn;
			} else {
				a.add(inn);
				suma+=inn;
			}
			if(i==n-1) {
				if(inn<0) {
					last = false;
				}
			}
 		}
		sc.close();
		
		
		if(suma==sumb) {
//			Collections.sort(a);
//			Collections.sort(b);

			if(a.size()>b.size()) {
				for (int i = 0; i < b.size(); i++) {
					if(a.get(i)>b.get(i)) {
						System.out.println("first");
						return ;
					} else if(a.get(i)<b.get(i)) {
						System.out.println("second");
					}
				}
				
			} else if (a.size()<b.size()) {
				for (int i = 0; i < a.size(); i++) {
					if(a.get(i)>b.get(i)) {
						System.out.println("first");
					} else if(a.get(i)<b.get(i)) {
						System.out.println("second");
						return ;
					}
				}
			} else {
				boolean t = false;
				for (int i = 0; i < b.size(); i++) {
					if(a.get(i)>b.get(i)) {
						System.out.println("first");
						return;
					} else if(a.get(i)<b.get(i)) {
						System.out.println("second");
						return ;
					}
				}
				if(!t) {
					if(last) {
						System.out.println("first");
					} else {
						System.out.println("second");
					}
					return;
				}
				
			}
			
			
			
			
		} else if(suma>sumb) {
			System.out.println("first");
		} else {
			System.out.println("second");
		}
		
		
	}

}
