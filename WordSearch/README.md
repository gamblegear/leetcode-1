## Problem

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

## Stop and Think

利用dfs的思路，只不过从上下左右查找。

## Solution

    static class Coordinator {
    	int row;
    	int col;
    	public Coordinator(int row, int col) {
    		this.row = row;
    		this.col = col;
    	}
    	@Override
    	public boolean equals(Object object) {
    		Coordinator c = (Coordinator)object;
    		return c.row == this.row && c.col == this.col;
    	}
    	@Override
    	public int hashCode() {
    		StringBuffer buffer = new StringBuffer();
    		buffer.append(row);
    		buffer.append(col);
    		return buffer.toString().hashCode();
    	}
    }

    public static boolean exist(char[][] board, String word) {
    	char first = word.charAt(0);
    	for(int i=0; i < board.length; i++) {
    		for(int j=0; j < board[0].length; j++) {
    			if (board[i][j] == first) {
    				HashSet<Coordinator> used = new HashSet<Coordinator>();
    				if (exist(board, i, j, word.substring(1), used)) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;	    
    }
    
    public static boolean exist(char[][] board, int startRow, int startCol, String word, HashSet<Coordinator> used) {
    	if (word.length() == 0) {
    		return true;
    	}
    	boolean result = false;
    	char c = word.charAt(0);
    	if (startRow - 1 >= 0 && board[startRow - 1][startCol] == c) {
    		Coordinator cc = new Coordinator(startRow - 1, startCol);
    		if(!used.contains(cc)) {
    			used.add(cc);
    			result = result || exist(board, startRow - 1, startCol, word.substring(1), used);
    		}
    	}
    	if (startRow + 1 < board.length && board[startRow + 1][startCol] == c) {
    		Coordinator cc = new Coordinator(startRow + 1, startCol);
    		if(!used.contains(cc)) {
    			used.add(cc);
    			result = result || exist(board, startRow + 1, startCol, word.substring(1), used);
    		}
    	}
    	if (startCol - 1 >= 0 && board[startRow][startCol - 1] == c) {
    		Coordinator cc = new Coordinator(startRow, startCol - 1);
    		if(!used.contains(cc)) {
    			used.add(cc);
				result = result || exist(board, startRow, startCol - 1, word.substring(1), used);		
    		}
    	}
    	if (startCol + 1 < board[0].length && board[startRow][startCol + 1] == c) {
    		Coordinator cc = new Coordinator(startRow, startCol + 1);
    		if(!used.contains(cc)) {
    			used.add(cc);
    			result = result || exist(board, startRow, startCol + 1, word.substring(1), used);
    		}
    	}
    	return result;
    }

## Note

- 要记住已经使用过的char
- 对于custom object的hashset，需要override他们的hashcode和equals method。