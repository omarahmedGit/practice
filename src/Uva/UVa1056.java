package Uva;
import java.util.*;
public class UVa1056 {
	static int oo = 1000000000;
	static int[][] mat = new int[55][55];
	static Map<String,Integer> map = new HashMap<String,Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p , r , index,t=1 ;
		String a,b;
		
		while(true)
		{
			p = sc.nextInt();
			r = sc.nextInt();
			if(p==0&r==0)
				break;
			for(int i=0;i<55;i++)
				for(int j=0;j<55;j++)
					mat[i][j] = i==j?0:oo;
			index = 0;
			map.clear();
			for (int i=0;i<r;i++) {
				a = sc.next();
				b = sc.next();
				if(!map.containsKey(a)) map.put(a,index++);
				if(!map.containsKey(b)) map.put(b,index++);
				mat[map.get(a)][map.get(b)] = mat[map.get(b)][map.get(a)] = 1;
			}
			
			for(int k=0;k<p;k++)
				for(int i=0;i<p;i++)
					for(int j=0;j<p;j++)
						mat[i][j] = Math.min(mat[i][j],mat[i][k]+mat[k][j]);

			int max = 0;

			for(int i=0;i<p;i++)
				for(int j=0;j<p;j++)
					max = Math.max(max,mat[i][j]);

			System.out.printf("Network %d: ",t++);

			if(max==oo|max==0)
				System.out.println("DISCONNECTED");
			else
				System.out.println(max);
			System.out.println();
		}

		sc.close();
	}

}
