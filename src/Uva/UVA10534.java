package Uva;
import java.util.*;
public class UVA10534 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] p1 = new int[10003];
		int[] p2 = new int[10003];
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			ArrayList<Integer> ar = new ArrayList<Integer>();
			ArrayList<Integer> m = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				ar.add(a);
				int pos = Collections.binarySearch(m, a );
				if(pos<0) pos = -(pos + 1);
				if(pos==m.size()) m.add(a);
				else m.set(pos, a);
				p1[i] = pos+1;
			}
			m = new ArrayList<Integer>();
			for (int i = n-1; i >= 0; i--) {
				int a = ar.get(i);
				int pos = Collections.binarySearch(m, a );
				if(pos<0) pos = -(pos + 1);
				if(pos==m.size()) m.add(a);
				else m.set(pos, a);
				p2[i] = pos+1;
			}
			int max = 1;
			for (int i = 0; i < n;i++) {
				max = Math.max(max,(Math.min(p1[i], p2[i])*2)-1);
			}
			System.out.println(max);
		}
		
		sc.close();
	}

}
