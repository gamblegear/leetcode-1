## Problem

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

## Stop and Think

先扫一边matrix，得到哪些rows，哪些cols有0出现。然后再循环一边设置0。

## Solution

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

## Note

- 这题的space是 O(m+n)
- 如果要追求constant space solution呢？ 似乎可以这样：也是一行一行的扫，当当前的cursor值是0的时候就像炸弹人那样横竖都set zeros，然后继续。