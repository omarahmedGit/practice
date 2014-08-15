package Uva;
import java.util.*;
public class UVA11456 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			
			ArrayList<Integer> l= new ArrayList<Integer>();
			int[] p1= new int[2001];
			int[] p2= new int[2001];
			
			for (int j = 0; j < n; j++) {
				arr[j] = sc.nextInt();
			}
			
			for (int j = n-1; j > -1; j--) {
				int pos = Collections.binarySearch(l, -arr[j]);
				if(pos<0) pos = -(pos+1);
				
				if(pos==l.size()) l.add(-arr[j]);
				else l.set(pos, -arr[j]);
				
				p1[j] = pos+1;
			}
			l = new ArrayList<Integer>();
			for (int j = n-1; j > -1; j--) {
				int pos = Collections.binarySearch(l, arr[j]);
				if(pos<0) pos = -(pos+1);
				
				if(pos==l.size()) l.add(arr[j]);
				else l.set(pos,arr[j]);
				
				p2[j] = pos+1;
			}
			int max = 0;
			for (int j = 0; j < n; j++) {
				max = Math.max(max, (p1[j]+p2[j]-1));
			}
			
			System.out.println(max);
		}
		sc.close();
	}

}
