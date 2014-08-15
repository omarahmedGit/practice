package Uva;
import java.util.*;
import java.io.*;

public class UVa924 {

	static ArrayList<ArrayList<Integer>> graph  = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited  = new boolean[2500];
	static int[] weight = new int[2500];
	static int[] levels = new int[2500];
	static int nodes ;

	static void bfs(int source)
	{
		int max = 0 , max_level = 0;

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		int cur;
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(visited[cur]) continue;
			visited[cur] = true;
			int size = graph.get(cur).size();
			for (int i=0; i<size; i++) {
				int x = graph.get(cur).get(i);
				if(!visited[x]&weight[x]==0)
				{
					weight[x] = weight[cur]+1;
					q.add(x);
					levels[weight[x]]++;
				}
			}
		}
		for (int i=0; i<nodes; i++) {
			if(levels[i]>max)
			{
				max = levels[i];
				max_level = i;
			}
		}
		if(max==0) System.out.println(0);
		else System.out.println(max+" "+max_level);
	}

	static void reset()
	{
		for (int i =0; i<nodes; i++) {
			visited[i] = false;
			weight[i] = 0;
			levels[i] = 0;
		}
	}




	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		for(int i=0;i<2500;i++){
			graph.add(new ArrayList<Integer>());
		}

		nodes = Integer.parseInt(br.readLine());
		int a , b;
		for (int i=0; i<nodes; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			for (int j=0; j< a; j++) {
				b = Integer.parseInt(st.nextToken());
				graph.get(i).add(b);
			}
		}
		int test_cases = Integer.parseInt(br.readLine());
		for (int i=0; i<test_cases; i++) {
			a = Integer.parseInt(br.readLine());
			reset();
			bfs(a);
		}

		pw.close();
		br.close();
	}





}
