package CF;
import java.util.*;

public class CF255_B2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int v = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < n; i++) {
			list.add(new Pair(sc.nextInt(),sc.nextInt()));
		}
		Collections.sort(list);
		long count = 0;
		int temp , idx = 1;
		while(true)
		{
			temp = v;
			for (int i = 0; i < list.size(); i++) {
				Pair p = list.get(i);
				
				if(p.b==0) continue ;
				
				if(temp==0) break;
				
				if(idx==p.a||idx==(p.a+1))
				{
					if(p.b<=temp)
					{
						temp -= p.b;
						count+= p.b;
						list.remove(i);
						list.add(i,new Pair(p.a,0));
					}else {
						list.remove(i);
						list.add(i,new Pair(p.a,p.b-temp));
						count+=temp;
						temp=0;
					}
				}
			}
			idx++;
			if(idx>list.get(list.size()-1).a+1)
				break;
		}
		
		System.out.println(count);
		
		sc.close();
	}
	
	
	public static class Pair implements Comparable<Pair> {
		int a,b;
		public Pair(int a,int b)
		{
			this.a = a;
			this.b = b;
		}
		
		public void setB(int b){this.b = b;}
		
		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return this.a-o.a;
		}
	}

}
