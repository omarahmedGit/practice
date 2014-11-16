package lib;

import java.util.*;

public class practice_interview {
	
	static void levelByLevel(Node root) {
		Queue<Node> q1 = new LinkedList<Node>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		ArrayList<String> levels = new ArrayList<String>(); 
		int last = -1;
		q1.add(root);
		q2.add(-1);
		while(!q1.isEmpty()) {
			int curNum = q2.poll();
			Node curNode = q1.poll();
			
			if(curNum>last) {
				// print
				for(String x: levels)
					System.out.print(x+" ");
				System.out.println();
				levels.clear();
				levels.add(curNode.name);
				last = curNum;
			} else {
				levels.add(curNode.name);
			}
			
			if(curNode.left!=null) {
				q1.add(curNode.left);
				q2.add(curNum+1);
			}
			
			if(curNode.right!=null) {
				q1.add(curNode.right);
				q2.add(curNum+1);
			}
			
				
		}
		for(String x: levels)
			System.out.print(x+" ");
		System.out.println();
	}
	
	
	
	
	public static class mystack {
		myNode head;
		myNode tail;
		int size;
		
		private class myNode {
			myNode next;
			myNode prev;
			int value;
			int min;
			myNode(int val) {
				min = value = val;
			}
		}
		
		public mystack() {
			size = 0;
		}
		
		void add(int k) {
			myNode node = new myNode(k);
			
			if(head==null) {
				head = node;
				tail = head;
				size = 1;
				return ;
			}
			node.min = Math.min(tail.min, node.min);
			node.prev = tail;
			tail.next = node;
			tail = tail.next;
			++size;
		}
		
		int pop() throws Exception {
			if(size==0) {
				throw new Exception("empty");
			}
			int ret = tail.value;
			if(size==1) {
				head = tail = null;
				size = 0;
				return ret;
			}
			
			tail = tail.prev;
			
			size--;
			
			
			
			
			return ret;
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		
		a.addChild(c, b);
		b.addChild(e, d);
		c.addChild(f, null);
		
		levelByLevel(a);

	}
	
	public static class Node {
		String name;
		Node right;
		Node left;
		public Node(String n) {
			name =  n;
			right = null;
			left = null;
		}
		
		void addChild(Node right,Node left) {
			this.right = right;
			this.left = left;
		}
	}
	
	static void postorder_itr(Node root) {
		if(root==null)
			return ;
		
		Stack<Node> a = new Stack<Node>();
		Stack<Node> b = new Stack<Node>();
		
		a.add(root);
		
		while(!a.isEmpty()) {
			Node cur = a.pop();
			b.add(cur);
			if(cur.left!=null) a.add(cur.left);
			if(cur.right!=null)a.add(cur.right);
		}
		
		while(!b.isEmpty()) {
			System.out.println(b.pop().name);
		}	
	}
	
	static void preorder_itr(Node root) {
		if(root==null)
			return ;

		Stack<Node> preorderTraversal = new Stack<Node>();

		preorderTraversal.add(root);

		while(!preorderTraversal.isEmpty()) {
			Node cur = preorderTraversal.pop();

			System.out.println(cur.name);

			if(cur.right!=null) preorderTraversal.add(cur.right);
			if(cur.left !=null) preorderTraversal.add( cur.left);
		}
	}
	
	static void inorder_itr(Node root) {
		if(root==null)
			return ;

		Stack<Node> inorderTrav = new Stack<Node>();
		boolean done = false;
		Node current = root;
		while(!done) {
			while(current!=null) {
				inorderTrav.add(current);
				current = current.left;
				done = true;
			}

			if(!inorderTrav.isEmpty()) {
				current = inorderTrav.pop();
				System.out.println(current.name);
				current = current.right;
				done = true;
			}
			done = !done;
		}
	}

	static int sqrt(int x) {
		if(x<2) return x;



		int l=0, h=x, m;


		while(l+1<h) {
			m = (l+h) /2 ;
			
			int xx = m*m;

			if(xx==x) return m;
			else if(xx>x) 
				h=m;
			else
				l = m;
		}

		return l;
	}
	
	static double squreRoot(double a) {
		
		if(a==0||a==1)
			return a;
		
		
		double l=0,h=a , m,mm ;
		double tol = 0.00001;
		while(Math.abs(h-l)>tol) {
			m = (l+h) /2;
			
			System.out.println(m);

			mm = m*m;
			if(mm == a) 
				return m;
			else if(mm<a)
				l = m;
			else
				h = m;
		}
		
		return l;
	}
	
	static long pow(long a,long b) {
		if(b==0) return 1;
		
		if(b==1) return a;
		
		
		long ret = pow(a,b/2);
		
		if(b%2==0)
			return ret*ret;
		
		return ret*ret*a;
	}
	
	static int CircularArraySearch(int[] x, int n) {
		int low = 0, mid, high = x.length - 1;
		
		while (low < high) {
			mid = (low+high) / 2;
			
			if(x[mid]==n) {
				return mid;
			} else if(x[mid]<=x[high]) {
				if(n>x[mid]&&n<=x[high])
					low = mid+1;
				else high=mid-1;
			} else if(x[low]<=x[mid]) {
				if(n<x[mid]&&n>=x[low])
					high = mid-1;
				else low = mid+1;
			}
		}

		return low;
	}

	static ArrayList<ArrayList<String>> getAnangram(ArrayList<String> dic) {

		if (dic == null)
			return null;

		ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();

		Hashtable<String, Integer> map = new Hashtable<String, Integer>();

		HashSet<String> hash = new HashSet<String>();

		for (int i = 0; i < dic.size(); i++) {
			char[] word = dic.get(i).toCharArray();

			Arrays.sort(word);
			String str = new String(word);
			if (hash.contains(str)) {
				int idx = map.get(str);
				ret.get(idx).add(dic.get(i));
			} else {
				ArrayList<String> group = new ArrayList<String>();
				group.add(dic.get(i));
				ret.add(group);
				hash.add(str);
				map.put(str, ret.size() - 1);
			}
		}

		return ret;

	}

	static ArrayList<ArrayList<String>> getAnangrames(
			ArrayList<String> dicionary) {

		if (dicionary == null)
			return null;

		ArrayList<ArrayList<String>> solution = new ArrayList<ArrayList<String>>();

		ArrayList<int[]> freq = new ArrayList<int[]>();

		boolean[] visited = new boolean[dicionary.size()];

		for (int i = 0; i < dicionary.size(); i++) {
			char[] word = dicionary.get(i).toCharArray();
			int[] fr = new int[256];
			for (int j = 0; j < word.length; j++) {
				fr[word[j]]++;
			}
			freq.add(fr);
		}

		for (int i = 0; i < dicionary.size(); i++) {

			if (!visited[i]) {
				visited[i] = true;
				ArrayList<String> group = new ArrayList<String>();
				group.add(dicionary.get(i));
				for (int j = 0; j < dicionary.size(); j++) {
					if (!visited[j]) {
						if (myequals(freq.get(i), freq.get(j))) {
							visited[j] = true;
							group.add(dicionary.get(j));
						}
					}
				}
				solution.add(group);
			}
		}

		return solution;
	}

	static boolean myequals(int[] a, int[] b) {

		for (int i = 0; i < b.length; i++) {
			if (a[i] != b[i])
				return false;
		}

		return true;
	}

	static boolean patternCheck(String pattern, String text) {
		char[] pat = pattern.toCharArray();
		char[] txt = text.toCharArray();

		return matchPattern(0, 0, pat, txt);
	}

	static boolean matchPattern(int i, int j, char[] pat, char[] txt) {
		// i -> pat
		// j -> txt
		// base case
		if (i == pat.length)
			return true;

		if (j == txt.length)
			return false;

		boolean ret = false;

		if (pat[i] == '*' || pat[i] == txt[j]) {
			ret |= matchPattern(i + 1, j + 1, pat, txt);
		}

		ret |= matchPattern(0, j + 1, pat, txt);

		return ret;
	}



	public class MedianOfIntegerStream {

		public Queue<Integer> minHeap;
		public Queue<Integer> maxHeap;
		public int numOfElements;

		public MedianOfIntegerStream() {
			minHeap = new PriorityQueue<Integer>();
			maxHeap = new PriorityQueue<Integer>(10, new MaxHeapComparator());
			numOfElements = 0;
		}

		public void addNumberToStream(Integer num) {
			maxHeap.add(num);
			if (numOfElements % 2 == 0) {
				if (minHeap.isEmpty()) {
					numOfElements++;
					return;
				} else if (maxHeap.peek() > minHeap.peek()) {
					Integer maxHeapRoot = maxHeap.poll();
					Integer minHeapRoot = minHeap.poll();
					maxHeap.add(minHeapRoot);
					minHeap.add(maxHeapRoot);
				}
			} else {
				minHeap.add(maxHeap.poll());
			}
			numOfElements++;
		}

		public Double getMedian() {
			if (numOfElements % 2 != 0)
				return new Double(maxHeap.peek());
			else
				return (maxHeap.peek() + minHeap.peek()) / 2.0;
		}

		private class MaxHeapComparator implements Comparator<Integer> {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		}

		// public static void main(String[] args) {
		// MedianOfIntegerStream streamMedian = new MedianOfIntegerStream();
		//
		// streamMedian.addNumberToStream(1);
		// System.out.println(streamMedian.getMedian()); // should be 1
		//
		// streamMedian.addNumberToStream(5);
		// streamMedian.addNumberToStream(10);
		// streamMedian.addNumberToStream(12);
		// streamMedian.addNumberToStream(2);
		// System.out.println(streamMedian.getMedian()); // should be 5
		//
		// streamMedian.addNumberToStream(3);
		// streamMedian.addNumberToStream(8);
		// streamMedian.addNumberToStream(9);
		// System.out.println(streamMedian.getMedian()); // should be 6.5
		// }
	}

}
