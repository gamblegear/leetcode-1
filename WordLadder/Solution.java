// Word Ladder
// Given two words (start and end), and a dictionary, find the length 
// of shortest transformation sequence from start to end, such that:

// Only one letter can be changed at a time
// Each intermediate word must exist in the dictionary
// For example,

// Given:
// start = "hit"
// end = "cog"
// dict = ["hot","dot","dog","lot","log"]

// As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.

// Note:

// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
import java.util.*;

public class Solution {
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<String>();
		
		//dict.add("dot");
		dict.add("dog");
		dict.add("hot");
		//dict.add("log");

		System.out.println(ladderLength("hot", "dog", dict));
	}

	static class Word {
		public String str;
		public Word prevStr;
		Word(String str, Word prevStr) {
			this.str = str;
			this.prevStr = prevStr;
		}
	}

    public static int ladderLength(String start, String end, HashSet<String> dict) {
		start = start.toLowerCase();
		end = end.toLowerCase();
		Queue<Word> buffer = new LinkedList<Word>();
        HashSet<String> visited = new HashSet<String>();
        
        buffer.offer(new Word(start, null));
        visited.add(start);
        Word w = null; 
        
        while (!buffer.isEmpty()) {
            w = buffer.poll();
            if (w.str.equals(end)) {
                break;
            }
            ArrayList<String> nextWords = getNextAvailableWords(w.str, dict);
            if (nextWords.size() == 0) {
                return 0;
            }
            for(String s:nextWords) {
                if (!visited.contains(s)) {
                    buffer.offer(new Word(s, w));
                    visited.add(s);
                }
            }
        }
        if (w.str == start) {
        	return 0;
        }

        // back track
        int numTrans = 0;
        while(w != null) {
            numTrans++;
            w = w.prevStr;
        }
        return numTrans; 
    }

    public static ArrayList<String> getNextAvailableWords(String w, HashSet<String> dict) {
        ArrayList<String> followers = new ArrayList<String>();
        for (int i = 0; i < w.length(); i++) {
            char[] wordArr = w.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != wordArr[i]) {
                    wordArr[i] = c;
                    String str = new String(wordArr);
                    if (dict.contains(str))
                        followers.add(str);
                }
            }
        }
        return followers;
    }
}