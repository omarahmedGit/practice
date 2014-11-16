package TC;

public class TC_635_D2_500 {

	public static void main(String[] args) {
		
	}
	
	public static long getTime(long d) {
		
		long l = (long)Math.sqrt(d);
		
		while((l*l)+l>d) {
			l--;
		}
		
		return l;
	}

}
