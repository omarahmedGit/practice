import java.util.*;
import java.io.*;

public class parsing {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("/Users/omar/Desktop/output.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("/Users/omar/Desktop/types.txt"));
		
		String number , type;
		
		while(sc.hasNext())
		{
			number = "";
			type = "";
			char[] line = sc.nextLine().toCharArray();
			for (int i = 0; i < 9;i++) {
				number += line[i]; 
			}
			for (int i = 10; i < line.length; i++) {
				type+=line[i];
			}
			
			pw.printf("%s%s\t",type,number);
		}
		
		
		
		sc.close();
		pw.close();
	}

}
