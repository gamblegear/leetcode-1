## Problem

Implement int sqrt(int x). Compute and return the square root of x.

[link](http://leetcode.com/onlinejudge#question_69)

## Stop and Think

开平方，要求返回的结果还是integer，所以就是相当于`floor`后的数值。

这题的思想是二分法，代码同`Binary Search`非常类似。两端从一开始1和x出发，不断二分向中间靠拢，最后得到根。

## Solution 

    public int sqrt(int x) {
    	if (x <= 0) {
            return 0;
        }
        
        long low = 1;
        long high = x;
        while (low < high) {
            long mid = (low + high) / 2;
            if (mid * mid > (long)x) {
                if ((mid - 1) * (mid - 1) < (long)x) {
                    return (int)mid - 1;
                }
                high = mid - 1;
            }
            else {
                if ((mid + 1) * (mid + 1) > (long)x) {
                    return (int)mid;
                }
                low = mid + 1;
            }
        }
        return (int)low;
    }


## Note

- 注意`overflow`的问题，所以需要用`long`型来存。
- 对于负数需要特别处理一下。
