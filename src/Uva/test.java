package Uva;

public class test {

	static String dala3(String x) {
		while (x.length() < 6)
			x = "0" + x;
		return x;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 60; i++) {
			System.out.println(i + " : " + dala3(Integer.toBinaryString(i)));
		}
	}

}
