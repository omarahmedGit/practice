package CF;
import java.util.*;
public class CFA_211 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String[] a = new String[10];
		a[0]="O-|-OOOO";
		a[1]="O-|O-OOO";
		a[2]="O-|OO-OO";
		a[3]="O-|OOO-O";
		a[4]="O-|OOOO-";
		a[5]="-O|-OOOO";
		a[6]="-O|O-OOO";
		a[7]="-O|OO-OO";
		a[8]="-O|OOO-O";
		a[9]="-O|OOOO-";
		String in = sc.next();
		char[] b = in.toCharArray();
		for(int i=b.length-1;i>=0;i--)
		{
			System.out.println(a[(int)(b[i]-'0')]);
		}
		sc.close();

	}

}
