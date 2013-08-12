// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

import java.util.*;

public class Solution {
    public boolean isValid(String s) {
    	char[] arr = s.toCharArray();
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0; i<arr.length; i++) {
    		if (arr[i] == '(' ||
    			arr[i] == '{' ||
    			arr[i] == '[') {
    			stack.push(arr[i]);
    		}
    		else if (arr[i] == ')' ||
    			arr[i] == '}' ||
    			arr[i] == ']') {
    			if (stack.empty() || !matchParen(stack.pop(), arr[i])) {
    				return false;
    			}
    		}
    		else {
    			return false;
    		}
    	}
    	return stack.empty();
    }

    private boolean matchParen(char open, char close) {
    	if (open == '(') {
    		return close == ')';
    	}
    	else if (open == '{') {
    		return close == '}';
    	}
    	else if (open == '[') {
    		return close == ']';
    	}
    	else {
    		return false;
    	}
    }
}