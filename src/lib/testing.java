package lib;

import java.util.*;

public class testing {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
	}
	
	public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        
        for(int i=0;i<numbers.length;i++) {
            if(hash.containsKey(numbers[i])) {
                hash.put(numbers[i],hash.get(numbers[i])+1);
            } else {
                hash.put(numbers[i],1);
            }
        }
        
        for(int i=0;i<numbers.length;i++) {
            int other = target - numbers[i];
            if(hash.containsKey(other)) {
                if(other==numbers[i]) {
                    if(hash.get(other)>1) {
                        for(int j=i+1;j<numbers.length;j++) {
                            if(numbers[j]==other) {
                                return new int[]{i,j};
                            }
                        }
                    }
                } else {
                    for(int j=i+1;j<numbers.length;j++) {
                        if(numbers[j]==other) {
                            return new int[]{i,j};
                        }
                    }
                }
            }
        }
        return null;
    }
	
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
        ListNode sortedList = null;
        ListNode node = head;
        ListNode cur,_cur,prev;
        while(node!=null) {
            cur = node;
            node = node.next;
            _cur = sortedList;
            prev = null;
            while(true) {
                if(_cur==null) {
                    if(sortedList==null) sortedList = cur;
                    else {
                        prev.next = cur;
                    }
                    break;
                }
                if(_cur.val>=cur.val) {
                    cur.next = _cur;
                    if(prev!=null) prev.next = cur;
                    break;
                }
                prev = _cur;
                _cur = _cur.next;
            }
        }
        return sortedList;
    }

	static void reverseStr(String str) {
		char[] s = str.toCharArray();
		char temp;
		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
		System.out.println(Arrays.toString(s));
	}

	static char[] c1,c2,c3;
	public static boolean isInterleave(String s1, String s2, String s3) {
		c1 = s1.toCharArray();
		c2 = s2.toCharArray();
		c3 = s3.toCharArray();
		if(c1.length+c2.length!=c3.length) return false;
		choose(0,0,0);
		return ch;
	}
	static boolean ch = false;
	public static void choose(int s1,int s2,int s3) {
	    if(ch) return ;
	    
	    if(s1==c1.length&&s2==c2.length) {
	        ch = true;
	    }
	    
	    if(s3==c3.length) {
	        return ;
	    }
	    
	    if(s1<c1.length&&c1[s1]==c3[s3]) choose(s1+1,s2,s3+1);
	    if(s2<c2.length&&c2[s2]==c3[s3]) choose(s1,s2+1,s3+1);
	    
	}
	
	public static void setZeroes(int[][] matrix) {
		int row = 0, col = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row |= (1 << i);
					col |= (1 << j);
				}
			}
		}
		System.out.println(Integer.toBinaryString(row));
		System.out.println(Integer.toBinaryString(col));

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (((row & (1 << i)) != 0) | ((col & (1 << j)) != 0)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void matrx(int[][] matrix) {
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);

	}

	public static int atoi(String str) {
		if (str == null || str.length() == 0)
			return 0;

		char[] num = str.toCharArray();
		boolean found = false;
		int sign = 0;
		ArrayList<Integer> number = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			if (found) {
				if (num[i] >= '0' && num[i] <= '9') {
					number.add(num[i] - '0');
				} else {
					break;
				}
			} else {
				if (num[i] != ' ') {
					if (num[i] == '+') {
						found = true;
						sign = 1;
					} else if (num[i] == '-') {
						found = true;
						sign = -1;
					} else if (num[i] >= '0' && num[i] <= '9') {
						found = true;
						sign = 1;
						number.add(num[i] - '0');
					} else {
						return 0;
					}
				}
			}
		}
		if (number.size() == 0)
			return 0;
		String digites = "";

		for (int i = 0; i < number.size(); i++) {
			digites = digites + "" + number.get(i);
		}
		if (number.size() > 10) {
			if (sign == 1)
				return Integer.MAX_VALUE;
			else
				return Integer.MIN_VALUE;
		}
		long max_int = Integer.MAX_VALUE;
		long min_int = Integer.MIN_VALUE;

		if (number.size() <= 10) {
			long res = Long.parseLong(digites);
			if (sign == 1) {
				if (res <= max_int)
					return (int) res;
				else
					return Integer.MAX_VALUE;
			} else {
				// sign = -1
				res *= -1;
				if (res >= min_int)
					return (int) res;
				else
					return Integer.MIN_VALUE;
			}
		}
		return 0;
	}

}
