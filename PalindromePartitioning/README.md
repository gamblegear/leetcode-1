## Problem

Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["aa","b"],
    ["a","a","b"]
  ]

## Stop and Think

用recursion的思想，当前面n-1个char已经处理好了以后，比如aa。当看最后一个char时候（比如b），因为一个char本身就是palindrome，先直接把b加到每一个result，然后对于每一个result，有可能可以combine的，比如当“a", "aba"加入”a”的时候，先a与aba结合，发现不是palindrome，然后再和前面的a进行combine，结果发现palindrome，加入到最后的result里面去。

## Solution

   public static ArrayList<ArrayList<String>> partition(String s) {
        HashSet<ArrayList<String>> res = new HashSet<ArrayList<String>>();
        if (s.length() == 0) {
        	return new ArrayList<ArrayList<String>>(res);
        }
        if (s.length() == 1) {
        	ArrayList<String> onlyOne = new ArrayList<String>();
        	onlyOne.add(s);
        	res.add(onlyOne);
        	return new ArrayList<ArrayList<String>>(res);
        }
        ArrayList<ArrayList<String>> p = partition(s.substring(0, s.length() - 1));
        for (int i=0; i < p.size(); i++) {
        	ArrayList<String> m = p.get(i);
        	ArrayList<String> aa = combine(m, s.substring(s.length() - 1));
        	if (aa != null) {
        		res.add(aa);
        	}
        	m.add(s.substring(s.length() - 1));
        	res.add(m);
        }
        return new ArrayList<ArrayList<String>>(res);
    }
    private static ArrayList<String> combine(ArrayList<String> a, String c) {
    	ArrayList<String> res = new ArrayList<String>();
    	boolean hasFound = false;
    	String temp = c;
    	for(int i = a.size() - 1; i >= 0; i--) {
    		if (hasFound) {
    			res.add(0, a.get(i));
    		}
    		else {
    			temp = a.get(i) + temp;
    			if (isPalindrome(temp)) {
    				hasFound = true;
    				res.add(0, temp);
    			}
    		}
    	}
    	return hasFound? res : null;
    }
    private static boolean isPalindrome(String s) {
    	char[] c = s.toCharArray();
    	int i = 0;
    	int j = c.length - 1;
    	while (i < j) {
    		if (c[i] != c[j]) {
    			return false;
    		}
    		else {
    			i++;
    			j--;
    		}
    	}
    	return true;
    }

## Note

- 需要用hashset来dedup。为什么？比如"a", "bb" 和 "a" "b" "b"，当看最后“a”时候，那个combine call都generate "abba"。