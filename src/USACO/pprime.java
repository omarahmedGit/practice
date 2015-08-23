package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
/*
 ID: omarahm1
 LANG: JAVA
 TASK: pprime 
 */
public class pprime {
	static ArrayList<Integer> pri,sol;

	static void generatePrimes() {
		boolean[] p = new boolean[10000];
		p[0] = p[1] = true;
		pri = new ArrayList<Integer>();
		
		for (int i = 2; i < 10000; i++) {
			if (!p[i]) {
				pri.add(i);
				for (int j = 2 * i; j < p.length; j += i) {
					p[j] = true;
				}
			}
		}
	}
	static int valofarr(int[] n) {
		int val = 0;
		int pos = 1;
		for (int i = n.length-1; i > -1; i--) {
			val += n[i]*pos;
			pos*=10;
		}
		return val;
	}
	
	
	static void generatePlaindrom(int idx,int[] n) {
		if(((n.length%2==0)&&(idx==(n.length/2)+1)) || ((n.length%2==1)&&(idx==(n.length/2)+2))) {
			int val = valofarr(n);
			if(checkPrime(val)) sol.add(val);
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			n[idx-1] = n[n.length-(idx-1)-1] = i;
			generatePlaindrom(idx+1, n);
		}
	}
	
	
	static boolean checkPrime(int x) {
		if(x==1) return false;

		for (int i = 0; i < pri.size(); i++) {
			int next = pri.get(i);
			if(next==x) return true;
			if(x%next==0) return false;
		}
		return true;
	}
	
	
	
	static boolean isPalindrome(int x) {		
		char[] n = Integer.toString(x).toCharArray();
		
		for (int i = 0,j=n.length-1; i < j; j--,i++) {
			if(n[i]!=n[j])
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) throws IOException {
		generatePrimes();
		
		BufferedReader br = new BufferedReader(new FileReader("pprime.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		br.close();
		
		sol = new ArrayList<Integer>();
		
		for (int i = 1; i <= 8; i++) {
			generatePlaindrom(1, new int[i]);
		}
		
		Collections.sort(sol);
		
		int pos1 = Collections.binarySearch(sol, a);
		int pos2 = Collections.binarySearch(sol, b);
		
		if(pos1<0) pos1 = Math.abs(pos1+1);
		if(pos2<0) pos2 = Math.abs(pos2+1)-1;
		
		if(pos1==sol.size()) --pos1;
		
		PrintWriter pw = new PrintWriter(new FileWriter("pprime.out"));
		for (int i = pos1; i <= pos2; i++) {
			pw.println(sol.get(i));
		}		
		pw.close();
		
		
	}

}
