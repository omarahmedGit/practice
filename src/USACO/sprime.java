package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/*
ID: omarahm1
LANG: JAVA
TASK: sprime 
*/

public class sprime {
	static ArrayList<Integer> pri,sol;
	static int n;
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
	
	static void add(int idx,int x) {
		if(idx==n) {
			sol.add(x);
			return ;
		}
		
		x*=10;
		
		if(idx==0) add(1,2);
		
		for (int i = 1; i <= 9; i+=2) {
			int np = x+i;
			if(checkPrime(np)) add(idx+1,np);
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
	
	public static void main(String[] args) throws IOException {
		generatePrimes();
		BufferedReader br = new BufferedReader(new FileReader("sprime.in"));
		n = Integer.parseInt(br.readLine());
		br.close();
		sol = new ArrayList<Integer>();
		add(0,0);
		Collections.sort(sol);
		
		PrintWriter pw = new PrintWriter(new FileWriter("sprime.out"));
		
		for (int i = 0; i < sol.size(); i++) {
			pw.println(sol.get(i));
		}
		
		pw.close();
		
	}

}
