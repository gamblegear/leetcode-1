## Problem
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

Elements in a triplet (a,b,c) must be in non-descending order. (ie, a <= b <= c)
The solution set must not contain duplicate triplets.

For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

- [题目链接](http://leetcode.com/onlinejudge#question_15)

## Stop & Think

此题是 [twosum](https://github.com/zeiga/leetcode/blob/master/twosum/README.md) 的衍生。利用twosum的结果（也就是在linear时间内找到所有等于target的tuples），我们在外面包上一层linear iteration就可以了。

## Solution

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Set<ArrayList<Integer>> buf = new HashSet<ArrayList<Integer>>();
        for (int i=0; i<num.length; i++) {
            int target = 0 - num[i];
            Set<Integer> table = new HashSet<Integer>();
            for (int j=i+1; j<num.length; j++) {
                if (table.contains(target-num[j])) {
                    ArrayList<Integer> k = new ArrayList<Integer>();
                    k.add(num[i]);
                    k.add(num[j]);
                    k.add(target - num[j]);
                    Collections.sort(k);
                    buf.add(k);
                }
                else {
                    table.add(num[j]);
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(buf);
    }

## Note

- 根据题意，不能有duplicate，所以得先用hashset存一下。
- 根据题意，triplet要有序，所以存入hashset之前先sort一下。