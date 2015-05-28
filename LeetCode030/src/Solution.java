import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

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
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}
		HashMap<Integer, Integer> lengthMap = new HashMap<Integer, Integer>();
		int from = 0;
		while (from < s.length()) {
			int start = s.length() - 1;
			for (int i = 0; i < words.length; i ++) {
				int index = s.indexOf(words[i], from);
				if (index != -1) {
					lengthMap.put(index, words[i].length());
					start = start < index ? start : index;
				}
			}
			if (lengthMap.size() != words.length) {
				lengthMap.clear();
				break;
			} else {
				int head = start;
				if (result.contains(start) == false) {
					result.add(start);
				}
				for (Entry<Integer, Integer> pair: lengthMap.entrySet()) {
					int index = pair.getKey();
					int length = pair.getValue();
					if (index != head) {
						result.remove(result.size() - 1);
						break;
					}
					head += length;
				}
//				for (int i = 0; i < words.length; i ++) {
//					from += words[i].length();
//				}
				from ++;
				lengthMap.clear();
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String s1 = "barfoothefoobarman";
		String[] words1 = {"foo", "bar"};
		System.out.println("expected: [0,9], output: " + solution.findSubstring(s1, words1));
		
		String s2 = null;
		String[] words2 = {"1"};
		System.out.println("excepted: [], output: " + solution.findSubstring(s2, words2));
		
		String s3 = "";
		String[] words3 = {"1"};
		System.out.println("excepted: [], output: " + solution.findSubstring(s3, words3));
		
		String s4 = "abcdefg";
		String[] words4 = null;
		System.out.println("excepted: [], output: " + solution.findSubstring(s4, words4));
		
		String s5 = "abcdefg";
		String[] words5 = {};
		System.out.println("excepted: [], output: " + solution.findSubstring(s5, words5));
		
		String s6 = "abcd111de111abfgabcd111abcd";
		String[] words6 = {"abcd", "111"};
		System.out.println("excepted: [0, 16], output: " + solution.findSubstring(s6, words6));
		
		String s7 = "abcdefg";
		String[] words7 = {"cd"};
		System.out.println("excepted: [2], output: " + solution.findSubstring(s7, words7));
		
		String s8 = "abc111defgabc";
		String[] words8 = {"abc", "111"};
		System.out.println("excepted: [0], output: " + solution.findSubstring(s8, words8));
		
		String s9 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words9 = {"fooo","barr","wing","ding","wing"};
		System.out.println("excepted: [13], output: " + solution.findSubstring(s9, words9));
	}
}
