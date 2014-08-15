package CF;
import java.util.*;
import java.io.*;
public class CFC_SCTS2011 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		StringTokenizer sc = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(sc.nextToken());
		int k = Integer.parseInt(sc.nextToken());;
		int p = 0,in;
		sc = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			in = Integer.parseInt(sc.nextToken());
			if(in<k)
				p+=in;
			else if((in/k)>=3)
				p+=(in-(3*k));
			else
				p+=(in-((in/k)*k));
		}
		pw.println(p);
		pw.close();
		br.close();
	}

}
