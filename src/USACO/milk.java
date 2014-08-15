package USACO;
/*
ID: omarahm1
LANG: JAVA
TASK: milk 
*/
import java.io.*;
import java.util.*;
public class milk {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("milk.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("milk.out"));
		int need = sc.nextInt();
		int seller = sc.nextInt();
		node[] input = new node[seller];
		int a ,b;
		for (int i = 0; i < seller; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			input[i] = new node(a,b);
		}
		Arrays.sort(input);
		
		int n = need;
		int ans = 0, idx =0;
		while(n>0)
		{
			if(n>input[idx].amount)
			{
				n-=input[idx].amount;
				ans+=(input[idx].cost*input[idx].amount);
				idx++;
			}
			else
			{
				ans +=(input[idx].cost*n);
				n = 0;
			}
		}
		sc.close();
		pw.println(ans);
		pw.close();
	}
	
	public static class node implements Comparable<node>
	{
		int cost;
		int amount;
		
		public node(int co,int am)
		{
			cost = co;
			amount = am;
		}
		
		public int compareTo(node a)
		{
			return this.cost-a.cost;
		}
	}

}
