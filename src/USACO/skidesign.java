package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
ID: omarahm1
LANG: JAVA
TASK: skidesign 
*/


public class skidesign {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("skidesign.in"));
		int n = Integer.parseInt(br.readLine());
		long[] hill = new long[n];
		for (int i = 0; i < hill.length; i++) {
			hill[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		// sliding window
		long minCost = Long.MAX_VALUE;
		
		for (long i = 1; i <= 83; i++) {
			
			long cost = 0;
			
			for (int j = 0; j < hill.length; j++) {
				long v = hill[j];
				
				if(v < i) {
					cost += ((i-v)*(i-v));
				} else if (v > i+17) {
					cost += ((v-(i+17))*(v-(i+17)));
				}
			}
			minCost = Math.min(minCost, cost);
		}
		PrintWriter pw = new PrintWriter(new FileWriter("skidesign.out"));
		pw.println(minCost);
		pw.close();
	}

}
