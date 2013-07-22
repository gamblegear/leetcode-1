import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: zeiga
 * Date: 7/21/13
 * Time: 3:16 PM
 *
 * Given an array S of n integers, find three integers in S such that the sum is
 * closest to a given number, target. Return the sum of the three integers. You may
 * assume that each input would have exactly one solution.
 *
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class Solution {
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
}
