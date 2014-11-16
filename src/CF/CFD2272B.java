package CF;
import java.util.*;
public class CFD2272B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		char[] r = sc.next().toCharArray();
		
		int q=0,f1=0,f2=0;
		
		for(char x:s)
		{
			if(x=='+')
				f1++;
			else if(x=='-')
				f1--;
		}
		
		for(char x:r)
		{
			if(x=='+')
				f2++;
			else if(x=='-')
				f2--;
			else
				q++;
		}
		
		Queue<Integer> nodes = new LinkedList<Integer>();
		Queue<Integer> level = new LinkedList<Integer>();
		
		nodes.add(f2);
		level.add(0);
		
		int size=0, right=0;
		
		while(!nodes.isEmpty()) {
			int curnode = nodes.poll();
			int curlev  = level.poll();
			
			if(curlev==q) {
				++size;
				if(curnode==f1)
					right++;
			} else {
				nodes.add(curnode+1);
				nodes.add(curnode-1);
				level.add(curlev+1);
				level.add(curlev+1);
			}
		}
		
		double ret = ((double)right) / ((double) size) ;  
		
		System.out.printf("%.12f\n",ret);
		
		sc.close();
		
	}

}
