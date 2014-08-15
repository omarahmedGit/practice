package CF;
import java.util.*;
public class CF215_C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		node[] b = new node[a.length];
		for (int i = 0; i < a.length; i++) {
			if(a[i]=='x')
			{
				b[i] = new node(1,0,0);
			}
			else if(a[i]=='y')
			{
				b[i] = new node(0,1,0);
			}
			else
			{
				b[i] = new node(0,0,1);
			}
			if(i!=0)
			{
				b[i].x += b[i-1].x;
				b[i].y += b[i-1].y;
				b[i].z += b[i-1].z;
			}
		}
		int n = sc.nextInt();
		
		for (int i = 0; i < n; i++) {
			int s = sc.nextInt();
			int f = sc.nextInt();
			if(f-s<2)
			{
				System.out.println("YES");
				continue;
			}
			int xx = b[f-1].x;
			int yy = b[f-1].y;
			int zz = b[f-1].z;
			if(s!=1)
			{
				xx -= b[s-2].x;
				yy -= b[s-2].y;
				zz -= b[s-2].z;
			}
			int[] ss = new int[3];
			ss[0]=xx;
			ss[1]=yy;
			ss[2]=zz;
			Arrays.sort(ss);
			if(ss[0]+1>=ss[2])
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		
		sc.close();
	}
	
	
	public static class node
	{
		int x,y,z;
		public node(int x,int y,int z) {
			this.x=x;
			this.y=y;
			this.z=z;
		}
	}

}
