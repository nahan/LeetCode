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
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}
		HashMap<String, Integer> workHash = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i ++) {
			if (workHash.containsKey(words[i]) == true) {
				int number = workHash.get(words[i]);
				workHash.put(words[i], number + 1);
			} else {
				workHash.put(words[i], 1);
			}
		}
		HashMap<String, Integer> originalHash = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i ++) {
			if (originalHash.containsKey(words[i]) == true) {
				int number = originalHash.get(words[i]);
				originalHash.put(words[i], number + 1);
			} else {
				originalHash.put(words[i], 1);
			}
		}
//		System.out.println(workHash);
//		System.out.println(tempHash);
		int singleLength = words[0].length();
		int totalLength = singleLength * words.length;
		int beginIndex = 0;
		int startIndex = 0;
		int from = 0;
		StringBuilder builder = new StringBuilder();
		while (beginIndex <= s.length() - singleLength) {
			String current = s.substring(beginIndex, beginIndex + singleLength);
			System.out.println("current: " + current);
			if (workHash.containsKey(current) == true && workHash.get(current) >= 0) {
				System.out.println("sub-string: " + current);
				int number = workHash.get(current);
				System.out.println("here 1: " + workHash);
				workHash.replace(current, number, number - 1);
				System.out.println("here 2: " + workHash);
				
				builder.append(current);
				System.out.println("temp-string: "+ builder.toString());
				int tempIndex = s.indexOf(builder.toString(), from);
				if (tempIndex != -1) {
					System.out.println("ready!");
					if (workHash.containsValue(-1) == false) {
						System.out.println("got it! ");
						result.add(tempIndex);
					}
					builder.setLength(0);
					beginIndex = tempIndex + 1;
					startIndex = beginIndex;
					from ++;
					
				} else {
					if (builder.toString().length() == totalLength) {
						System.out.println("next");
						builder.setLength(0);
						beginIndex = tempIndex + 1;
						startIndex = beginIndex;
						from ++;
					} else {
						System.out.println("continue");
						beginIndex += singleLength;
					}
					
					workHash.replace(current, number);
				}
				
			} else {
				System.out.println("cancel");
				if (workHash.containsKey(current) == true) {
					int number = workHash.get(current);
					int originalNumber = originalHash.get(current);
					workHash.replace(current, number, originalNumber);
				}
				builder.setLength(0);
				startIndex ++;
				beginIndex = startIndex;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
//		String s1 = "barfoothefoobarman";
//		String[] words1 = {"foo", "bar"};
//		System.out.println(s1 + ", expected: [0, 9], output: " + solution.findSubstring(s1, words1));
//		
//		String s2 = null;
//		String[] words2 = {"1"};
//		System.out.println(s2 + ", excepted: [], output: " + solution.findSubstring(s2, words2));
//		
//		String s3 = "";
//		String[] words3 = {"1"};
//		System.out.println(s3 + ", excepted: [], output: " + solution.findSubstring(s3, words3));
//		
//		String s4 = "abcdefg";
//		String[] words4 = null;
//		System.out.println(s4 + ", excepted: [], output: " + solution.findSubstring(s4, words4));
//		
//		String s5 = "abcdefg";
//		String[] words5 = {};
//		System.out.println(s5 + ", excepted: [], output: " + solution.findSubstring(s5, words5));
//		
//		String s6 = "abc111de111abfgabc111abc";
//		String[] words6 = {"abc", "111"};
//		System.out.println(s6 + ", excepted: [0, 15, 18], output: " + solution.findSubstring(s6, words6));
//		
//		String s7 = "abcdefg";
//		String[] words7 = {"cd"};
//		System.out.println(s7 + ", excepted: [2], output: " + solution.findSubstring(s7, words7));
//		
//		String s8 = "abc111defgabc";
//		String[] words8 = {"abc", "111"};
//		System.out.println(s8 + ", excepted: [0], output: " + solution.findSubstring(s8, words8));
//		
//		String s9 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
//		String[] words9 = {"fooo","barr","wing","ding","wing"};
//		System.out.println(s9 + ", excepted: [13], output: " + solution.findSubstring(s9, words9));
//		
//		String s10 = "aaa";
//		String[] words10 = {"a", "b"};
//		System.out.println(s10 + ", excepted: [], output: " + solution.findSubstring(s10, words10));
//		
//		String s11 = "aaaaaaaa";
//		String[] words11 = {"aa","aa","aa"};
//		System.out.println(s11 + ", excepted: [0, 1, 2], output: " + solution.findSubstring(s11, words11));
		
		String s12 = "abababab";
		String[] words12 = {"a","b","a"};
		System.out.println(s12 + ", excepted: [0, 2, 4], output: " + solution.findSubstring(s12, words12));
		
//		String s13 = "abaababbaba";
//		String[] words13 = {"ab","ba","ab","ba"};
//		System.out.println(s13 + ", excepted: [1, 3], output: " + solution.findSubstring(s13, words13));
		
	}
}
