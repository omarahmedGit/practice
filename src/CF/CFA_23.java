package CF;
import java.util.*;
public class CFA_23 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] str = sc.next().toCharArray();
		
		char[] arr = new char[str.length];
		
		for(int i=0;i<str.length;i++)
			arr[i] = str[i];
		
		int max = 0,count = 0;
		
		for (int i = 0; i < str.length; i++) {
			
			for (int j = i+1; j < str.length; j++) {
				if(str[i]==arr[j])
				{
					count = 0;
					boolean checkequ = true ;
					for (int j2 = j, i2 = i; checkequ & j2 < arr.length; i2++,j2++) {
						if(str[i2]==arr[j2])
							count++;
						else checkequ = false;
					}
					max = Math.max(max, count);
				}
			}
		}
		System.out.println(max);
		
		sc.close();
	}

}
