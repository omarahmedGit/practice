package Uva;
import java.util.*;
import java.io.*;

public class UVa104 {
	static double[][] input = new double[20][20];
	static double[][] sol 	= new double[20][20];
	static int[][] parent 	= new int[20][20];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int size ;
		String line;
		while((line=br.readLine())!=null)
		{
			st = new StringTokenizer(line);
			size = Integer.parseInt(st.nextToken());
			for (int i=0;i<size;i++)
				for (int j=0;j<size;j++)
					{
						parent[i][j] = i;
						sol[i][j] = 0;
					}
			for (int i=0;i<size;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<size;j++)
				{
					if(j==i)
						input[i][i] = 1.0;
					else
						input[i][j] = Double.parseDouble(st.nextToken());
				}
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(parent[i][j]+" ");
				}
				System.out.println();
			}
			
			for(int i=0;i<size;i++)
				for(int j=0;j<size;j++)
					for(int k=0;k<size;k++)
					{
						if(sol[j][k]<input[j][i]*input[i][k])
						{
							sol[j][k]=input[j][i]*input[i][k];
							parent[j][k] = parent[i][k];
						}
					}

			for (int i=0;i<size;i++) {
				for (int j=0;j<size;j++) {
					System.out.printf("%.3f ",sol[i][j]);
				}
				System.out.println();
			}
			
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					System.out.print(parent[i][j]+" ");
				}
				System.out.println();
			}
			

		}




		br.close();
	}
	
	static void print(int i,int j)
	{
		if(i!=j) print(i,parent[i][j]);
		System.out.print(j+" ");
	}
	
	
}
