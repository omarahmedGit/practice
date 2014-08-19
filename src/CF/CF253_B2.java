package CF;
import java.util.*;
public class CF253_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] arr = sc.next().toCharArray();
		int n = sc.nextInt();
		sc.close();
		if(n>arr.length)
		{
			if((n%2)==(arr.length%2))
				System.out.println(n+arr.length);
			else
				System.out.println(n+arr.length-1);
			return ;
		}
		
		char[] str = new char[arr.length+n];
		for (int i = 0; i < arr.length; i++) {str[i] = arr[i];}
		
		int max = 1;
		
		for (int i = 0; i+n-1 < arr.length; i++) {
			for (int j = arr.length,k=0; k<n ;k++,j++) {
				str[j] = arr[i+k];
			}
			max = Math.max(max, getMax(str));
		}
		
		System.out.println(max);
		
	}
	
	
	public static int getMax(char[] str)
	{
		
		int max = 1;
		for (int i = 1; i < str.length; i++) {
			boolean check = false;
			for (int j = 0; j-1+(2*i) < str.length; j++) {
				check = true;
				for (int j2 = j,k=0; (k<i)&j2 < str.length; k++,j2++) {
					if(str[j2]!=str[j2+i]){
						check = false;
						break;
					}
				}
				if(check)
					max= i;
			}
		}
		return max*2;
	}

}
