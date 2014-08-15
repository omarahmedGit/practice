package faceBookHackerCup;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class fb15 {
	static char[] a;
	static long b;
	static ArrayList<Character> sol;
	static PrintWriter pw ;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileReader("a.txt"));
		pw = new PrintWriter("aout.txt");
//		System.out.println(Long.MAX_VALUE);
		// 9223372036854775807
		int testcases = sc.nextInt();
		for (int i = 0; i < testcases; i++) {
			a = sc.next().toCharArray();
			b = sc.nextLong();
			sol = new ArrayList<Character>();
			pw.printf("Case #%d: ",i+1);
			label();
		}
		sc.close();
		pw.close();
	}
	//8040450694296756411
	static void getword(long lower, long step, int wordsize)
	{
		if(step==0||wordsize==0)
			return ;
		long target = lower;
		if(!(target+step<0))
			target+=step;
		for (int i = 0; i < a.length; i++) {
			if(target>=b|target+step<0)
			{
				sol.add(a[i]);
				if(target>=b)
					lower = target-step;
				else
					lower = target;
				step /= a.length;
				getword(lower, step, wordsize-1);
				return ;
			}
			target+=step;
		}
	}
	
	static void label()
	{
		
		long size = a.length;
		
		long t = size;
		int wordsize =1;
		boolean ch = false;
		while(t>0&t<b&&size>0)
		{
			wordsize++;
			size*=a.length;
			if(t+size<0){
				ch = true;
				break;
			}
			t+=size;
		}
		
		
		// t = 1 && b ==1
		long step = 1;
		for (int i = 1; i < wordsize; i++) {
			step*=a.length;
		}
//		System.out.println("label : "+(t-size)+" "+step);
		if(!ch)
			t-=size;
		getword(t, step, wordsize);
		for (int i = 0; i < sol.size(); i++) {
			pw.print(sol.get(i));
		}
		pw.println();
	}

}
