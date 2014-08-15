package Uva;
import java.util.*;
public class Uva280 {
	static int n ;
	static boolean[] v = new boolean[101];
	static boolean[] visited = new boolean[101];
	static boolean[][] gr = new boolean[101][101];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			n = sc.nextInt();
			if(n==0) break;
			for(int i=0;i<=n;i++){
				v[i]= false;
				visited[i]= false;
				for(int j=0;j<=n;j++) gr[i][j]=false;
			}
			int x,y;
			while(true)
			{
				x = sc.nextInt();
				if(x==0) break;
				while(true)
				{
					y = sc.nextInt();
					if(y==0) break;
					gr[x][y]= true;
				}
			}
			x = sc.nextInt();
			for (int i = 0; i < x; i++) {
				y = sc.nextInt();
				dfs(y);
				print();
				for (int j = 0; j <=n; j++) {
					v[j]= false;
					visited[j]= false;
				}
			}	
		}
		
		
		sc.close();
	}
	
	static void print(){
		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			if(!v[i]) sol.add(i);
		}
		System.out.print(sol.size());
		for (int i = 0; i < sol.size(); i++) {
			System.out.print(" "+sol.get(i));
		}
		System.out.println();
	}
	
	public static void dfs(int x)
	{
		visited[x] = true;
		for (int i = 1; i <= n; i++) {
			if(gr[x][i]){
				 v[i]= true;
				 if(!visited[i]) dfs(i);
			}
		}
	}

}
