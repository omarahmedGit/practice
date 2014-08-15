package Uva;
import java.util.*;
import java.io.*;

public class UVa820 {

	static int[][] res = new int[101][101];
	static int mf , s , t, f , oo = 2000000000;
	static ArrayList<Integer> p = new ArrayList<Integer>();


	static void agument(int v ,int minEdge)
	{
		if(v==s) {
			f = minEdge;
			return ;
		} else if(p.get(v)!=-1) {
			agument(p.get(v),Math.min(minEdge, res[p.get(v)][v]));
			res[p.get(v)][v]-=f;
			res[v][p.get(v)]+=f;
		}
	}

	static int edmondKarp(int vertex)
	{
		int cur ;
		mf = 0;
		while(true)
		{
			f = 0;
			Queue <Integer> q 	= new LinkedList<Integer>();
			Vector<Integer> dis	= new Vector<Integer>();
			dis.addAll(Collections.nCopies(vertex+1, oo));
			q.add(s);
			dis.set(s,0);
			p.clear();
			p.addAll(Collections.nCopies(vertex+1,-1));

			while(!q.isEmpty())
			{
				cur = q.poll();
				if(cur==t) break;
				for (int i=1;i<=vertex;i++) {
					if(res[cur][i]>0&dis.get(i)==oo)
					{
						dis.set(i,dis.get(cur)+1);
						q.add(i);
						p.set(i,cur);
					}
				}
			}
			agument(t,oo);
			if(f==0) break;
			mf+=f;
		}
		return mf;
	}
	static void reset()
	{
		for(int i=0;i<101;i++)
			for(int j=0;j<101;j++)
				res[i][j]=0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int vertex , a, b , c, w , num=1;
		while(true)
		{
			vertex = Integer.parseInt(br.readLine());
			if(vertex==0) break;
			reset();
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			for (int i=0;i< c; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				w = Integer.parseInt(st.nextToken());
				res[a][b] +=w;
				res[b][a] += w;
			}
			int bandwidth = edmondKarp(vertex);
			pw.printf("Network %d\n",num++);
			pw.printf("The bandwidth is %d.\n\n",bandwidth);
		}
		pw.close();
		br.close();
	}

}
