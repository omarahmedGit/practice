package Uva;

import java.util.*;
import java.io.*;

public class UVa872 {
	static int N;
	static ArrayList<ArrayList<Integer>> graph ;
	static Stack<Integer> orders ;
	static boolean[] visited = new boolean[27], letter = new boolean[27];
	static int[] outDegree = new int[27];
	static ArrayList<ArrayList<Integer>> solution;


	static void reset()
	{
		graph = new ArrayList<ArrayList<Integer>>();
		solution = new ArrayList<ArrayList<Integer>>();
		orders = new Stack<Integer>();
		for (int i=0; i<27; i++) {
			graph.add(new ArrayList<Integer>());
			visited[i] = letter[i] = false ;
			outDegree[i] = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;

		int tokens , n = Integer.parseInt(br.readLine());
		char[] line;
		char input , A , B ;
		while(n-->0)
		{
			reset();
			br.readLine(); /* 2rmih f el ba7r */
			st = new StringTokenizer(br.readLine());
			tokens = N = st.countTokens();

			for (int i =0; i< tokens; i++) {
				line = st.nextToken().toCharArray();
				input = line[0];
				letter[input-'A'] = true;
			}

			st = new StringTokenizer(br.readLine());
			tokens = st.countTokens();

			for (int i =0; i<tokens; i++) {
				line = st.nextToken().toCharArray();
				A = line[0];
				B = line[2];
				graph.get(A-'A').add(B-'A');
				outDegree[B-'A']++;
			}

			topo();

			print();

			if (n!=0) {
				System.out.println();
			}

		}

		br.close();
	}





	static void topo()
	{
		int neighbours ;
		for (int i=0; i<27; i++) {
			if(!visited[i]&&outDegree[i]==0&&letter[i])
			{
				visited[i]=true;
				neighbours = graph.get(i).size();
				for (int j = 0; j<neighbours; j++) {
					outDegree[graph.get(i).get(j)]--;
				}
				orders.add(i);
				
				topo();

				visited[i] = false;
				for (int j = 0; j<neighbours; j++) {
					outDegree[graph.get(i).get(j)]++;
				}
				orders.pop();
			}
		}
		if (orders.size()==N) {
			addToSolution();
		}
	}

	static void addToSolution()
	{
		solution.add(new ArrayList<Integer>());
		int index = solution.size()-1;

		for (int i =0; i<N ; i++) {
			solution.get(index).add(orders.pop());
		}
		
		for (int i =N-1; i>=0 ; i--) {
			orders.add(solution.get(index).get(i));
		}
		
	}

	static void print()
	{
		if (solution.size()==0) {
			System.out.println("NO");
			return ;
		}

		for (int i=0; i<solution.size(); i++) {
			for (int j =N-1; j>=0; j-- ) {
				System.out.print((char)(solution.get(i).get(j)+'A'));
				if (j!=0) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
