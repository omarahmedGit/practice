public class or {
	public static void main(String[] args) {
		double[] values = new double[13];
		
		
		double ans = 1;
		
		for (int i = 0; i <= 9; i++) {
			ans += Math.pow(0.6, i);
		}
		
		ans += (Math.pow(0.6,10)*(5.0/6.0));
		ans += (Math.pow(0.6,11)*(25.0/36.0));
		ans += (Math.pow(0.6,12)*(125.0/216.0));
		
		ans = 1.0/ans;
		System.out.println(ans);
		
		double ansa = (Math.pow(0.6,12)*(125.0/216.0)) * ans;
		
		System.out.println(ansa);
		
		
		double ansb = ans;
		for (int i = 0; i < 5; i++) {
			ansb += (Math.pow(0.6, i)*ans);
		}
		
		System.out.println("answer b : "+(1.0-ansb));
		
		values[0] = ans;
		for (int i = 1; i <= 9; i++) {
			values[i] = values[0]*Math.pow(0.6, i);
		}
		values[10] = (Math.pow(0.6,10)*(5.0/6.0))*values[0];
		values[11] = (Math.pow(0.6,11)*(25.0/36.0))*values[0];
		values[12] = (Math.pow(0.6,12)*(125.0/216.0))*values[0];
		double ansc = 0;
		for (int i = 6,k = 1; i <= 12; i++,k++) {
			ansc += values[i]*k;
		}
		System.out.println("answer c :"+(ansc));
		
	}

}
