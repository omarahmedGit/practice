package Uva;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Uva12442 {
	static int[] next = new int[50001];
	static int[] coast = new int[50001];
	static boolean[] vis = new boolean[50001];
	static boolean[] cycle = new boolean[50001];
	static int[] tim = new int[50001];
	
	static int N,a,b,curr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testCases = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < testCases; i++) {
			N = Integer.parseInt(br.readLine());
			
			for (int j = 0; j < N; j++) {
				cycle[j+1]= vis[j+1] = false; // reset
				coast[j+1]= tim[j+1] = 0;
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				next[a] = b;
			}
			email(i+1);
			
		}
		
		br.close();
	}
	
	static int checkmail(int mail,int timer)
	{
		if(vis[mail])
		{
			// cycle or already calculated
			if(coast[mail]==0)
			{
				//cycle
				int nxt = mail;
				int val = timer-tim[mail];
				while(!cycle[nxt])
				{
					cycle[nxt] = true;
					coast[nxt] = val;
					nxt = next[nxt];
				}
			}
			else
			{
				return coast[mail];
			}
		}
		vis[mail] = true;
		tim[mail] = timer;
		int ret = checkmail(next[mail], timer+1);
		if(cycle[mail]) return coast[mail];
		return coast[mail] = ret+1;
	}
	
	static void email(int C)
	{
		
		curr = 1;
		int count = 0,maxCount = 0,m=0;
		while(curr<=N)
		{
			if(vis[curr]) {curr++; continue;}
			count = checkmail(curr,1);
			if(count>maxCount)
			{
				maxCount = count;
				m = curr;
			}
			curr++;
		}
		
		System.out.printf("Case %d: %d\n",C,m);
		
	}
	

}
