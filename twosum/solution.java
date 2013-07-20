import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: zeiga
 * Date: 7/17/13
 * Time: 10:26 PM
 * To change this template use File | Settings | File Templates.
 *
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2)
 * are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */
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
