package projecteuler;

public class p2 {

	public static void main(String[] args) {
		
		// fib(x) = fib(x-1) + fib(x-2)
		
		int fib1 = 0;
		int fib2 = 1;
		int sum =0;
		while(fib2<4000000)
		{
			if(fib2%2==0)
			{
				System.out.println(fib2);
				sum+= fib2;
			}
			int temp = fib1;
			fib1 = fib2;
			fib2 = fib1+temp;
		}
		System.out.println(sum);
	}

}
