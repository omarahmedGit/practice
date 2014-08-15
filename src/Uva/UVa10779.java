package Uva;

import java.io.*;
import java.util.*;

public class UVa10779 {
	static int types ;
	static int max , k_n ;
	static int[][] arr = new int[15][30];
	static int friends ;
	static boolean[] dup = new boolean[15];
	static int[] disc = new int[15];
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < t; i++) {
			max = 0;
			for (int j = 0; j < 15; j++) {
				for (int j2 = 0; j2 < 30; j2++) {
					arr[i][j] = 0;
				}
			}
			st = new StringTokenizer(br.readLine());
			friends = Integer.parseInt(st.nextToken());
			types = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < friends; j++) {
				st = new StringTokenizer(br.readLine());
				int k = Integer.parseInt(st.nextToken());
				for (int k2 = 0; k2 < k; k2++) {
					int a = Integer.parseInt(st.nextToken());
					arr[j][a-1]++;
					disc[j] = 1<<(a-1);
				}
			}
			k_n = count_types();
			for (int j = 1; j < friends; j++) {
				check_dup(j);
			}
			search();
			pw.printf("Case #%d: %d\n",i+1,max);
		}
		pw.close();
		br.close();
	}

	static void check_dup(int x)
	{
		for (int i = 0; i < types; i++) {
			if(arr[x][i]>1){
				dup[x] = true;
				return ;
			}
		}
		dup[x]=false;
	}

	static int count_types()
	{
		int count = 0;
		for (int i = 0; i < types; i++) {
			if(arr[0][i]>0) count++;
		}
		return count ;
	}
	static void search()
	{
		max = Math.max(max, k_n);
		if(max==types) return ;
		
		for (int i = 1; max<types &&i < friends; i++) {
			if((disc[0]&(disc[0]^disc[i]))==0)
				continue ;
				
			
			if(!dup[i]) continue;
			for (int j = 0; max<types &&j < types; j++) {
				if(arr[i][j]==0&&arr[0][j]>1)
				{
					for (int j2 = 0; j2 < types; j2++) {
						if(arr[i][j2]>1&&arr[0][j2]<friends)
						{
							if(arr[0][j2]==0) k_n++;
							arr[i][j]++;
							arr[i][j2]--;
							arr[0][j]--;
							arr[0][j2]++;
							
							disc[0] = (disc[0] | (1<<j2));
							disc[i] = (disc[i] | (1<<j));
							
							check_dup(i);
							search();
							if(arr[0][j2]==1) k_n--;
							arr[i][j]--;
							arr[i][j2]++;
							arr[0][j]++;
							arr[0][j2]--;
							if(arr[0][j2]==0) disc[0] = (disc[0] ^ (1<<j2));
							if(arr[i][j]==0) disc[i] = (disc[i] ^ (1<<j));
							check_dup(i);
						}
					}
				}
			}
		}
	}

}
