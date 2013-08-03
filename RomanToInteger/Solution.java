// Given a roman numeral, convert it to an integer.
// Input is guaranteed to be within the range from 1 to 3999.

public class Solution {
    public int romanToInt(String s) {
        // digit by digit
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i=0;i<chars.length - 1;i++)
        {
            if (romanCharToNumber(chars[i]) >= romanCharToNumber(chars[i+1]))
                res += romanCharToNumber(chars[i]);
            else
                res -= romanCharToNumber(chars[i]);
        }
        // last digit
        res += romanCharToNumber(chars[chars.length - 1]);
        return res;
    }

    public int romanCharToNumber(char roman)
    {
        switch (roman)
        {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
}