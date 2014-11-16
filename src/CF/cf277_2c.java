package CF;

import java.util.*;
import java.io.*;

public class cf277_2c {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		char[] str = br.readLine().toCharArray();
		br.close();

		int ofo = s-1;
		
		int moveUD = 0,offset = 0;
		for (int i=0; i<(s/2);i++) {
			offset = s-1-i;
			if(str[i]!=str[offset]) {
				int dif = Math.abs(str[i]-str[offset]);
				moveUD += Math.min(dif,26-dif);
			}
		}
		

		if (moveUD==0) {
			System.out.println(0);
			return ;
		}

		int left=0,right=(s/2)-1;
		for (int i=0;i<s;i++){
			offset =s-1-i;
			if(str[i]==str[offset]) left++;
			else break;
		}

		for (int i=(s/2)-1;i>=0;i--){
			offset =s-1-i;
			if(str[i]==str[offset]) right--;
			else break;
		}

		int off1 = p-1;
		int moveRL = 0;
		int nright = (ofo-left);
		int nleft =(ofo-right);

		if((off1>right)&&(off1<(s/2))) {
			moveRL = off1-left;
		}

		if((off1<(nleft))&&(off1>=(s/2))) {
			moveRL = nright-off1;
		}
		if(off1<left) {
			moveRL = right-off1;
		}
		if (off1>nright) {
			moveRL = off1-nleft;
		}

		if (off1>=left&&off1<=right) {
			int min = Math.min(off1-left,right-off1);
			moveRL = right-left+min;
		}
		

		if (off1>=nleft&&off1<=nright) {
			int min = Math.min(off1-nleft,nright-off1);
			moveRL = nright-nleft+min;
		}		

		// System.out.println(nleft+" "+nright);

		System.out.println(moveRL+moveUD);

	}
}