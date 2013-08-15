// Implement strStr().

// Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.

public class Solution {
	public static void main(String[] args) {
		System.out.println(strStr("returnsapoitertothefirstoccur", "first"));
	}

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
}

