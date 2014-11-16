package TC;

public class TC_635_D2_250 {

	public static void main(String[] args) {
		
		check("absdefgh","asdf");
		check("oxoxoxox","ooxxoo");
		check("oxoxoxox","xxx");
		check("qwerty","qwerty");
		check("string","longstring");
		

	}
	
	static char[] a,b;
	public static String check(String s1, String s2) {
		a = s1.toCharArray();
		b = s2.toCharArray();
		
		boolean ret = choose(0,0);
		
		if(ret)
			System.out.println("Yep, it's wood.");
		else
			System.out.println("Nope.");
		
		return null;
	}
	
	
	public static boolean choose(int i,int j) {
		
		if(j==b.length) {
			return true;
		}
		
		if(i==a.length) {
			return false;
		}
		
		if(a[i]==b[j])
			return choose(i+1,j+1);
		
		
		return choose(i+1,j);
	}

}
