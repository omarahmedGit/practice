package CF;
import java.util.*;
public class CF_277_5_C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int s = sc.nextInt();
		sc.close();
		min(m,s);
		max(m,s);
	}
	
	static void min(int m,int s) {
		if(m==1) {
			if(s>9) {
				System.out.print(-1+" ");
			}else {
				System.out.print(s+" ");
			}
			return ;
		}
		
		if(s==0) {
			System.out.print(-1+" ");
			return ;
		}
		int[] num = new int[m];
		
		num[0]=1; s--;
		
		int idx = m-1;
		while(idx>-1 && s>0) {
			if(num[idx]==1) {
				if(s>=8) {
					num[idx]+=8;
					s-=8;
				}else {
					num[idx]+= s;
					s=0;
				}
			} else {
				if(s>=9) {
					num[idx]+=9;
					s-=9;
				}else {
					num[idx]+= s;
					s=0;
				}
			}
			
			idx--;
		}
		if(s!=0) {
			System.out.print(-1+" ");
			return ;
		}
		for (int i = 0; i < num.length; i++) {
			System.out.print(num[i]);
		}
		System.out.print(" ");
		
	}
	
	static void max(int m,int s) {
		if(m==1) {
			if(s>9) {
				System.out.println(-1);
			}else {
				System.out.println(s);
			}
			return ;
		}
		
		if(s==0) {
			System.out.println(-1);
			return ;
		}
		
		int[] num = new int[m];
		int idx = 0;
		while((idx<m) &&(s>0)) {
			if(s>=9) {
				num[idx] = 9;
				s-=9;
			} else {
				num[idx] = s;
				s = 0;
			}
			idx++;
		}
		if(s!=0){
			System.out.println(-1);
		} else {
			for (int i = 0; i < num.length; i++) {
				System.out.print(num[i]);
			}
			System.out.println();
		}
		
	}
}
