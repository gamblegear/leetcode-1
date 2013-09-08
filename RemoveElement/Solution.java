// Given an array and a value, remove all instances of that value in place and return the new length.

// The order of elements can be changed. It doesn't matter what you leave beyond the new length.

public class Solution {
	public static void main(String[] args) {
		int[] test = {1, 2, 1, 3, 3, 4, 1, 5, 2, 6};

		int res = removeElement(test, 1);

		System.out.println("remain length = " + res);
		for (int i=0; i < res; i++) {
			System.out.println(test[i]);
		}
	}

    public static int removeElement(int[] A, int elem) {
    	int ptr = 0;
    	for(int i = 0; i < A.length; i++) {
    		if (A[i] != elem) {
    			A[ptr++] = A[i];
    		}
    	}
    	return ptr;
    }
}