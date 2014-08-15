package Uva;
import java.util.*;
import java.io.*;

public class UVa259 {
	static int[][] res = new int[38][38];
	static int mf , s=0 , t=37, f , oo=1000000000 ;
	static Vector<Integer> p = new Vector<Integer>();

	static void agument(int v , int minEdge)
	{
		if(v==s){
			f = minEdge;
			return ;
		} else if(p.get(v)!=-1) {
			agument(p.get(v),Math.min(minEdge,res[p.get(v)][v]));
			res[p.get(v)][v] -= f;
			res[v][p.get(v)] += f;
		}
	}

	static void edmondKarp()
	{
		mf = 0;

		while(true)
		{
			f = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			Vector<Integer> dis = new Vector<Integer>();
			q.add(s);
			dis.addAll(Collections.nCopies(38,oo));
			dis.set(s,0);
			p.clear();
			p.addAll(Collections.nCopies(38,-1));

			while(!q.isEmpty())
			{
				int u = q.poll();
				if(u==t) break;

				for (int i=1;i<38;i++) {
					if(res[u][i]>0&&dis.get(i)==oo)
					{
						dis.set(i,dis.get(u)+1);
						q.add(i);
						p.set(i,u);
					}
				}	
			}
			agument(t,oo);
			if(f==0) break;
			mf+=f;
		}
	}
	static void reset()
	{
		for(int i=0;i<38;i++)
			for(int j=0;j<38;j++)
				res[i][j] = 0;
		for(int i=27;i<37;i++)
			res[i][37] = 1;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		PrintWriter pw  = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		String read ;
		char[] a , b;
		int c=0 , target =0;
		reset();
		while(true)
		{
			if(c==2) break;
			read = br.readLine();
			if(read==null||read.length()==0) {
				c++;
				if(c==1)
				{
					edmondKarp();
					if(mf!=target)
						pw.println('!');
					else {
						for (int i=27;i<37;i++) {
							for (int j=1;j<27;j++) {
								if(res[i][j]==1)
								{
									pw.print((char)(j-1+'A'));
									break;
								}
								if(j==26)
									pw.print('_');
							}
						}
						pw.println();
					}	
				}
				target = 0;
				reset();
				continue;
			}
			c=0;
			st = new StringTokenizer(read);
			a = st.nextToken().toCharArray();
			res[0][a[0]-'A'+1]=a[1]-'0';
			target +=(a[1]-'0');
			b = st.nextToken().toCharArray();
			for (int i=0;i<b.length-1;i++) {
				res[a[0]-'A'+1][b[i]-'0'+27] = oo;	
			}
		}
		pw.close();
		br.close();
	}

}
