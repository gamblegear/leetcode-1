## Problem

Given an array of integers, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

You may assume that each input would have exactly one solution.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2

## Stop & Think

首先容易想到的方法是先sort然后从两头scan towards each other，但是这样时间复杂度是 *O(nlog(n))*
然后想到从data structure上优化，用Dictionary，这样只要scan一次。如下code，不多作解释了。

## My Solution

		public class twosum {
		    public int[] twoSum(int[] numbers, int target) {
		        Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		        for (int i=0; i < numbers.length; i++) {
		            if (table.containsKey(target - numbers[i])) {
		                return new int[] { table.get(target - numbers[i]) + 1, i + 1 };
		            }
		            table.put(numbers[i], i);
		        }
		        return null;
		    }
		}

## Note

- 因为要返回index，所以用dictionary的value来存index。
