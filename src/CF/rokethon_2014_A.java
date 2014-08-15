package CF;

import java.util.*;

public class rokethon_2014_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] input = sc.next().toCharArray();
		int count = 0, c = 1;
		for (int i = 1; i < input.length; i++) {
			if (input[i] == input[i - 1]) {
				c++;
				if (i == input.length - 1 && c % 2 == 0)
					count++;
			} else {
				if (i == input.length - 1 & c % 2 == 0) {
					count++;
					continue;
				}
				if (c % 2 == 0)
					count++;
				c = 1;
			}
		}
		if (input.length == 2 & count == 1)
			count = 2;
		if (input.length == 1)
			count = 1;
		System.out.println(count);

		sc.close();
	}

}
