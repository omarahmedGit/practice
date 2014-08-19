package CF;
import java.util.*;
import java.io.*;
public class CF253_A2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str = br.readLine().toLowerCase().toCharArray();
		
		HashSet<Character> hash = new HashSet<Character>();
		for (int i = 0; i < str.length; i++) {
			if(str[i]>='a'&&str[i]<='z')
				hash.add(str[i]);
		}
		System.out.println(hash.size());
		
		br.close();
	}

}
