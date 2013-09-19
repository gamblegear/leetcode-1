// Divide two integers without using multiplication,
// division and mod operator.

public class Solution {
	public static void main(String[] args) {
		System.out.println(divide(7, 1));
		
	}

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
}