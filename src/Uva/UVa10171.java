package Uva;
import java.util.*;
import java.io.*;

public class UVa10171 {
	static int[][] young = new int[26][26];
	static int[][] old = new int[26][26];
	static int oo = 1000000000;
	static void floyed(int f1,int f2)
	{
		for(int i=0;i<26;i++)
			for(int j=0;j<26;j++)
				for(int k=0;k<26;k++)
					young[j][k] = Math.min(young[j][k],young[j][i]+young[i][k]);

		for(int i=0;i<26;i++)
			for(int j=0;j<26;j++)
				for(int k=0;k<26;k++)
					old[j][k] = Math.min(old[j][k],old[j][i]+old[i][k]);

		int min = oo;
		ArrayList<Character> place = new ArrayList<Character>();
		for (int i=0;i<26;i++) min = Math.min(min,young[f1][i] + old[f2][i]);
		for (int i=0;i<26;i++)
			if(old[f2][i]+young[f1][i]==min)
				place.add((char)(i+'A'));
			
		if(min==oo)
			System.out.println("You will never meet.");
		else{
			System.out.printf("%d ",min);
			for(int i=0;i<place.size();i++)
			{	
				System.out.printf("%c",place.get(i));
				if(i!=place.size()-1)
					System.out.print(" ");
			}
			System.out.println();
		}
			

		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		char a, b, c, d;
		int edges , w, f1,f2;

		while(true)
		{
			edges = Integer.parseInt(br.readLine());
			
			if(edges==0) break;

			for(int i=0;i<26;i++)
				for(int j=0;j<26;j++)
					old[i][j] = young[i][j] = i==j?0:oo;

			

			for (int i=0; i<edges; i++) {
				st = new StringTokenizer(br.readLine());
				a  = st.nextToken().charAt(0);
				b  = st.nextToken().charAt(0);
				c  = st.nextToken().charAt(0);
				d  = st.nextToken().charAt(0);
				w  = Integer.parseInt(st.nextToken());
				
				if(a=='Y')
				{
					young[c-'A'][d-'A'] = Math.min(young[c-'A'][d-'A'],w);
					if(b=='B')
						young[d-'A'][c-'A'] = Math.min(young[d-'A'][c-'A'], w);
				}
				else {
					old[c-'A'][d-'A'] = Math.min(old[c-'A'][d-'A'],w);
					if(b=='B')
						old[d-'A'][c-'A'] = Math.min(old[d-'A'][c-'A'] ,w);
				}
			}
			st = new StringTokenizer(br.readLine());

			f1 = st.nextToken().charAt(0)-'A';
			f2 = st.nextToken().charAt(0)-'A';
			floyed(f1,f2); 

		}
		


		br.close();
	}

}
