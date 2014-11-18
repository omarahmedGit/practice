package CF;
import java.util.*;

public class CF_277_5_A {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		int[] fi = new int[n];
		for (int i = 0; i < ar.length; i++) {
			fi[i] = ar[i] = sc.nextInt();
		}
		Arrays.sort(fi);
		sc.close();
		ArrayList<Integer>ii = new ArrayList<Integer>();
		ArrayList<Integer>jj = new ArrayList<Integer>();
		
		for (int i = 0; i < fi.length;i++) {
			if(fi[i]!=ar[i]) {
				//System.out.println(i);
				for (int j = i+1; j < fi.length; j++) {
					if(fi[j]==ar[i]) {
						ii.add(i);
						jj.add(j);
						int temp = fi[i];
						fi[i]=fi[j];
						fi[j]=temp;
						break;
					}
				}
			}
		}
		
		
		int st = ii.size()-1;
		
		System.out.println(ii.size());
		
		for (int i = st; i >=0 ; i--) {
			System.out.printf("%d %d\n",ii.get(i),jj.get(i));
		}
		
		
	}

}
