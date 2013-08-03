## Problem

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

For your reference:

I: 1
V: 5
X: 10
L: 50
C: 100
D: 500
M: 1000

[link](http://leetcode.com/onlinejudge#question_12)

## Stop and Think

对于一个阿拉伯数，分解为decimal各位，对于每一个位上的digit进行处理。因为4和9的特殊性（`4 = 5 - 1`, `9 = 10 - 1`），所以可以用一个switch清楚地列出各种情况。

## Solution

	public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int t = num / 1000;
        for (int i=0;i<t;i++)
            sb.append("M");

        num %= 1000;
        int h = num / 100;
        sb.append(digitToRoman(h, "C", "D", "M"));
        num %= 100;
        int f = num / 10;
        sb.append(digitToRoman(f, "X", "L", "C"));
        num %= 10;
        sb.append(digitToRoman(num, "I", "V", "X"));

        return sb.toString();
    }

    public String digitToRoman(int d, String one, String five, String ten)
    {
        d %= 10;
        switch (d)
        {
            case 1:
                return one;
            case 2:
                return one + one;
            case 3:
                return one + one + one;
            case 4:
                return one + five;
            case 5:
                return five;
            case 6:
                return five + one;
            case 7:
                return five + one + one;
            case 8: 
                return five + one + one + one;
            case 9:
                return one + ten;
            default:
                return "";
        }
    }

## Note

- 注意4和9的特殊性。
- [Roman Numerals Chart](http://literacy.kent.edu/Minigrants/Cinci/romanchart.htm)