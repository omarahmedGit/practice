package Uva;
import java.util.*;
import java.io.*;
public class UVa10929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st ;
		
		while(true)
		{
			st = new StringTokenizer(br.readLine());
			String n = st.nextToken();
			char[] number = n.toCharArray();
			if(number.length==1&&number[0]=='0') break;
			
			int sumo = 0,sume=0;
			boolean turn = false;
			for (int i = 0; i < number.length; i++) {
				if(!turn)
					sumo+=(number[i]-'0');
				else
					sume+=(number[i]-'0');
				turn=!turn;
			}
			int dif = Math.abs(sumo-sume);
			if(dif%11==0)
				pw.printf("%s is a multiple of 11.\n", n);
			else
				pw.printf("%s is not a multiple of 11.\n", n);
			
		}
		
		pw.close();
		br.close();
	}

}
