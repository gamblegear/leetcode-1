// Implement atoi to convert a string to an integer.

// Hint: Carefully consider all possible input cases. 
// If you want a challenge, please do not see below 
// and ask yourself what are the possible input cases.

// Notes: It is intended for this problem to be specified vaguely 
// (ie, no given input specs). You are responsible to gather all 
// the input requirements up front.

public class Solution {
    public int atoi(String str) {
	    if (str.isEmpty()) {
            return 0;
	    }

        str = str.trim();
        boolean isNegative = false;

        int pos = 0;
        if (str.charAt(0) == '-') {
            isNegative = true;
            pos++;
        }

        if (str.charAt(0) == '+') {
            pos++;
        }

        long res = 0;
        for (; pos < str.length(); pos++) {
            if (str.charAt(pos) >= '0' && str.charAt(pos) <= '9') {
                // if this char is a digit
                res = res * 10 + str.charAt(pos) - '0';
            }
            else {
                break;
            }
        }

        if (isNegative) {
            res = -res;
        }

        if (res >= (long) Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        if (res <= (long) Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) res;
    }
}

