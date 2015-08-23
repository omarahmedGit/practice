package USACO;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
ID: omarahm1
LANG: JAVA
TASK: wormhole 
*/

public class wormhole {
	static int ans = 0, len;
	static boolean[] c;
	static Point[] hols;
	static int[] map;
	static int[] next;
	
	public static class Point implements Comparable<Point> {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int compareTo(Point o) {
			return this.x - o.x;
		}
	}

	static void count(int i) {

		if (i == len) {
			
			/*
			System.out.println("mapping :");
			System.out.println(Arrays.toString(map));
			for (int j = 0; j < len; j++) {
				int d = map[j];
				if(d>j)
					System.out.println(d+"<->"+j);
			}
			*/
			
			if (isInfinite())
				++ans;

			return;
		}

		for (int j = 0; j < c.length; j++) {
			if (!c[j]) {
				c[j] = true;
				for (int j2 = 0; j2 < c.length; j2++) {
					if (!c[j2]) {
						c[j2] = true;
						map[j] = j2;
						map[j2] = j;
						count(i + 2);
						c[j2] = false;
					}
				}
				c[j] = false;
				break;
			}

		}

	}

	static boolean isInfinite() {
		
		for (int i = 0; i < len; i++) {
			int cur = i;
			int count = 1;
//			System.out.println("first enter :");
			while(cur!=-1 && count<len+1) {
//				System.out.printf("enter %d with count %d\n",cur,count);
				cur = map[cur];
				count++;
//				System.out.printf("out from %d with count %d\n",cur,count);
				cur = next[cur];
			}
			
			if(count==len+1)
				return true;
			
		}
		
		return false;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("wormhole.in"));
		StringTokenizer st;
		
		len = Integer.parseInt(br.readLine());
		hols = new Point[len];
		map = new int[len];
		next = new int[len];
		c = new boolean[len];
		
		for (int i = 0; i < len; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			hols[i] = new Point(a, b);
		}
		
		br.close();
		
		Arrays.sort(hols);
		
		Arrays.fill(next, -1);
		
		for (int i = 0; i < len; i++) {
			for (int j = i+1; j < len; j++) {
				if(hols[i].y==hols[j].y) {
					next[i] = j;
					break;
				}
			}
		}
		
		count(0);
		
		PrintWriter pw = new PrintWriter(new FileWriter("wormhole.out"));
		pw.println(ans);
		pw.close();
		
	}

}
