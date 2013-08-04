// Given an array of strings, return all groups of strings that are anagrams.

// Note: All inputs will be in lower-case.

import java.util.*;

public class Solution {
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
}