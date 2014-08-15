package Uva;
import java.util.*;


public class UVa11060 {
	static int number_of_drinks;
	static boolean[] visited = new boolean[102];
	static PriorityQueue<node> drinks ;
	static ArrayList<ArrayList<Integer>> graph ;
	static Map<String,Integer> map;
	static int[] outDegree = new int[102];
	static ArrayList<String> topo,drinks_names;
	
	static void reset()
	{
		for(int i=0;i<102;i++){
			visited[i] 	 = false;	
			outDegree[i] = 0;
		}
		drinks = new PriorityQueue<node>();
		graph = new ArrayList<ArrayList<Integer>>();
		
		for (int i=0; i< number_of_drinks; i++ ) {
			graph.add(new ArrayList<Integer>());
		}
		topo = new ArrayList<String>();
		drinks_names = new ArrayList<String>();
		map = new HashMap<String, Integer>();
	}

	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		String names,B1,B2;
		int m,idx1,idx2,test_number=1;
		while(sc.hasNext())
		{
			number_of_drinks = sc.nextInt();
			reset();
			for (int i=0; i<number_of_drinks; i++) {
				names = sc.next();
				drinks_names.add(names);
				map.put(names,i);
			}
			m = sc.nextInt();
			for (int i=0; i<m; i++ ) {
				B1 = sc.next();
				B2 = sc.next();
				idx1 = map.get(B1);
				idx2 = map.get(B2);
				outDegree[idx2]++;
				graph.get(idx1).add(idx2);	
			}
			for (int i=0; i<number_of_drinks; i++ ) {
				drinks.add(new node(outDegree[i],i));
			}
			
			BFS();

			System.out.printf("Case #%d: Dilbert should drink beverages in this order: ",test_number++);
			for (int i =0; i<topo.size(); i++) {
				System.out.print(topo.get(i));
				if (i!=topo.size()-1) {
					System.out.print(" ");
				}
			}
			System.out.print(".\n\n");

		}
		sc.close();
	}



	static void BFS()
	{
		node cur;
		int x , neigbours ,index ;
		while(!drinks.isEmpty())
		{
			
			cur = drinks.poll();
			if (visited[cur.index]) {
				continue;
			}
						
			visited[index = cur.index] = true;
			
			x = graph.get(index).size();
			
			for (int i=0; i<x; i++) {
				neigbours = graph.get(index).get(i);
				outDegree[neigbours]--;
				drinks.add(new node(outDegree[neigbours],neigbours));
			}
			topo.add(drinks_names.get(cur.index));
		}

	}


	static class node implements Comparable<node>
	{
		int out,index;

		node(int out,int index)
		{
			this.out = out;
			this.index = index;
		}

		@Override
		public int compareTo(node o) {
			if(this.out==o.out)
				return this.index-o.index;
			return this.out-o.out;
		}
		
	}

}
