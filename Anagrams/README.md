## Problem

Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.

[link](http://leetcode.com/onlinejudge#question_49)

## Stop and Think

题意有一点confusing，`return all groups of strings that are anagrams`，就是要返回所有至少有另外`anagram`的`strings`。

`linear scan`这个`string`数组，对每一个看它的signature（如果是anagram，signature应该是一样的），把这些信息存在一个`hashtable`里面。再做一次linear scan，这次就把有`anagram`（至少2个的）的取出来放在ArrayList里面。

## Solution

    public ArrayList<String> anagrams(String[] strs) {
    	Map<String, Integer> anagramFreq = new HashMap<String, Integer>();
    	String[] sigs = new String[strs.length];

    	for(int i=0; i < strs.length; i++) {	
    		// get signature
			char[] arr = strs[i].toCharArray();
    		Arrays.sort(arr);
    		sigs[i] = new String(arr);

    		if (anagramFreq.containsKey(sigs[i])) {
    			anagramFreq.put(sigs[i], anagramFreq.get(sigs[i])+1);
    		}
    		else {
    			anagramFreq.put(sigs[i], 1);
    		}
    	}

    	ArrayList<String> anagrams = new ArrayList<String>();
    	for(int i=0; i < strs.length; i++) {
    		if (anagramFreq.containsKey(sigs[i]) && 
    			anagramFreq.get(sigs[i]) > 1) {
    			anagrams.add(strs[i]);
    		}
    	}
    	return anagrams;
    }

## Note

- 关键是要对`string`做signature，这样`anagram`可以被group到一起。
- `java`里面没有像`c＃`一下可以用中括号来得到hash value。只能用`get`和`put`。
