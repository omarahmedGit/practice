package CF;
import java.util.*;

public class CF271_D2_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char off = sc.next().charAt(0);
		char[] in = sc.next().toCharArray();
		char[] keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./".toCharArray();
		int[] index = new int[256];
		
		for (int i = 0; i < keyboard.length; i++) {
			index[keyboard[i]] = i;
		}
		
		
		
		int idx = off=='R'?-1:1;
		
		for (int i = 0; i < in.length; i++) {
			System.out.print(keyboard[index[in[i]]+idx]);
		}
		System.out.println();
		
		sc.close();
	}

}
