## Problem

Given a number represented as an array of digits, plus one to the number.

## Stop and Think

You'll need to set carry default to one and then start adding.

## Solution

    public static int[] plusOne(int[] digits) {
        ArrayList<Integer> result = new ArrayList<Integer>();
		int carry = 1;
		int digit = 0;
		for (int i=digits.length-1; i>= 0; i--, digit++) {
			result.add((digits[i] + carry) % 10);
			carry = (digits[i] + carry) / 10;
		}
		if (carry == 1) {
			result.add(1);
		}
		
		int[] ret = new int[result.size()];
		for (int i=0; i < ret.length; i++)
		{
			ret[i] = result.get(result.size() - i - 1).intValue();
		}
		return ret;
    }
	
## Note

- Use dynamic array makes life a bit easier.