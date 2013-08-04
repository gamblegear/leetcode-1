// Implement pow(x, n).

public class Solution {
    public double pow(double x, int n) {
    	if (n < 0) {
    		return 1 / pow(x, -n);
    	}
    	if (n == 0) {
    		return 1;
    	}
    	if (n == 1) {
    		return x;
    	}
    	return n % 2 == 1? x * pow(x, n/2) * pow(x, n/2) :
    		pow(x, n/2) * pow(x, n/2);
    }
}