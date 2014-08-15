package Uva;
import java.util.*;
import java.io.*;
public class UVa12160 {
	static int l,u,r;
	static int[] bottons = new int[10];
	static boolean[] visited = new boolean[10000];
	static int[] weight = new int[10000];
	static void bfs()
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(l);
		int cur, v;
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			
			for (int i = 0; i < r; i++) {
				v = (cur + bottons[i])%10000;
				if (!visited[v]&weight[v]==0) {
					weight[v] = weight[cur]+1;
					q.add(v);
				}
			}
		}
		if(!visited[u])
			System.out.println("Permanently Locked");
		else
			System.out.println(weight[u]);

	}
	
	static void reset()
	{
		for (int i = 0; i < 10000; i++) {
			visited[i] =false;
			weight[i] =0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = 1;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			l = Integer.parseInt(st.nextToken());
			u = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			
			if(l==0&r==0&u==0) break;
			
			reset();
			st = new StringTokenizer(br.readLine());
			
			for (int i=0; i<r; i++) {
				bottons[i] = Integer.parseInt(st.nextToken());
			}
			
			System.out.printf("Case %d: ",t++);
			bfs();
		}
		br.close();
	}

}
