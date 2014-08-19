package Uva;
import java.util.*;
import java.io.*;

public class UVa193 {

	
	static boolean[][] graph = new boolean[110][110];
	static boolean[] dis = new boolean[110];
	static boolean[] vis = new boolean[110];
	static int size ,max=0;
	static int[] arr  = new int[110];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			size = Integer.parseInt(st.nextToken());
			int edges = Integer.parseInt(st.nextToken());
			max = 0;
			for (int j = 0; j <= size; j++)
				for (int j2 = 0; j2 <= size; j2++)
					graph[j][j2] = false;
			
			for (int j = 0; j < edges; j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = graph[b][a] = true ;
			}
			color(1,0);
			pw.println(max);
			for (int j = 0; j < max; j++) {
				pw.print(arr[j]);
				if(j<max-1)
					pw.print(" ");
			}
			pw.println();
		}
		
		
		pw.close();
		br.close();
	}
	
	static void color(int next,int b)
	{
		if(next==size+1)
		{
			if(b>max)
			{
				
				for (int i = 1,idx =0; i <= size; i++) {
					if(dis[i])
						arr[idx++] = i;
				}
				max = b;
			}
			return ;
		}
		// true black
		// false white
		boolean ch_b = false;
		for (int i = 1; i <= size; i++) {
			if(graph[next][i])
				if(dis[i])
				{
					ch_b = true ;
					break;
				}
		}
		
		if(!ch_b)
		{
			dis[next] = true ;
			color(next+1,b+1);
		}
		dis[next] = false;
		color(next+1,b);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
