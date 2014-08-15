package Uva;
import java.util.*;
import java.io.*;
public class UVa334 {
	static Map<String,Integer> map = new HashMap<String,Integer>();
	static boolean[][] graph = new boolean[205][205];
	static ArrayList<String> names = new ArrayList<String>();
	
	public static class node
	{
		int a,b;
		public node(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
		
		public void print()
		{
			System.out.printf("(%s,%s) ",names.get(a),names.get(b));
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int com , num_element , index ,t=1;
		String read , last="";
		for (int i = 0; i < 205; i++) {
			names.add("ooo");
		}
		while(true)
		{
			com = sc.nextInt();
			if(com==0) break;
			map = new HashMap<String,Integer>();
			for (int i = 0; i < 205; i++) {
				for (int j = 0; j <205; j++) {
					graph[i][j]=false;
				}
			}
			index = 0;
			for (int i = 0; i < com; i++) {
				num_element = sc.nextInt();
				for (int j = 0; j < num_element; j++) {
					read = sc.next();
					if(!map.containsKey(read)) map.put(read,index++);
					if(j!=0)
						graph[map.get(last)][map.get(read)] = true;
					last = read;
					names.set(map.get(read), read);
				}
			}
			
			com = sc.nextInt();
			
			for(int i=0;i<com;i++)
			{
				read = sc.next();
				last = sc.next();
				graph[map.get(read)][map.get(last)] = true;
			}
			
			for(int i=0;i<index;i++)
				for(int j=0;j<index;j++)
					for(int k=0;k<index;k++)
						graph[j][k] |= (graph[j][i]&graph[i][k]);
			
			
			
			ArrayList<node> sol = new ArrayList<node>();
			for (int i = 0; i < index; i++) {
				for (int j = i+1; j < index; j++) {
					if(!graph[i][j]&!graph[j][i])
					{
						sol.add(new node(i,j));
					}
				}
			}
			System.out.printf("Case %d, ",t++);
			if(sol.size()==0)
				System.out.println("no concurrent events.");
			else
			{
				System.out.printf("%d concurrent events:\n",sol.size());
				node cur;
				for (int i = 0; i < sol.size()&i<2; i++) {
					cur = sol.get(i);
					cur.print();
				}
				System.out.println();
			}
		}
		
		sc.close();
		
	}

}
