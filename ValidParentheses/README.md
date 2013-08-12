## Problem

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.


## Stop and Think

这个括号配对问题可以用栈来模拟。如果是开括号就放进`stack`里面，如果是闭括号就从`stack`栈顶读，看看是不是`match`。

## Solution

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

## Note

- 要注意`stack`是空的情况，不然`pop`会`throw exception`
- 最后要判断是不是`stack`为空