// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return all possible palindrome partitioning of s.

// For example, given s = "aab",
// Return

//   [
//     ["aa","b"],
//     ["a","a","b"]
//   ]

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> res = partition("abbab");
		for (ArrayList<String> part : res) {
			printArray(part);
		}
	}
	private static void printArray(ArrayList<String> ss) {
			for (String s : ss) {
				System.out.print(s + " ");
			}
			System.out.println();
	}
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
}