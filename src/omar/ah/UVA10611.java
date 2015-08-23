package omar.ah;

import java.io.*;
import java.util.*;

public class UVA10611 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		int[] chimp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < chimp.length; i++) {
			chimp[i] = Integer.parseInt(st.nextToken());
		}
		int t = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		br.close();
		while (t-- > 0) {
			int x = Integer.parseInt(st.nextToken());

			int low, high, a = -1, b = -1;
			// 1 2 3 4 5 6 7 8 9
			low = 0;
			high = n - 1;

			while (low + 1 < high) {
				int mid = (low + high) / 2;
				if (chimp[mid] >= x) {
					high = mid - 1;
				} else {
					low = mid;
				}
			}

			if (chimp[high] < x) {
				a = chimp[high];
			} else if (chimp[low] < x) {
				a = chimp[low];
			}

			// 1 2 3 4 5
			low = 0;
			high = n - 1;
			while (low + 1 < high) {
				int mid = (low + high) / 2;
				if (chimp[mid] <= x) {
					low = mid + 1;
				} else {
					high = mid;
				}
			}

			if (chimp[low] > x) {
				b = chimp[low];
			} else if (chimp[high] > x) {
				b = chimp[high];
			}

			if (a == -1)
				pw.print("X ");
			else
				pw.print(a + " ");

			if (b == -1)
				pw.print("X");
			else
				pw.print(b);

			pw.println();
		}

		pw.close();

	}

}
