## Problem

Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.

[link](http://leetcode.com/onlinejudge#question_28)

## Stop and Think

这题比较容易想到的方法就是一个moving window，然后比较每一个character是不是和needle是一样的。时间复杂度是O(mn)，m和n分别是haystack和needle的长度。


## Solution

    public static String strStr(String haystack, String needle) {        
    	char[] hArr = haystack.toCharArray();
    	char[] nArr = needle.toCharArray();

    	if (nArr.length == 0) {
    		return haystack;
    	}

    	for (int i=0; i < hArr.length; i++) {
    		if (i + nArr.length > hArr.length) {
    			break;
    		}
    		int k = 0;
    		boolean same = true;
    		for(int j=i; k < nArr.length; j++, k++) {
    			if (hArr[j] != nArr[k]) {
    				same = false;
    				break;
    			}
    		}

    		if (same) {
    			return haystack.substring(i);
    		}
    	}
    	return null;
    }

## Note

- 要考虑如果haystack和needle都是空的string的情况。
- 更好的算法是[KMP算法](http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm)