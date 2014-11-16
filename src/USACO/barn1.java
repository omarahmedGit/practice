package USACO;
import java.io.*;
import java.util.*;

/*
ID: omarahm1
LANG: JAVA
TASK: barn1 
*/
public class barn1 {
	static int boards,stalls,caws;
	static boolean[] staff;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("barn1.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("barn1.out"));
		
		boards = sc.nextInt();
		stalls = sc.nextInt();
		caws = sc.nextInt();
		staff = new boolean[stalls];
		for (int i = 0; i < caws; i++) {
			int a = sc.nextInt();
			staff[a-1] = true;
		}
		if(caws<=boards)
		{
			pw.println(caws);
			sc.close();
			pw.close();
			return ;
		}
		int mystart =0;
		for (int i = 0; i < staff.length; i++) {
			if(staff[i])
			{
				for (int j = i+1; j < staff.length; j++) {
					if(!staff[j])
					{
						mystart = j;
						break;
					}
				}
				break;
			}
		}
		boolean chk = false; // false means i'm in the staff of true area
		int s=0;
		ArrayList<node> per = new ArrayList<node>();
		for (int i = mystart; i < staff.length; i++) {
			if(!chk&&!staff[i])
			{
				chk = true;
				s = i;
			}
			else if(chk&&staff[i])
			{
				chk = false;
				per.add(new node(s,i-s));
			}
		}
		Collections.sort(per);
		if(isVal())
		{
			pw.println(getCovered());
			sc.close();
			pw.close();
			return ;
		}
		for (int i = 0; i < per.size(); i++) {
			cover(per.get(i));
			if(isVal())
			{
				pw.println(getCovered());
				break;
			}
		}
		sc.close();
		pw.close();
	}
	
	public static boolean isVal()
	{
		int counter = 0;
		boolean ch = false;
		for (int i = 0; i < staff.length; i++) {
			if(!ch&&staff[i])
			{
				ch = true;
				counter++;
			}
			else if(ch&&!staff[i])
			{
				ch = false;
			}
		}
		return counter>boards?false:true;
	}
	
	public static int getCovered()
	{
		int count =0;
		for (int i = 0; i < staff.length; i++) {
			if(staff[i]) count++;
		}
		return count;
	}
	
	static void cover(node a)
	{
		for (int i = a.id; i < a.n+a.id; i++) {
			staff[i] = true;
		}
	}
	
	
	public static class node implements Comparable<node>
	{
		int id;
		int n; //range
		public node(int a,int b)
		{
			id = a;
			n = b;
		}
		public int compareTo(node a)
		{
			return this.n-a.n;
		}
	}
}
