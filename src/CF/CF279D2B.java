package CF;

import java.util.*;

public class CF279D2B {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		HashMap<Integer, Integer> ha = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> hb = new HashMap<Integer, Integer>();

		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			ha.put(a[i], i);
			hb.put(b[i], i);
		}
		sc.close();

		// form chain 1
		ArrayList<Integer> chain1 = new ArrayList<Integer>();
		int cur = 0;
		while (ha.containsKey(cur)) {
			cur = b[ha.get(cur)];
			if (cur == 0 && chain1.size() != 0)
				break;
			chain1.add(cur);
		}

		// form chain 2
		ArrayList<Integer> chain2 = new ArrayList<Integer>();
		if (n % 2 == 1) {
			for (int i = 0; i < a.length; i++) {
				if (!hb.containsKey(a[i])) {
					cur = a[i];
					break;
				}
			}
			chain2.add(cur);
			while (ha.containsKey(cur)) {
				if (cur == 0 && chain2.size() != 0)
					break;
				cur = b[ha.get(cur)];
				chain2.add(cur);
			}	
		} else {
			cur = 0;
			while (hb.containsKey(cur)) {
				cur = a[hb.get(cur)];
				chain2.add(cur);
			}
		}
		
		if (n % 2 == 0) {
			for (int i = 0, j = chain1.size() - 1; i < chain1.size(); i++, j--) {
				System.out.print(chain2.get(j) + " " + chain1.get(i));
				if (i != chain1.size() - 1)
					System.out.print(" ");
			}
			System.out.println();
		} else {
			for (int i = 0,j=0; i < chain2.size();j++,i++) {
				System.out.print(chain2.get(i));
				if(j<chain1.size()) {
					System.out.print(" "+chain1.get(j));
				}
				if(i!=chain2.size()-1)
					System.out.print(" ");
			}
			System.out.println();
		}
		
		

	}

}
