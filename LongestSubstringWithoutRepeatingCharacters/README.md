## Problem

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

[link](http://leetcode.com/onlinejudge#question_3)

## Stop and Think

1. 从第一个letter出发线性扫描（同时keep一个`hashtable`），until遇到有repeat的character为止。
2. 对于这次扫描，看这个`local length`和`global length`比，如果更大，reassign the global length。
3. 把扫描指针拨回到重复的那个letter的后一个。
4. 重复`1`，until到最末位为止。

## Solution

    public int lengthOfLongestSubstring(String s) {        
    	char[] arr = s.toCharArray();
    	int globalLen = 0;
    	int curr = 0;
    	while (curr < arr.length) {
    		Map<Character, Integer> checkTable = new HashMap<Character, Integer>();
    		int adv = curr;
    		do {
    			checkTable.put(arr[adv], adv + 1);
    			adv++;
    			if (adv == arr.length) {
    				return globalLen < adv - curr? adv - curr : globalLen;
    			}
    		}while (!checkTable.containsKey(arr[adv]));

    		int localLen = adv - curr;
    		if (globalLen < localLen) {
    			globalLen = localLen;
    		}
    		curr = checkTable.get(arr[adv]);
    	}
    	return globalLen;
    }

## Note

- hashtable的value设成是改字符的后一个index
- 边界条件要注意
- 时间复杂度的话是 `O(n)`，因为每个character最多被处理2次。