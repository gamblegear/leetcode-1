## Problem

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

2: abc
3: def
4: ghi
5: jkl
6: mno
7: pqrs
8: tuv
9: wxyz

## Stop and Think

这个实际上是一个combination问题，所以就可以用recursion直接解决。

## Solution

    public static ArrayList<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
            ArrayList<String> empty = new ArrayList<String>();
            empty.add("");
            return empty;
        }
    	char[][] mapping = new char[][] {
    		{}, //0 
    		{}, //1 
    		{'a', 'b', 'c'}, //2
    		{'d', 'e', 'f'}, //3
    		{'g', 'h', 'i'}, //4
    		{'j', 'k', 'l'}, //5
    		{'m', 'n', 'o'}, //6
    		{'p', 'q', 'r', 's'}, //7
    		{'t', 'u', 'v'}, //8
    		{'w', 'x', 'y', 'z'} //9
    	};
    	return letterCombinations(digits, mapping);    
    }

    public static ArrayList<String> letterCombinations(String digits, char[][] mapping) {
    	if (digits.length() == 0) {
    		return new ArrayList<String>();
    	}
    	int num = Integer.parseInt(digits.substring(0, 1));
    	HashSet<String> res = new HashSet<String>();
    	if (digits.length() == 1) {
    		for (char c : mapping[num]) {
    			res.add(Character.toString(c));
    		}
    		return new ArrayList<String>(res);
    	}
    	ArrayList<String> prev = letterCombinations(digits.substring(1), mapping);
    	for (String s : prev) {
    		char[] aa = mapping[num];
    		for (char c : aa) {
    			res.add(c + s);
    		}
    	}
    	return new ArrayList<String>(res);
    }


## Note

- 为了满足oj，当digits是空string时候，需要返回一个element（空string）的arraylist