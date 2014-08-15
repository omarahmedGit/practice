package lib;

public class Union_Find_Set {

	int[] parent;
	
	Union_Find_Set(int x)
	{
		parent = new int[x];
		for (int i = 0; i < x; i++) parent[i] = i;
	}
	
	int find(int a)
	{
		if(parent[a]==a) return a;
		return parent[a] = find(parent[a]);
	}
	
	void merge(int a,int b)
	{
		parent[find(a)] = find(b);
	}
	
	boolean isInTheSameSet(int a, int b)
	{
		return find(a)==find(b);
	}
	
	public static void main(String[] args) {
		
		Union_Find_Set set = new Union_Find_Set(6);
		System.out.println(set.isInTheSameSet(1, 2));
		set.merge(1, 2);
		System.out.println(set.isInTheSameSet(1, 2));
		System.out.println(set.find(1));

	}

}
