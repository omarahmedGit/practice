package CF;

import java.util.*;

public class CFA_231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] input = sc.next().toCharArray();

		int a = 0, b = 0, c = 0;
		boolean ch = false, ch_2 = false;
		for (int i = 0; i < input.length; i++) {
			if (input[i] == '|' & !ch)
				a++;
			if (input[i] == '|' & ch & !ch_2)
				b++;
			if (input[i] == '+')
				ch = true;
			if (input[i] == '=')
				ch_2 = true;
			if (input[i] == '|' & ch_2)
				c++;
		}

		if (c == a + b) {
			for (int i = 0; i < input.length; i++) {
				System.out.print(input[i]);
			}
			
			System.out.println();
		} else if (c != (a + b) & Math.abs((a + b) - c) == 2) {
			if (c > (b + a)) {
				c--;
				b++;
			} else {
				c++;
				if(b>a)b--;
				else a--;
			}
			for (int i = 0; i < a; i++) {
				System.out.print('|');
			}
			System.out.print('+');
			for (int i = 0; i < b; i++) {
				System.out.print('|');
			}
			System.out.print('=');
			for (int i = 0; i < c; i++) {
				System.out.print('|');
			}
			System.out.println();	
		} else {
			System.out.println("Impossible");
		}

		sc.close();
	}

}
