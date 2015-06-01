import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

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
		
		int totalLength = 0;
		HashMap<Integer, Integer> stringHash = new HashMap<Integer, Integer>();
		for (int i = 0; i < words.length; i ++) {
			totalLength += words[i].length();
			stringHash.put(i, -1);
		}
//		System.out.println(stringHash);
		
		// got a two pointers solution!!!!!!!!!!!!!!!!!!!!!!!
		TreeMap<Integer, String> lengthMap = new TreeMap<Integer, String>();
		int from = 0;
		while (from <= s.length() - totalLength) {
//			System.out.println("this time we start from: " + from);
			int headIndex = s.length() - 1;
			int tailIndex = 0;
			for (int i = 0; i < words.length; i ++) {
				int index = findIndex(s, from, words[i], lengthMap);
				if (index != -1) {
					lengthMap.put(index, words[i]);
					headIndex = headIndex < index ? headIndex : index;
					tailIndex = tailIndex > index + words[i].length() ? tailIndex : index + words[i].length();
				}
			}
//			System.out.println(lengthMap);
//			System.out.println("head: " + headIndex + ", tail: " + tailIndex);
			if (lengthMap.size() != words.length) {
				lengthMap.clear();
				break;
			}
			int previousIndex = headIndex;
			StringBuilder subString = new StringBuilder();
			Iterator<String> iter = lengthMap.values().iterator();
			while (iter.hasNext()) {
				String current = iter.next();
				subString.append(current);
				if (s.indexOf(subString.toString(), from) == headIndex) {
					if (subString.toString().length() == totalLength) {
//						System.out.println("got it");
						result.add(headIndex);
						from = previousIndex + current.length();
						lengthMap.clear();
						break;
					} else {
//						System.out.println("continue");
						previousIndex += current.length();
					}
				} else {
//					System.out.println("break here, " + subString.toString() + ", " + s.indexOf(subString.toString()));
					from = previousIndex;
					lengthMap.clear();
					break;
				}
			}
		}
		return result;
	}
	public List<Integer> findSubstring2(String s, String[] words) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0 || words == null || words.length == 0) {
			return result;
		}
		
		int totalLength = 0;
		HashMap<Integer, Integer> stringHash = new HashMap<Integer, Integer>();
		for (int i = 0; i < words.length; i ++) {
			totalLength += words[i].length();
			stringHash.put(i, -1);
		}
//		System.out.println(stringHash);
		
		// got a two pointers solution!!!!!!!!!!!!!!!!!!!!!!!
		
		TreeMap<Integer, String> lengthMap = new TreeMap<Integer, String>();
		int from = 0;
		while (from <= s.length() - totalLength) {
//			System.out.println("this time we start from: " + from);
			int headIndex = s.length() - 1;
			int tailIndex = 0;
			for (int i = 0; i < words.length; i ++) {
				int index = findIndex(s, from, words[i], lengthMap);
				if (index != -1) {
					lengthMap.put(index, words[i]);
					headIndex = headIndex < index ? headIndex : index;
					tailIndex = tailIndex > index + words[i].length() ? tailIndex : index + words[i].length();
				}
			}
//			System.out.println(lengthMap);
//			System.out.println("head: " + headIndex + ", tail: " + tailIndex);
			if (tailIndex - headIndex != totalLength || lengthMap.size() != words.length) {
				from += lengthMap.get(headIndex) != null ? lengthMap.get(headIndex).length() : 1;
				lengthMap.clear();
				continue;
			}
			String subString = "";
			int startIndex = s.length();
			for (Entry<Integer, String> item: lengthMap.entrySet()) {
				subString += item.getValue();
				startIndex = startIndex < item.getKey() ? startIndex : item.getKey();
			}
//			System.out.println(subString);
//			System.out.println(startIndex);
			if (subString.equals("") == false && s.indexOf(subString, from) != -1) {
				result.add(startIndex);
				from = startIndex + subString.length();
//				System.out.println("from: " + from);
			} else {
				from += lengthMap.get(headIndex) != null ? lengthMap.get(headIndex).length() : 1;
			}
			lengthMap.clear();
		}
		return result;
	}
	public int findIndex(String s, int from, String target, TreeMap<Integer, String> hash) {
		if (from >= s.length()) {
			return -1;
		}
		int index = s.indexOf(target, from);
		if (index == -1) {
			return -1;
		}
		if (hash.containsKey(index) == true) {
			return findIndex(s, index + target.length(), target, hash);
		} else {
			return index;
		}
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
		
		String s6 = "abcd111de111abfgabcd111abcd";
		String[] words6 = {"abcd", "111"};
		System.out.println(s6 + ", excepted: [0, 16, 20], output: " + solution.findSubstring(s6, words6));
		
		String s7 = "abcdefg";
		String[] words7 = {"cd"};
		System.out.println(s7 + ", excepted: [2], output: " + solution.findSubstring(s7, words7));
		
		String s8 = "abc111defgabc";
		String[] words8 = {"abc", "111"};
		System.out.println(s8 + ", excepted: [0], output: " + solution.findSubstring(s8, words8));
		
		String s9 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
		String[] words9 = {"fooo","barr","wing","ding","wing"};
		System.out.println(s9 + ", excepted: [13], output: " + solution.findSubstring(s9, words9));
		
	}
}
