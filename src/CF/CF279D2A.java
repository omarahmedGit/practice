package CF;
import java.util.*;
public class CF279D2A {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		
		ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < 3; i++) {
			arr.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < n; i++) {
			int in = sc.nextInt();
			a[i] = in;
			arr.get(in-1).add(i);
		}
		sc.close();
		
		int min = 5000;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, arr.get(i).size());
		}
		System.out.println(min);
		for (int i = 0; i < min; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(arr.get(j).get(i)+1);
				if(j!=2)
					System.out.print(" ");
			}
			System.out.println();
		}
	}

}
