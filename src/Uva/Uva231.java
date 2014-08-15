package Uva;
import java.util.*;
public class Uva231 {
	static ArrayList<Integer> M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx =1;
		boolean ch = false;
		oh :while(sc.hasNext())
		{
			M = new ArrayList<Integer>();
			int l = 0;
			while(true)
			{
				int n = sc.nextInt();
				if(n==-1){
					if(ch) break oh;
					ch = true;
					break;
				}
				ch = false;
				int pos = Collections.binarySearch(M, -n);
				if (pos < 0) pos = -(pos + 1);
				if(pos>=M.size()) M.add(-n);
				else M.set(pos, -n);				
				if(pos==l) l++;				
			}
			if(idx!=1)
				System.out.println();
			System.out.printf("Test #%d:\n",idx++);
			System.out.printf("  maximum possible interceptions: %d\n",l);
		}
		
		sc.close();
	}
	

}
