package CF;
import java.util.*;
public class CFC_211 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String in = sc.nextLine();
		
		char[] a = in.toCharArray();
		boolean testpre = false;
		ArrayList<Character> xy = new ArrayList<Character>();
		for(int i=0;i<a.length;)
		{
			char f = a[i];
			int idx =i+1;
			int count = 1;
			
			while(idx<a.length&&a[idx]==a[idx-1])
			{
				idx++;
				count++;
			}
			if((count==1)||count==2&&testpre==true)
			{
				xy.add(f);
				testpre= false;
			}
			else if(count==2&&testpre==false)
			{
				xy.add(f);
				xy.add(f);
				testpre= true;
			}
			else if(count>2&&testpre==false)
			{
				xy.add(f);
				xy.add(f);
				testpre= true;
			}
			else
			{
				xy.add(f);
				testpre= false;
			}
			i+=count;
		}
		
		for (int i = 0; i < xy.size(); i++) {
			System.out.print(xy.get(i));
		}
		System.out.println();
		sc.close();

	}

}
