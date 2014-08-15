package Uva;
import java.util.*;
import java.io.*;

public class UVa967 {
	static int msize = 1010;
	static boolean[] pri = new boolean[1000010];
	static boolean[] ch = new  boolean[1000010];
	static int[] precal = new int[1000010];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		prime();
		precal();
		
		int a,b ;
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			if(st.countTokens()==1) break;
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if(a>0) a--;
			int sol = precal[b]-precal[a];
			if(sol==0)
				pw.println("No Circular Primes.");
			else if(sol==1)
				pw.printf("1 Circular Prime.\n");
			else
				pw.printf("%d Circular Primes.\n",sol);
		}
		pw.close();br.close();
	}
	
	static void precal()
	{
		for (int i = 2; i < 1000010; i++) {
			if(!pri[i])
			{
				if(!ch[i])
				{
					check(i);
				}
			}
		}
		
		for (int i = 1; i <= 1000000; i++) {
			precal[i] = precal[i-1]+(ch[i]?1:0);
		}
	}

	private static boolean check(int i) {
		char[] a = Integer.toString(i).toCharArray();
		for (int idx = 0; idx < a.length; ++idx) {
			int num = 0;
			int xx = 1;
			for (int j = 0,k=idx; j < a.length; j++) {
				num += (xx*(a[k]-'0'));
				xx*=10;
				k--;
				if(k<0)
					k = a.length-1;
			}
			if(pri[num])
			{
				return false;
			}
		}
		
		for (int idx = 0; idx < a.length; ++idx) {
			int num = 0;
			int xx = 1;
			for (int j = 0,k=idx; j < a.length; j++) {
				num += (xx*(a[k]-'0'));
				xx*=10;
				k--;
				if(k<0)
					k = a.length-1;
			}
			ch[num] = true ;
		}
		
		return true;
	}

	static void prime() {
		pri[0] = pri[1] = true ;
		for (int i = 2; i* i < 1000000; i++) {
			if (!pri[i])
				for (int j = i* i; j < 1000000; j += i) {
					pri[j] = true;
				}
		}
	}

}
