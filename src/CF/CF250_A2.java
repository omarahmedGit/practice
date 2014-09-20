package CF;

import java.util.*;

public class CF250_A2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		choice[] chs = new choice[4];

		for (int i = 0; i < 4; i++) {
			String in = sc.next();
			chs[i] = new choice(i, in.length() - 2);
		}

		Arrays.sort(chs);

		ArrayList<choice> lis = new ArrayList<choice>();

		if(chs[0].score*2<=chs[1].score) {
			lis.add(chs[0]);
		}

		if (chs[3].score>=chs[2].score*2) {
			lis.add(chs[3]);
		}

		if (lis.size()==1) {
			int xx = lis.get(0).idx;
			char c = (char)('A'+ xx);
			System.out.println(c);
		} else {
			System.out.println("C");
		}

		sc.close();
	}

	public static class choice implements Comparable<choice> {

		int idx, score;

		public choice(int a, int b) {
			idx = a;
			score = b;
		}

		public int compareTo(choice o) {
			return this.score - o.score;
		}
	}

}
