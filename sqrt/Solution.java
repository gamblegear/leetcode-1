// Implement int sqrt(int x).

// Compute and return the square root of x.

public class Solution {
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
}