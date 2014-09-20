package CF;

import java.util.*;

public class CF259_B2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		sc.close();

		int check = 0;
		for (int i = 1; i < arr.length; i++) {
			// 1 2 3
			if (arr[i] < arr[i - 1]) {
				check = 1;
				if (arr[i] > arr[0]) {
					System.out.println(-1);
					return;
				}
				for (int j = i + 1; j < arr.length; j++) {
					if (!((arr[j] <= arr[0]) && (arr[j] >= arr[j - 1]))) {
						System.out.println(-1);
						return;
					}
					check++;
				}
			}
		}
		
		System.out.println(check);

	}

}
