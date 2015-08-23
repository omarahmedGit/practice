package CF;
import java.util.Scanner;


public class CF_276_B {

	public static void main(String[] args) {
		int min = -1000000001;
		int max = 1000000001;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < y.length; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		sc.close();
		long miny=max,minx=max,maxx=min,maxy=min;
		for (int i = 0; i < y.length; i++) {
			miny = Math.min(miny, y[i]);
			maxy = Math.max(maxy, y[i]);
		}
		for (int i = 0; i < x.length; i++) {
			minx = Math.min(minx, x[i]);
			maxx = Math.max(maxx, x[i]);
		}
		
		//System.out.printf("%d %d %d %d\n",miny,maxy,minx,maxx);
		long border = Math.max((maxy-miny),(maxx-minx));
		long area = border * border;
		
		System.out.println(area);
	}

}
