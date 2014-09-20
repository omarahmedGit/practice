package lib;

public class Trie {

	Trie[] child;
	boolean isLeaf;

	Trie() {
		child = new Trie[26];
		isLeaf = false;
	}

	static char[] copy(char[] str) {
		char[] copy = new char[str.length - 1];
		for (int i = 1; i < str.length; i++)
			copy[i - 1] = str[i];
		return copy;
	}

	void insert(char[] str) {
		if (str.length == 0)
			isLeaf = true;
		else {
			int cur = str[0] - 'a';
			if (child[cur] == null)
				child[cur] = new Trie();
			child[cur].insert(copy(str));
		}
	}
	
	
	boolean wordExist(char[] str)
	{
		if(str.length==0)
			return isLeaf;
		
		int cur = str[0]-'a';
		if(child[cur]==null)
			return false;
		return child[cur].wordExist(copy(str));
	}
	
	boolean prefixExist(char[] str)
	{
		if(str.length==0)
			return true;
		int cur = str[0]-'a';
		if(child[cur]==null)
			return false;
		return child[cur].prefixExist(copy(str));
	}

	public static void main(String[] args) {
		Trie root = new Trie();
		root.insert("abcd".toCharArray());
		root.insert("xyz".toCharArray());
		root.insert("abf".toCharArray());
		root.insert("xn".toCharArray());
		root.insert("ab".toCharArray());
		root.insert("bcd".toCharArray());

		System.out.println(root.wordExist("xyz".toCharArray()));
		System.out.println(root.wordExist("xy".toCharArray()));
		System.out.println(root.prefixExist("xyz".toCharArray()));
		
		
		
	}

}
