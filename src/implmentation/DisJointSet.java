package implmentation;

public class DisJointSet {
	/* Union Find Set*/
	
	private int[] parent;
	
	public DisJointSet(int n) {
		parent = new int[n+1];
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}
	}
	
	public int find(int a)
	{
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	public void merge(int a,int b)
	{
		parent[find(a)] = find(b);
	}
	
	public boolean inTheSameSet(int a,int b)
	{
		return find(a)==find(b) ;
	}
	
	
	public static void main(String[] args) {
		DisJointSet set = new DisJointSet(5);
		System.out.println(set.inTheSameSet(1, 2));
		set.merge(1, 2);
		System.out.println(set.inTheSameSet(1, 2));
	}

}
