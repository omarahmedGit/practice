package omar.ah;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class UVA11057 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] books = new int[n];
			for (int i = 0; i < books.length; i++) {
				books[i] = sc.nextInt();
			}
			Arrays.sort(books);
			int sum = sc.nextInt();

			int a = 0, b = 0, min = 1000001;
			for (int i = 0; i < books.length; i++) {
				int rem = books[i];
				int target = sum - rem;
				if (target < rem)
					break;

				int low = i + 1;
				int high = books.length - 1;
				int sol = -1;
				while (low <= high) {
					int mid = (low + high) / 2;

					if (books[mid] == target) {
						sol = mid;
						break;
					} else if (books[mid] > target) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}

				if (sol != -1) {
					if (target - rem < min) {
						min = target - rem;
						a = rem;
						b = target;
					}
				}
			}

			System.out.printf("Peter should buy books whose prices are %d and %d.\n\n",a, b);
		}
		pw.close();
		sc.close();
	}

}
