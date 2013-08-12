// Valid Palindrome
// Given a string, determine if it is a palindrome, considering only 
// alphanumeric characters and ignoring cases.

// For example,
// "A man, a plan, a canal: Panama" is a palindrome.
// "race a car" is not a palindrome.

// Note:
// Have you consider that the string might be empty? 
// This is a good question to ask during an interview.

// For the purpose of this problem, we define empty string 
// as valid palindrome.

public class Solution {
    public boolean isPalindrome(String s) {
    	if (s == null || s.length() == 0) {
    		return true;
    	}
    	char[] arr = s.toLowerCase().toCharArray();
    	int i = 0;
    	int j = arr.length - 1;
    	while (i < j) {
    		if (!isAlphanumeric(arr[i])) {
    			i++;
    		}
    		else if (!isAlphanumeric(arr[j])) {
    			j--;
    		}
    		else {
    			if (arr[i] != arr[j]) {
    				return false;
    			}
    			i++;
    			j--;
    		}
    	}
    	return true;
    }

    private boolean isAlphanumeric(char c) {
    	return ((c >= '0' && c <= '9') ||
    		(c >= 'a' && c <= 'z'));
    }
}