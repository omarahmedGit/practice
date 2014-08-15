package Uva;
import java.math.BigInteger;
import java.util.*;
public class UVA10198 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger[] big = new BigInteger[1001];
		Arrays.fill(big, BigInteger.ZERO);
		big[0] = BigInteger.valueOf(1);
		big[1] = BigInteger.valueOf(2);
		big[2] = BigInteger.valueOf(5);
		big[3] = BigInteger.valueOf(13);
		
		for (int i = 4; i < big.length; i++) {
			big[i] = big[i].add(big[i-1]);
			big[i] = big[i].add(big[i-1]);
			big[i] = big[i].add(big[i-2]);
			big[i] = big[i].add(big[i-3]);
		}
		
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			System.out.println(big[n]);
		}
		
		sc.close();
	}
}
