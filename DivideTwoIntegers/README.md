## Problem


Divide two integers without using multiplication, division and mod operator.


## Stop and Think

基本的思路就是从原数被除数的2倍数（通过bitwise op来翻倍）比较，值到刚好没有超过停住，然后在循环处理剩下的部分。

## Solution

    public static int divide(int dividend, int divisor) {
        if (divisor == 0) {
        	return 0;
        }

        long a = dividend;
        long b = divisor;

        boolean neg = ((a < 0 && b > 0) || (a > 0 && b < 0));
	    if (a < 0) {
	    	a = -a;
	    }
	    if (b < 0) {
	    	b = -b;
	    }
	    if (a < b) {
	    	return 0;
	    }
	    if (a == b) {
	        return neg? -1:1;
	    }

	    long result = 0;
	    long remain = a;
	    while(remain >= b) {
	    	long subresult = 1;
	    	long multiple = b;
	    	while (remain - multiple >= 0) {
	    		subresult = subresult << 1;
	    		multiple = multiple << 1;
	    	}
	    	result += subresult >> 1;
	    	remain -= multiple >> 1;
	    } 
	    return neg? (int)-result : (int)result;
    }

## Note

- 注意负数
- 注意防止溢出，所以要用long
- bitwise operator is a helper