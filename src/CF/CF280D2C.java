package CF;
import java.util.*;
public class CF280D2C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long r = sc.nextLong();
		long avg = sc.nextLong();
		Pair[] marks = new Pair[n];
		long comu = 0;
		for (int i = 0; i < n; i++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			marks[i] = new Pair(a,b);
			comu +=a;
		}
		sc.close();
		
		Arrays.sort(marks);
		
		long avgnum = avg*n;
		long essey = 0;
		long needed = avgnum-comu;
		for (int i = 0; needed>0 &&i < marks.length; i++) {
			Pair p = marks[i];
			long c = Math.min(needed,r-p.a);
			needed-=c;
			essey+=(c*p.b);
		}
		
		System.out.println(essey);
		
		
	}
	
	
	public static class Pair implements Comparable<Pair> {
		long a,b;
		
		public Pair(long a,long b) {
			this.a = a;
			this.b = b;
		}
		
		@Override
		public int compareTo(Pair o) {
			return (int) (this.b-o.b);
		}
		
	}

}
