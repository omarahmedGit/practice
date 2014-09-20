package CF;

import java.util.*;

public class CF256_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		sc.close();
		int[] _a = new int[26];
		int[] _b = new int[26];

		// check for need tree

		for (int i = 0; i < a.length; i++) {
			_a[a[i] - 'a']++;
		}

		for (int i = 0; i < b.length; i++) {
			_b[b[i] - 'a']++;
		}
		boolean needTree = false;
		for (int i = 0; i < _b.length; i++) {
			if (_a[i] < _b[i]) {
				needTree = true;
				break;
			}
		}

		if (needTree) {
			System.out.println("need tree");
			return;
		}

		// Check for automation only
		boolean automation = false;
		for (int i = 0; ((i + b.length - 1) < a.length) & (i < a.length); i++) {
			if (a[i] == b[0]) {
				int count = 0;
				for (int j = 0, k = i; k<a.length & j < b.length;) {
					if (a[k] == b[j]) {
						count++;
						j++;
						k++;
					} else {
						k++;
					}
				}
				if (count==b.length) {
					automation = true;
					break;
				}
			}
		}

		if (automation) {
			System.out.println("automaton");
		} else if (a.length == b.length) {
			System.out.println("array");
		} else {
			System.out.println("both");
		}

	}

}
