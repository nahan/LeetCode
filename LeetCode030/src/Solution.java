import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string, s, and a list of words, words, *that are all of the same length*. 
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
	@SuppressWarnings("unchecked")
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}
		HashMap<String, Integer> stringNum = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i ++) {
			if (stringNum.containsKey(words[i]) == true) {
				int num = stringNum.get(words[i]);
				stringNum.replace(words[i], num, num + 1);
			} else {
				stringNum.put(words[i], 1);
			}
		}
		HashMap<String, Integer> workHash = (HashMap<String, Integer>) stringNum.clone();
//		System.out.println(stringNum);
		int itemLength = words[0].length();
		int totalLength = itemLength * words.length;
		for (int i = 0; i <= s.length() - totalLength; i ++) {
			String current = s.substring(i, i + totalLength);
//			System.out.println("current string is: " + current);
			if (isConcat(current, itemLength, workHash) == true) {
				result.add(i);
			}
			workHash = (HashMap<String, Integer>) stringNum.clone();
		}
		return result;
	}
	public boolean isConcat(String s, int pace, HashMap<String, Integer> hash) {
		for (int i = 0; i < s.length(); i += pace) {
			String sub = s.substring(i, i + pace);
			if (hash.containsKey(sub) == true && hash.get(sub) >= 0) {
				int num = hash.get(sub);
				hash.replace(sub, num, num - 1);
				if (hash.get(sub) < 0) {
					return false;
				}
			} else {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String s1 = "barfoothefoobarman";
		String[] words1 = {"foo", "bar"};
		System.out.println(s1 + ", expected: [0, 9], output: " + solution.findSubstring(s1, words1));
		
		String s2 = null;
		String[] words2 = {"1"};
		System.out.println(s2 + ", excepted: [], output: " + solution.findSubstring(s2, words2));
		
		String s3 = "";
		String[] words3 = {"1"};
		System.out.println(s3 + ", excepted: [], output: " + solution.findSubstring(s3, words3));
		
		String s4 = "abcdefg";
		String[] words4 = null;
		System.out.println(s4 + ", excepted: [], output: " + solution.findSubstring(s4, words4));
		
		String s5 = "abcdefg";
		String[] words5 = {};
		System.out.println(s5 + ", excepted: [], output: " + solution.findSubstring(s5, words5));
		
		String s6 = "abc111de111abfgabc111abc";
		String[] words6 = {"abc", "111"};
		System.out.println(s6 + ", excepted: [0, 15, 18], output: " + solution.findSubstring(s6, words6));
		
		String s7 = "abcdefg";
		String[] words7 = {"cd"};
		System.out.println(s7 + ", excepted: [2], output: " + solution.findSubstring(s7, words7));
		
		String s8 = "abc111defgabc";
		String[] words8 = {"abc", "111"};
		System.out.println(s8 + ", excepted: [0], output: " + solution.findSubstring(s8, words8));
		
		String s9 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words9 = {"fooo","barr","wing","ding","wing"};
		System.out.println(s9 + ", excepted: [13], output: " + solution.findSubstring(s9, words9));
		
		String s10 = "aaa";
		String[] words10 = {"a", "b"};
		System.out.println(s10 + ", excepted: [], output: " + solution.findSubstring(s10, words10));
		
		String s11 = "aaaaaaaa";
		String[] words11 = {"aa","aa","aa"};
		System.out.println(s11 + ", excepted: [0, 1, 2], output: " + solution.findSubstring(s11, words11));
		
		String s12 = "abababab";
		String[] words12 = {"a","b","a"};
		System.out.println(s12 + ", excepted: [0, 2, 4], output: " + solution.findSubstring(s12, words12));
		
		String s13 = "abaababbaba";
		String[] words13 = {"ab","ba","ab","ba"};
		System.out.println(s13 + ", excepted: [1, 3], output: " + solution.findSubstring(s13, words13));
		
	}
}
