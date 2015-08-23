package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/*
 ID: omarahm1
 LANG: JAVA
 TASK: combo 
 */

public class combo {
	static int f1, f2, f3, m1, m2, m3, n;

	static boolean abs(int a, int b, int c) {
		int min, max, countf = 0, countm = 0;
		max = Math.max(a, f1);
		min = Math.min(a, f1);
		if (Math.abs(a - f1) <= 2 || Math.abs(min + n - max) <= 2)
			countf++;

		max = Math.max(b, f2);
		min = Math.min(b, f2);
		if (Math.abs(b - f2) <= 2 || Math.abs(min + n - max) <= 2)
			countf++;

		max = Math.max(c, f3);
		min = Math.min(c, f3);
		if (Math.abs(c - f3) <= 2 || Math.abs(min + n - max) <= 2)
			countf++;

		max = Math.max(a, m1);
		min = Math.min(a, m1);
		if (Math.abs(a - m1) <= 2 || Math.abs(min + n - max) <= 2)
			countm++;

		max = Math.max(b, m2);
		min = Math.min(b, m2);
		if (Math.abs(b - m2) <= 2 || Math.abs(min + n - max) <= 2)
			countm++;

		max = Math.max(c, m3);
		min = Math.min(c, m3);
		if (Math.abs(c - m3) <= 2 || Math.abs(min + n - max) <= 2)
			countm++;

		return ((countf == 3) || (countm == 3)) ? true : false;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("combo.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("combo.out"));

		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		f1 = Integer.parseInt(st.nextToken());
		f2 = Integer.parseInt(st.nextToken());
		f3 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		m1 = Integer.parseInt(st.nextToken());
		m2 = Integer.parseInt(st.nextToken());
		m3 = Integer.parseInt(st.nextToken());

		int solutions = 0;

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				for (int j2 = 1; j2 <= n; j2++)
					if (abs(i, j, j2))
						++solutions;

		pw.println(solutions);

		br.close();
		pw.close();
	}

}
