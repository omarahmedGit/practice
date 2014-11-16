package anycode;
import java.util.*;

public class BFS_and_Dijkstra {

	public static void main(String args[])
	{
		int OO = 1000000000  ; // Infinity
		int k = 6 ; // number of nodes
		int[] min_dis = new int[k]; // array holds the minimum distance from the source to the index i
		ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>> ();
		int[][] w = new int[k][k];
		
		// Setting the weights for the edges
		w[0][1] = 1;
		w[0][2] = 2;
		w[1][3] = 1;
		w[2][3] = 2;
		w[2][4] = 1;
		w[3][5] = 1;
		w[4][5] = 2;


		// initializing the graph array list
		for(int i =0 ; i<k; i++) {
			graph.add(new ArrayList<Integer>());
			min_dis[i] = -1; // setting the initial distance for all indexes equal to -1 
		}
		
		// making the adjList
		graph.get(0).add(1);
		graph.get(0).add(2);
		graph.get(1).add(3);
		graph.get(2).add(3);
		graph.get(2).add(4);
		graph.get(3).add(5);
		graph.get(4).add(5);
		
		Queue<Integer> q0 = new LinkedList<Integer>();
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Queue<Integer> temp;
		int source = 0;
		// adding the source the the q0
		q0.add(source);
		min_dis[source] = 0;
		// applying BFS
		while(!(q0.isEmpty()&q1.isEmpty()&q2.isEmpty()))
		{
			while(!q0.isEmpty())
			{
				int cur = q0.poll();
				for(int i=0;i<graph.get(cur).size();i++)
				{
					int neighbour = graph.get(cur).get(i);
					if(w[cur][neighbour]==2)
					{
						if(min_dis[neighbour]==-1) {
							q2.add(neighbour);
							min_dis[neighbour] = min_dis[cur] + 2 ;	
						}
					} else {
						if(min_dis[neighbour]==-1) {
							q1.add(neighbour);
							min_dis[neighbour] = min_dis[cur] + 1 ;	
						}
					}
				}
			}
			temp = q0 ;
			q0 = q1 ;
			q1 = q2 ;
			q2 = temp ;
		}
		System.out.println("Problem 3");
		for(int i=0;i<k;i++)
			System.out.printf("from the source %d to the index %d the sssp value is %d\n", source , i , min_dis[i]);
		// applying Dijkstra 
		for (int i = 0; i < k; i++) {
			min_dis[i] = OO;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		q.add(source);
		min_dis[source] = 1;
		while(!q.isEmpty())
		{
			int cur = q.poll();
			for(int i=0;i<graph.get(cur).size();i++)
			{
				int neighbour = graph.get(cur).get(i);
				if(min_dis[cur]*w[cur][neighbour]<min_dis[neighbour])
				{
					min_dis[neighbour] = min_dis[cur]*w[cur][neighbour] ;
					q.add(neighbour);
				}
			}
		}
		System.out.println("Problem 4");
		
		for(int i=0;i<k;i++)
			System.out.printf("from the source %d to the index %d the sssp value is %d\n", source , i , min_dis[i]);
		
		/*
		the output :
		Problem 3
		from the source 0 to the index 0 the sssp value is 0
		from the source 0 to the index 1 the sssp value is 1
		from the source 0 to the index 2 the sssp value is 2
		from the source 0 to the index 3 the sssp value is 2
		from the source 0 to the index 4 the sssp value is 3
		from the source 0 to the index 5 the sssp value is 3
		Problem 4
		from the source 0 to the index 0 the sssp value is 1
		from the source 0 to the index 1 the sssp value is 1
		from the source 0 to the index 2 the sssp value is 2
		from the source 0 to the index 3 the sssp value is 1
		from the source 0 to the index 4 the sssp value is 2
		from the source 0 to the index 5 the sssp value is 1
		 */
	}
}