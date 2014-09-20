package CF;

import java.util.*;
import java.io.*;

public class CF250_D2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] nani = new int[nodes];
		for (int i = 0; i < nodes; i++) {
			nani[i] = Integer.parseInt(st.nextToken());
		}
		
		dsu dsu = new dsu(nodes);
		
		for (int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			dsu.merge(a-1, b-1);
		}
		
		long count = 0;
		long sum = 0;
		for (int i = 0; i < nodes; i++) {
			for (int j = i+1; j < nodes; j++) {
				if(dsu.isInTheSameSet(i, j)) {
					count++;
					sum+=Math.min(nani[i], nani[j]);
				}
			}
		}
		
		double d = ((double)sum) / ((double)count);
		System.out.printf("%.6f\n",d);
		
		br.close();
	}

	public static class dsu {
		int[] parent;

		dsu(int x) {
			parent = new int[x];
			for (int i = 0; i < x; i++)
				parent[i] = i;
		}

		int find(int a) {
			if (parent[a] == a)
				return a;
			return parent[a] = find(parent[a]);
		}

		void merge(int a, int b) {
			parent[find(a)] = find(b);
		}

		boolean isInTheSameSet(int a, int b) {
			return find(a) == find(b);
		}
	}
}
