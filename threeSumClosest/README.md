## Problem
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

- [link](http://leetcode.com/onlinejudge#question_16)
    
## Stop & Think

这题首先能想到的是brute force的 *O(n^3)* 的solution，也即把所有n choose 3的可能性罗列下来，然后排个序，选择最小的那个。但是我们需要更优的解。

我有一个思路是把所有tuple（两个）的可能性存在一个hashtable里面作preprocessing，key是sum of two，value是tuple of indices（为避免重复，必须要存index），然后再用一个linear scan，每一个element去hashtable里面找加上能最接近target的tuple。should be doable，时间复杂度是 *O(n^2)* 。作为c＃的programmer，发现java没有支持tuple，然后我最喜欢的LINQ也没有，implementation有点小tricky。

换个角度想，既然我们在追求 *O(n^2)* ，那我们无妨先把输入sort一下，不影响时间复杂度。诶，一旦sort后，我发现好像有所眉目了。我们可以用三个指针的方法，第一个指针是最外loop，然后另外两个指针从剩余的array两头往中间，往target靠，这样就有如下的代码。


## Solution

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);
        int globalSum = target < 0? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for(int i = 0; i < num.length; i++) {
            int j = i+1;
            int k = num.length-1;
            while (j < k) {
                int sum = num[i] + num[j] + num[k];
                if (sum == target) {
                    return sum;
                }
                else {
                    if (Math.abs(sum - target) < Math.abs(globalSum - target)) {
                        globalSum = sum;
                    }
                    if (sum > target) {
                        k--;
                    }
                    else {
                        j++;
                    }
                }
            }
        }
        return globalSum;
    }

## Note

- 注意溢出：`Math.abs(globalSum - target))`
- 最接近的意思是正负都可以，所以要用`Math.abs()`
- 注意off by one的bug，比如要用`j<k`, not `j<=k`