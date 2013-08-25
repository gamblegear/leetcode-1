//Given a m x n matrix, if an element is 0, set its entire row and
// column to 0. Do it in place.

import java.util.*;

public class Solution {
    public void setZeroes(int[][] matrix) {
   		HashSet<Integer> rows = new HashSet<Integer>();
   		HashSet<Integer> cols = new HashSet<Integer>();
   		// scan once
   		for(int i=0; i < matrix.length; i++) {
   			for (int j=0; j < matrix[0].length; j++) {
   				if (matrix[i][j] == 0) {
   					rows.add(i);
   					cols.add(j);
   				}
   			}
   		}
   		// set zeroes rows
   		for(int i=0; i < matrix.length; i++) {
   			for (int j=0; j < matrix[0].length; j++) {
   				if (rows.contains(i) || cols.contains(j)) {
   					matrix[i][j] = 0;
   				}
   			}
   		}
    }
}