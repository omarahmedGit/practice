package CF;
import java.util.*;
import java.io.*;
public class CFA_257 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] a = new int[n];
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < a.length; i++) {
			q.add(i);
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		int cur  = 0;
		while(!q.isEmpty())
		{
			cur = q.poll();
			a[cur]-= m;
			if(a[cur]>0)
				q.add(cur);
		}
		
		pw.println(cur+1);
		
		pw.close();
		br.close();
	}

}
