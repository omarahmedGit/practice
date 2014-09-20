package CF;

import java.util.*;
import java.io.*;

public class CF250_C2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int nodes = Integer.parseInt(st.nextToken());
		int edges = Integer.parseInt(st.nextToken());

		int[] n_w = new int[nodes];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < nodes; i++) {
			n_w[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<ArrayList<Integer>> gr = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < nodes; i++)
			gr.add(new ArrayList<Integer>());
		
		for (int i = 0; i < edges; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			gr.get(a - 1).add(b - 1);
			gr.get(b - 1).add(a - 1);
		}
		
		PriorityQueue<Pair> p = new PriorityQueue<Pair>();
		for (int i = 0; i < nodes; i++) {
			p.add(new Pair(i,n_w[i]));
		}
		boolean[] vis = new boolean[nodes];
		long sum = 0;
		
		while(!p.isEmpty()) {
			Pair cur = p.poll();
			if(vis[cur.idx])
				continue;
			vis[cur.idx] = true;
			ArrayList<Integer> ni = gr.get(cur.idx); 
			for (int i = 0; i < ni.size(); i++) {
				int index = ni.get(i);
				if(!vis[index]) {
					sum+=n_w[index];
				}
			}
		}
		
		System.out.println(sum);
		br.close();
	}

	public static class Pair implements Comparable<Pair> {
		int idx;
		int w;

		public Pair(int idx, int w) {
			this.idx = idx;
			this.w = w;
		}

		public int compareTo(Pair o) {
			return o.w - this.w;
		}
	}
}
