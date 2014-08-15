package Uva;
import java.util.*;
import java.io.*;
public class UVa429 {
	static ArrayList<ArrayList<Integer>> graph ;
	static ArrayList<String> dictionary ;
	static boolean[] vis = new boolean[210];
	static int[] dis = new int[210] ;
	static int oo = 1000000000;
	static int s ;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Hashtable<String, Integer> hash ;
		
		int t = Integer.parseInt(st.nextToken());
		br.readLine();
		String line;
		for (int i = 0; i < t; i++) {
			hash = new Hashtable<String,Integer>();
			graph = new ArrayList<ArrayList<Integer>>();
			dictionary = new ArrayList<String>();
			int idx = 0;
			while((line=br.readLine()).charAt(0)!='*'){
				dictionary.add(line);
				hash.put(line, idx);
				idx++;
			}
			
			s = dictionary.size();
			
			make_graph();
			if(i!=0)
				pw.println();
			while((line=br.readLine())!=null&&line.length()>0)
			{
				st = new StringTokenizer(line);
				String from = st.nextToken();
				String to = st.nextToken();
				pw.printf("%s %s %d\n",from,to,bfs(hash.get(from),hash.get(to)));
			}
		}
		
		
		
		pw.close();
		br.close();
	}
	
	
	static void make_graph()
	{
		int size = dictionary.size();
		for (int i = 0; i < size; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		char[] a1,a2;
		for (int i = 0; i < size; i++) {
			a1 = dictionary.get(i).toCharArray();
			for (int j = i+1; j < size; j++) {
				a2 = dictionary.get(j).toCharArray();
				if(a1.length==a2.length)
				{
					int dif = 0;
					for (int k = 0; k < a1.length; k++) {
						if(a1[k]!=a2[k]) dif++;
					}
					if(dif==1)
					{
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
					
				}
			}
		}
	}
	
	static int bfs(int source,int e)
	{
		for (int i = 0; i < s; i++) {
			dis[i] = oo;
			vis[i] = false;
		}
		
		dis[source] = 0;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		
		while(!q.isEmpty())
		{
			int cur = q.poll();
			if(cur==e) break;
			if(vis[cur]) continue;
			vis[cur] = true ;
			
			for (int next: graph.get(cur)) {
				if(dis[next]==oo){
					dis[next] = dis[cur]+1;
					q.add(next);
				}
			}
		}
		return dis[e];
	}
	
	
}
