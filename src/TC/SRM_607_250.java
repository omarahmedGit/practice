package TC;

public class SRM_607_250 {

	public static void main(String[] args) {
		int[] a ={0,0,1,0,-1,2};
		int[] b ={0,1,2,-2,0,-1};
		
		System.out.println(minRect(a, b));
		
	}
	
	
	static int minRect(int[] x,int[] y)
	{
		
		int min_x = 110,min_y= 110,max_x=-110,max_y=-110;
		int minX=-1,minY=-1,maxX=-1,maxY=-1;
		for (int i = 0; i < y.length; i++) {
			if(y[i]<min_y)
			{
				min_y = y[i];
				minY = i;
			}
			if(y[i]>max_y)
			{
				max_y = y[i];
				maxY = i;
			}
		}
		
		for (int i = 0; i < x.length; i++) {
			if(x[i]<min_x)
			{
				min_x = x[i];
				minX = i;
			}
			if(x[i]>max_x)
			{
				max_x = x[i];
				maxX = i;
			}
		}
		
		int a = max_x-min_x;
		int b = max_y-min_y;
		
		
		return a*b;
	}

}
