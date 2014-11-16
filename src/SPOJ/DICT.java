package SPOJ;
import java.util.*;
public class DICT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		sc.close();	
	}





	public static class Trie {
		Trie[] child ;
		boolean isLeafe;

		public Trie()
		{
			child = new Trie[26];
			isLeafe = false;
		}
		

		static char[] copy(char[] str)
		{
			char[] copy = new char[str.length-1];

			for (int i=1;i<str.length;i++) {
				copy[i-1] = str[i];
			}

			return copy;
		}

		void insert(char[] str)
		{
			if(str.length==0)
				isLeafe = true;
			else {
				int cur = str[0] - 'a';
				if(child[cur]==null)
					child[cur] = new Trie();
				child[cur].insert(copy(str));
			}
		}

		boolean properPrefix(char[] str)
		{
			if(str.length==0)
				return !isLeafe;

			int cur = str[0]-'a';
			if (child[cur]==null)
				return false;
			return child[cur].properPrefix(copy(str));
		}
	}

}
