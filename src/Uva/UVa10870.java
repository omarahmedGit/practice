package Uva;
import java.io.*;
import java.util.*;
public class UVa10870 {
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int d,n;
		ArrayList<Integer> ar,dr ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			if(st.countTokens()==0) break;
			d = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			ar = new ArrayList<Integer>();
			dr = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < d; i++)
				ar.add(Integer.parseInt(st.nextToken()));
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < d; i++)
				dr.add(Integer.parseInt(st.nextToken()));
			
			if(n<=d)
			{
				System.out.println(dr.get(n-1));
				continue ;
			}
			
			Matrix p = new Matrix(d);
			
			
			for(int i=0;i<d;i++)
				p.mat[0][i] = ar.get(i);
			
			for (int i = 1; i < d; i++)
				for (int j = 0; j < d; j++)
					p.mat[i][j] = ((i-1)==j)?1:0;
			
			Matrix mat = matPow(p,n-d+1);
			
			
			long sol  = 0;
			for (int i = 0; i < d; i++) {
				sol = (sol + (((mat.mat[0][i]%m)*(dr.get(d-i-1))%m)%m))%m;
			}
			System.out.println(sol);
		}
		
		
		
		
		pw.close();
		br.close();
	}
	
	
	public static class Matrix {
		long[][] mat ;
		int m ;
		Matrix(int size) {
			m = size;
			mat = new long[m][m];
		}
	}
	
	
	static Matrix matMul(Matrix a, Matrix b)
	{
		Matrix ans = new Matrix(a.m);
		
		for (int i = 0; i < ans.m; i++) {
			for (int j = 0; j < ans.m; j++) {
				for (int k = 0; k < ans.m; k++) {
					if(k==0) ans.mat[i][j] = 0;
					ans.mat[i][j]= (ans.mat[i][j] + (((a.mat[i][k]%m)*(b.mat[k][j]%m))%m))%m;
				}
			}
		}
		return ans;
	}
	
	static Matrix matPow(Matrix base, int p)
	{
		Matrix ans  = new Matrix(base.m);
		for (int i = 0; i < ans.m; i++)
			for (int j = 0; j < ans.m; j++)
				ans.mat[i][j] = (i==j)?1:0;
		
		
		while(p!=0)
		{
			if((p&1)==1)
				ans = matMul(ans,base);
			base = matMul(base, base);
			p>>=1;
		}
		
		return ans;
	}

}
