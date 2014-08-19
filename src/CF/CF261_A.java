package CF;

import java.util.*;
import java.io.*;

public class CF261_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] idx = new int[4];
		int[] sol = new int[4];

		for (int i=0;i<4;i++) {
			idx[i] = sc.nextInt();
		}
		
		boolean check = true ;

		if(idx[1]==idx[3]) {
			sol[0] = idx[0];
			sol[2] = idx[2];
			sol[1] = sol[3] = idx[1] + Math.abs(idx[0]-idx[2]);
		} else if(idx[0]==idx[2]) {
			sol[1] = idx[1];
			sol[3] = idx[3];
			sol[0] = sol[2] = idx[0] + Math.abs(idx[1]-idx[3]);
		} else if(Math.abs(idx[0]-idx[2])==Math.abs(idx[1]-idx[3])) {
			sol[0] = idx[2];
			sol[1] = idx[1];
			sol[2] = idx[0];
			sol[3] = idx[3];
		} else {
			check = false ;
		}
		if(check)
		{
			for(int i=0;i<4;i++){
				System.out.print(sol[i]);
				if(i!=3)
					System.out.print(" ");
			}
			System.out.println();
		} else {
			System.out.println(-1);
		}


		sc.close();	
	}
}


