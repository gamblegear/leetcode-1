// Given a string, find the length of the longest substring 
// without repeating characters. 
// For example, the longest substring without repeating letters
// for "abcabcbb" is "abc", which the length is 3. 
// For "bbbbb" the longest substring is "b", with the length of 1.

public class Solution {
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
}