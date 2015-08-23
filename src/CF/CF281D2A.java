package CF;
import java.util.*;
public class CF281D2A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String homeT = sc.next();
		String awayT = sc.next();
		
		int fouls = sc.nextInt();
		
		int[] ht = new int[100];
		int[] at = new int[100];
		int[] hf = new int[100];
		int[] af = new int[100];
		
		for (int i = 0; i < fouls; i++) {
			int a = sc.nextInt();
			char h = sc.next().charAt(0);
			int b = sc.nextInt();
			char c = sc.next().charAt(0);
			if(c=='r') {
				if(h=='a') {
					if(af[b]<2) {
						at[b] = a;
						af[b] = 2;
					}

				} else {
					if(hf[b]<2) {
						ht[b] = a;
						hf[b] = 2;	
					}
					
				}
			} else {
				if(h=='a') {
					if(af[b]<2) {
						at[b] = a;
						af[b] ++;
					}
				} else {
					if(hf[b]<2) {
						ht[b] = a;
						hf[b] ++;	
					}
					
				}
			}
		}
		sc.close();
		
		ArrayList<info> ar = new ArrayList<info>();
		for (int i = 0; i < af.length; i++) {
			if(af[i]>=2) {
				ar.add(new info(true,at[i],i));
			}
		}
		
		for (int i = 0; i < hf.length; i++) {
			if(hf[i]>=2) {
				ar.add(new info(false,ht[i],i));
			}
		}
		Collections.sort(ar);
		for (int i = 0; i < ar.size(); i++) {
			info cur = ar.get(i);
			System.out.printf("%s %d %d\n",(cur.away?awayT:homeT),cur.number,cur.t);
		}
		
		
	}
	
	
	public static class info implements Comparable<info> {
		boolean away;
		int t;
		int number;
		public info(boolean team, int time, int num) {
			away = team;
			t = time;
			number = num;
		}
		@Override
		public int compareTo(info o) {
			return this.t-o.t;
		}
		
		
	}

}
