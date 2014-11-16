package Uva;
import java.util.*;
import java.io.*;
public class UVa10650 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		boolean[] check = new boolean[32100];
		Arrays.fill(check, true);
		check[0] = check[1] = false;
		for (int i = 2; i*i < check.length; i++) {
			if(check[i]) {
				for (int j = i*i; j < check.length; j+=i) {
					check[j] = false;
				}
			}
		}
		
		
		
		int a,b ;
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int lastDiff=-1, lastNum =-1;
		while(sc.hasNext()) {
			a = sc.nextInt();
			b = sc.nextInt();
			if(a==0&&b==0) break;
			if(b<a) {
				int temp = a;
				a = b;
				b = temp;
			}
			
			arr.clear();
			for (int i = a; i <= b; i++) {
				if(check[i]) {
					
					if(lastNum==-1) {
						arr.add(i);
					} else {
						if(lastDiff==-1) {
							lastDiff = i-lastNum;
							arr.add(i);
						} else {
							if(lastDiff==i-lastNum) {
								arr.add(i);
							} else {
								if(arr.size()>=3) {
									
									boolean c = true;
									
									for (int j = arr.get(0)-1; j > -1; j--) {
										if(check[j]) {
											if(a>j&&arr.get(0)-j==lastDiff) c = false;
					 						break;
										}
									}
									
									for (int j = arr.get(arr.size()-1)+1; j < check.length; j++) {
										if(check[j]) {
											if(b<j&&j-arr.get(arr.size()-1)==lastDiff) c = false;						
											break;
										}
									}
									
									if(c) {
										for (int j = 0; j < arr.size(); j++) {
											pw.print(arr.get(j));
											if(j!=arr.size()-1) pw.print(" ");
										}
										pw.println();
									}
									
								}
								arr.clear();
								lastDiff = i-lastNum;
								arr.add(lastNum); arr.add(i);
							}
						}
					}
					lastNum = i;
				}
			}
			
			if(arr.size()>=3) {
				boolean c = true;
				
				for (int i = arr.get(0)-1; i > -1; i--) {
					if(check[i]) {
						if(a>i&&arr.get(0)-i==lastDiff) c = false;
 						break;
					}
				}
				
				for (int i = arr.get(arr.size()-1)+1; i < check.length; i++) {
					if(check[i]) {
						if(b<i&&i-arr.get(arr.size()-1)==lastDiff) c = false;						
						break;
					}
				}
				
				if(c) {
					for (int j = 0; j < arr.size(); j++) {
						pw.print(arr.get(j));
						if(j!=arr.size()-1) pw.print(" ");
					}
					pw.println();	
				}
			}
			
		}
		pw.close();
		sc.close();
	}

}
