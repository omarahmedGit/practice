package Uva;
import java.util.*;
public class Uva10827 {
	/*
	 * copy N*N to N*2N and perform simple 2D array max sum
	 */
	static int wid = 77*2,size;
	static long[][] read = new long[wid][wid];
	static long[][] sum = new long[wid][wid];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while(testcases-->0)
		{
			size = sc.nextInt();
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					read[i][j] = sc.nextLong();
					read[i][j+size] = read[i][j];
					read[i+size][j] = read[i][j];
					read[i+size][j+size] = read[i][j];
				}
			}
			System.out.println(sumOntours());
		}
		sc.close();
	}
	
	static long sumOntours()
	{
		for (int i = 0; i < 2*size; i++) {
			for (int j = 0; j < 2*size; j++) {
				sum[i][j] = read[i][j];
				if(i>0) sum[i][j] += sum[i-1][j];
				if(j>0) sum[i][j] += sum[i][j-1];
				if(i>0 & j>0) sum[i][j] -= sum[i-1][j-1];
			}
		}
		long max = Long.MIN_VALUE;
		long val ;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				for (int i2 = i; (i2-i<size) & i2 < 2*size; i2++) {
					for (int j2 = j; (j2-j<size) & j2 < 2*size; j2++) {
						val = sum[i2][j2];
						if(i>0) val -= sum[i-1][j2];
						if(j>0) val -= sum[i2][j-1];
						if(i>0 & j>0) val += sum[i-1][j-1];
						max = Math.max(val, max);
					}
				}
			}
		}
		return max;
	}
}
