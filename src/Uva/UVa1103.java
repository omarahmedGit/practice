package Uva;

import java.util.*;
import java.io.*;

public class UVa1103 {

	static boolean[][] graph = new boolean[200][200];
	static int[][] visited = new int[200][200];
	static int[] _y = { 1, -1, 0, 0 };
	static int[] _x = { 0, 0, 1, -1 };
	static int hieght, width, comp;
	static char[][] binary = new char[16][4];
	static ArrayList<Integer> component ;
	static char[] sympols = {'W','A','K','J','S','D'};
						//    6   1   4   3   5    2
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int h, w, r, t=1;
		initMap();
		char[] line;
		while (true) {
			st = new StringTokenizer(br.readLine());
			hieght = h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			if (h == 0 & w == 0)
				break;
			component = new ArrayList<Integer>();
			width = 4*w;
			for (int i = 0; i < h; i++) {
				line = br.readLine().toCharArray();
				for (int j = 0; j < line.length; j++) {
					r = (line[j] >= '0' & line[j] <= '9') ? line[j] - '0': line[j] - 'a' + 10;
					for (int j2 = 0; j2 < 4; j2++) {
						graph[i][j * 4 + j2] = binary[r][j2] == '1' ? true: false;
						visited[i][j*4 + j2] = 0;
					}
				}
			}

			for (int i = 0; i < w * 4; i++)
				if (visited[0][i] == 0 & !graph[0][i])
					bfs(new node(0, i), false, -1);
			for (int i = 0; i < w * 4; i++)
				if (visited[h - 1][i] == 0 & !graph[h - 1][i])
					bfs(new node(h - 1, i), false, -1);
			for (int i = 0; i < h; i++)
				if (visited[i][0] == 0 & !graph[i][0])
					bfs(new node(i, 0), false, -1);
			for (int i = 0; i < h; i++)
				if (visited[i][(4 * w) - 1] == 0 & !graph[i][(4 * w) - 1])
					bfs(new node(i, (4 * w) - 1), false, -1);
			/*
			 * 
			 *  (-1) the white out-layer 
			 *  (number the black comp)  
			 */

			countComp();
			/*
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < 4 * h; j++) {
					System.out.print((visited[i][j] == -1 ? 1 : visited[i][j]) + " ");
				}
				System.out.println();
			}
			*/
			
			int[] sym = new int[6];
			for (int i = 1; i < component.size(); i++) {
				sym[component.get(i)]++;
			}
			System.out.printf("Case %d: ",t++);
			for (int i = 0; i < sym[1]; i++) {
				System.out.print(sympols[1]);
			}
			
			for (int i = 0; i < sym[5]; i++) {
				System.out.print(sympols[5]);
			}
			
			for (int i = 0; i < sym[3]; i++) {
				System.out.print(sympols[3]);
			}
			
			for (int i = 0; i < sym[2]; i++) {
				System.out.print(sympols[2]);
			}
			
			for (int i = 0; i < sym[4]; i++) {
				System.out.print(sympols[4]);
			}
			
			for (int i = 0; i < sym[0]; i++) {
				System.out.print(sympols[0]);
			}
			
			System.out.println();
			

		}

		br.close();
	}

	static void initMap() {

		String[] numbers = new String[16];
		numbers[0] = "0000";
		numbers[1] = "0001";
		numbers[2] = "0010";
		numbers[3] = "0011";
		numbers[4] = "0100";
		numbers[5] = "0101";
		numbers[6] = "0110";
		numbers[7] = "0111";
		numbers[8] = "1000";
		numbers[9] = "1001";
		numbers[10] = "1010";
		numbers[11] = "1011";
		numbers[12] = "1100";
		numbers[13] = "1101";
		numbers[14] = "1110";
		numbers[15] = "1111";

		for (int i = 0; i < numbers.length; i++) {
			binary[i] = numbers[i].toCharArray();
		}

	}

	static void countComp() {
		
		comp =1;
		component.add(0);
		for (int i = 0; i < hieght; i++) {
			for (int j = 0; j < width; j++) {
				if (graph[i][j] & visited[i][j] == 0) {
					component.add(0);
					bfs(new node(i, j), true, comp++);
				} else if(!graph[i][j] & visited[i][j]==0) {
					bfs_2(new node(i,j));
				}
			}
		}
	}

	static void bfs(node node, boolean mark, int state) {
		Queue<node> q = new LinkedList<node>();
		q.add(node);
		node cur;
		while (!q.isEmpty()) {
			cur = q.poll();
			if (visited[cur.x][cur.y] != 0)
				continue;
			
			visited[cur.x][cur.y] = state;
			for (int i = 0; i < 4; i++) {
				if (check(cur.x + _x[i], cur.y + _y[i]))
					if (visited[cur.x + _x[i]][cur.y + _y[i]] == 0)
						if( graph[cur.x + _x[i]][cur.y + _y[i]] == mark)
							q.add(new node(cur.x + _x[i], cur.y + _y[i]));
				
			}

		}

	}
	
	static void bfs_2(node node)
	{
		int comp_num = 0 , vis;
		Queue<node> q = new LinkedList<node>();
		q.add(node);
		node cur ;
		while(!q.isEmpty())
		{
			cur = q.poll();
			if(visited[cur.x][cur.y]!=0)
				continue;
			visited[cur.x][cur.y]=-1;
			
			for (int i = 0; i < 4; i++) {
				vis = visited[cur.x+_x[i]][cur.y+_y[i]];
				if(vis==0)
				{
					q.add(new node(cur.x+_x[i],cur.y+_y[i]));
				} else if(vis!=0&vis!=-1) {
					comp_num = vis;
				}
			}
		}
		int val = component.get(comp_num)+1;
		component.set(comp_num,val);
		
	}

	static boolean check(int x, int y) {
		if (x >= 0 & x < hieght & y >= 0 & y < width)
			return true;
		return false;
	}

	static class node {
		int x, y;

		public node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
