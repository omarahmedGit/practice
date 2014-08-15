package Uva;
import java.util.*;

public class UVA531 {
	static ArrayList<String> a;
	static ArrayList<String> b;
	static ArrayList<String> ans;
	static int[][] dp = new int[105][105];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext()) {
			for (int i = 0; i < 105; i++) {
				for (int j = 0; j < 105; j++) {
					dp[i][j] = -1;
				}
			}
			a = new ArrayList<String>();
			b = new ArrayList<String>();
			ans = new ArrayList<String>();
			while (true) {
				String in = sc.next();
				if (in.equals("#"))
					break;
				a.add(in);
			}

			while (true) {
				String in = sc.next();
				if (in.equals("#"))
					break;
				b.add(in);
			}
			LCM(0, 0);
			Trace(0, 0);
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i));
				if(i+1!=ans.size())
					System.out.print(" ");
			}
			System.out.println();
		}

		sc.close();
	}

	static int LCM(int i, int j) {
		if (i == a.size() || j == b.size())
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];

		if (ch(a.get(i), b.get(j)))
			return dp[i][j] = 1 + LCM(i + 1, j + 1);

		int choice1 = LCM(i + 1, j);
		int choice2 = LCM(i, j + 1);

		return dp[i][j] = Math.max(choice1, choice2);
	}

	static void Trace(int i, int j) {
		if (i == a.size() || j == b.size())
			return ;

		if (ch(a.get(i), b.get(j))) {
			ans.add(a.get(i));
			Trace(i + 1, j + 1);
			return ;
		}
		
		int choice1 = LCM(i + 1, j);
		int choice2 = LCM(i, j + 1);
		
		if(choice1>choice2)
		{
			Trace(i+1, j);
			return ;
		}
		Trace(i, j+1);
	}

	static boolean ch(String aaa, String bbb) {
		if (aaa.length() != bbb.length())
			return false;

		char[] aa = aaa.toCharArray();
		char[] bb = bbb.toCharArray();

		for (int i = 0; i < bbb.length(); i++) {
			if (aa[i] != bb[i])
				return false;
		}

		return true;
	}

}
