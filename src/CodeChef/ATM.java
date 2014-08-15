package CodeChef;
import java.util.*;
public class ATM {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		double n = sc.nextDouble();
		double balance = sc.nextDouble();
		if(n+0.5>balance||n%5!=0) System.out.printf("%.2f\n",balance);
		else
		{
			System.out.printf("%.2f\n",balance-n-0.5);
		}
		sc.close();
	}

}
