package Uva;
import java.util.*;

public class UVA481 {
	static int[] A = new int[1000000];
	static int[] P = new int[1000000];
	static ArrayList<Integer> M = new ArrayList<Integer>();
	static int[] M_id = new int[1000000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L =0,L_end=0,idx=0;
		while (sc.hasNext()) {
			A[idx] = sc.nextInt();
			int pos = Collections.binarySearch(M, A[idx]);
			if (pos < 0) pos = -(pos + 1);
			if(pos>=M.size()) M.add(A[idx]);
			else M.set(pos, A[idx]);
			M_id[pos] = idx;
			
			P[idx] = pos>0?M_id[pos-1]:-1;
			if(pos==L)
			{
				L++;
				L_end=idx;
			}
			idx++;
		}
		System.out.printf("%d\n-\n",L);
		print(L_end);
		sc.close();
	}
	
	
	static void print(int end)
	{
		if(end<0) return ;
		print(P[end]);
		System.out.println(A[end]);
	}

}
