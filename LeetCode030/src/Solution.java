import java.util.List;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. 
 * Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once 
 * and without any intervening characters.
 * 
 * For example, given:
 * s: "barfoothefoobarman"
 * words: ["foo", "bar"]
 * 
 * You should return the indices: [0,9].
 * (order does not matter).
 */
public class Solution {
	public List<Integer> findSubstring(String s, String[] words) {
		return null;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "barfoothefoobarman";
		String[] words1 = {"foo", "bar"};
		System.out.println("expected: [0,9] " + solution.findSubstring(s1, words1));
	}

}
