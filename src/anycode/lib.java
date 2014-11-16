package anycode;

public class lib {

	public static void main(String[] args) {
		
		
	}
	
	
	public static int GCD(int a ,int b)
	{
		if(b==0) return a;
		return GCD(b,a%b);
	}
	
	

}
