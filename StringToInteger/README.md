## Problem

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

- The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

- The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

- If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

- If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

## Stop and Think

可能的input有：

- `123`
- `    123   `
- `-321`
- `+123`
- `1000,000,000`
- `3123123123123123123`(overflow)
- `1.2e10` (this seems too complicated)
- 等等

因为有各种情况所以需要做一些preprocessing，比如符号和空格，但是核心的部分就是一位一位的parse。

## Solution

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

## Note

- 注意计算的overflow。
