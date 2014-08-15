package CF;

import java.util.Scanner;
import java.util.Stack;

public class CFB_200_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < in.length; i++) {
			if (!s.isEmpty()) {
				if (s.peek() == in[i])
					s.pop();
				else
					s.add(in[i]);
			} else {
				s.add(in[i]);
			}
		}
		
		if(s.isEmpty())
			System.out.println("Yes");
		else
			System.out.println("No");

		sc.close();
	}

}
