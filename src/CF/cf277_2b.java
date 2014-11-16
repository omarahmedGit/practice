package CF;
import java.util.*;
import java.io.*;
public class cf277_2b {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int n = sc.nextInt();
		int m = sc.nextInt();

		boolean[][] mat = new boolean[n][m];
		int[] r = new int[n];
		int[] c = new int[m];
		
		Arrays.fill(r,-1);
		Arrays.fill(c,-1);

		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				mat[i][j] = (sc.nextInt()==1) ? true :false;
				if(!mat[i][j]) {
					r[i] = c[j] = 0;
				}
			}
		}
		sc.close();

		boolean check = true;
		for (int i=0; check & (i<n);i++) {
			for (int j=0;check & (j<m);j++) {
				if(mat[i][j]) {
					if((r[i]==c[j]) && (c[j]==0)) {
						check = false;
					} else {
						if(c[j]==-1) c[j] = 1;
						if(r[i]==-1) r[i] = 1;
					}
				}
			}
		}

		if(!check) {
			pw.println("NO");
			pw.close();
			return ;
		}



		boolean eq = true;
		int[] rr = new int[n];
		int[] cc = new int[m];
		boolean[][] mmat = new boolean[n][m];
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				mmat[i][j] = (r[i]&c[j])==1?true:false ;
				if(mmat[i][j]) {
					rr[i] = cc[j] = 1;
				}
			}
		}

		for (int i=0;eq & (i<n) ;i++) {
			if(r[i]!=rr[i]) eq = false;
		}
		for (int i=0;eq & (i<m) ;i++) {
			if(c[i]!=cc[i]) eq = false;
		}

		if (eq) {
			pw.println("YES");
			for (int i=0;i<n;i++) {
				for (int j=0;j<m;j++) {
					pw.print(mmat[i][j]?1:0);
					if(j!=m-1)
						pw.print(" ");
				}
				pw.println();
			}
		} else {
			pw.println("NO");
		}

		pw.close();
	}

}