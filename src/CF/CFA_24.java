package CF;

import java.util.*;

public class CFA_24 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		boolean[] vis = new boolean[n];

		int[][] w = new int[n][n];
		ArrayList<ArrayList<Integer>> pair = new ArrayList<ArrayList<Integer>>();

		for (int i=0;i<n;i++) {
			pair.add(new ArrayList<Integer>());
		}

		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				w[i][j] = -1;


		for(int i=0;i<n;i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			w[a-1][b-1] = c;
			pair.get(a-1).add(b-1);
			pair.get(b-1).add(a-1);
		}

		int f1 = 0,f2 = 0,state = 0,nextState = 0;
		vis[state] = true ;
		for (int i=0; i<n; i++) {
			nextState = pair.get(state).get(0);
			if(vis[nextState]&!(nextState==0&i==n-1))
				nextState = pair.get(state).get(1);
			vis[nextState] = true ;
			if(w[state][nextState]==-1)
			{
				f1+= w[nextState][state];
			} else {
				f2+= w[state][nextState];
			}
			state = nextState;
		}

		System.out.println(Math.min(f1,f2));
		
		sc.close();	
	}

}
