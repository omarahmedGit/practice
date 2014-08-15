package Uva;

import java.util.*;

public class UVa10449 {
	static int vertex; static int oo = 1000000000;
	static int[] dis = new int [205];
	static int[] busy = new int [205];
	static boolean[] vis = new boolean[205];
	static boolean[][] graph = new boolean[205][205];
	
	static ArrayList<node> edges = new ArrayList<node>();

	static class node {
		int a, b;

		node(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}

	static boolean relax(int a, int b,boolean mark) {
		if(dis[a]==oo) return false;
		int x = busy[b] - busy[a];
		if (dis[a] + (x * x * x) < dis[b]) {
			vis[b]=mark;
			dis[b] = dis[a] + (x * x * x);
			return true;
		}
		return false;
	}
	
	static void bfs()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		int cur;
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(vis[cur]) continue;
			vis[cur] = true;
			for(int i=1;i<=vertex;i++)
			{
				if(graph[cur][i]&!vis[i])
					q.add(i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size, a, b, t = 1;
		try {
			while (sc.hasNext()) {
				edges = new ArrayList<node>();
				vertex = sc.nextInt();
				for (int i = 1; i < 205; i++) {
					dis[i] = oo;
					vis[i] = false;
				}
				for (int i = 1; i <= vertex; i++) {
					busy[i] = sc.nextInt();
				}
				size = sc.nextInt();
				for (int i = 0; i < size; i++) {
					a = sc.nextInt();
					b = sc.nextInt();
					edges.add(new node(a, b));
					graph[a][b] = true;
				}
				dis[1] = 0;
				bellmanford();
				System.out.printf("Set #%d\n", t++);
				int queries = sc.nextInt();
				while (queries-- > 0) {
					int test = sc.nextInt();
					if(dis[test]==oo|| vis[test] ||dis[test]<3)
						System.out.println('?');
					else
						System.out.println(dis[test]);
				}
			}

			sc.close();
		} catch (Exception e) {

		}
	}

	static void bellmanford() {
		boolean change;
		node cur;
		for (int i = 0; i < vertex; i++) {
			change = false;
			for (int j = 0; j < edges.size(); j++) {
				cur = edges.get(j);
				if (relax(cur.a, cur.b,false))
					change = true;
			}
			if (!change)
				break;
		}
		
		for (node x : edges) relax(x.a, x.b,true);
	}

}
