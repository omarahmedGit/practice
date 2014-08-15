package Uva;

import java.util.*;
import java.io.*;

public class UVa10803 {
	static int[][] pos = new int[105][2];
	static double[][] adj = new double[105][105];
	static int s, oo = 1000000;

	static void min() {
		for (int i = 0; i < s; i++)
			for (int j = 0; j < s; j++)
				adj[i][j] = oo;

		int x, y;
		int dis;
		for (int i = 0; i < s; i++) {
			for (int j = i; j < s; j++) {
				x = Math.abs(pos[i][0] - pos[j][0]);
				y = Math.abs(pos[i][1] - pos[j][1]);
				dis = (x * x) + (y * y);
				if (dis > 100)
					adj[i][j] = adj[j][i] = oo;
				else
					adj[i][j] = adj[j][i] = Math.sqrt(dis);
			}
		}
		for (int k = 0; k < s; k++)
			for (int i = 0; i < s; i++)
				for (int j = 0; j < s; j++)
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    value = value * factor;
	    long tmp = Math.round(value);
	    return (double) tmp / factor;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int t = sc.nextInt();
		int x, y;
		for (int i = 0; i < t; i++) {
			s = sc.nextInt();
			for (int j = 0; j < s; j++) {
				x = sc.nextInt();
				y = sc.nextInt();
				pos[j][0] = x;
				pos[j][1] = y;
			}

			min();
			double max = 0;

			for (int j = 0; j < s; j++) {
				for (int j2 = j + 1; j2 < s; j2++) {
					max = Math.max(max, adj[j][j2]);
				}
			}
			pw.printf("Case #%d:\n", i + 1);

			if (max >= oo)
				pw.print("Send Kurdy\n\n");
			else {
				pw.printf("%.4f\n\n", round(max,4));
			}
		}
		sc.close();
		pw.close();
	}

}
