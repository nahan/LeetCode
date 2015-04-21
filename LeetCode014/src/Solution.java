
/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null) {
			return null;
		}
		if (strs.length == 0) {
			return "";
		}
		if (strs.length == 1) {
			return strs[0];
		}
		int minLength = strs[0].length();
		for (int index = 1; index < strs.length; index ++) {
			minLength = Math.min(minLength, strs[index].length());
		}
		if (minLength == 0) {
			return "";
		}
		StringBuilder prefix = new StringBuilder();
		int index = 0;
		while (index < minLength) {
			boolean flag = true;
			for (int i = 1; i < strs.length; i ++) {
				if (strs[i].charAt(index) != strs[0].charAt(index)) {
					flag = false;
					break;
				}
				if (i == strs.length - 1) {
					prefix.append(strs[i].charAt(index));
				}
			}
			if (flag == true) {
				index ++;
			} else {
				break;
			}
		}
		return prefix.toString();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String[] test1 = {"abc","abcd", "abcd"};
		String[] test2 = {"a","b", "c"};
		String[] test3 = {"c", "c"};
		String[] test4 = {"aa", "ab"};
		String[] test5 = {"abc", "atef", "cbda", "nnce"};
		String[] test6 = {"a", "a", "b"};
		String[] test7 = {"aca", "cba"};
		System.out.println("1. the longest common prefix is: " + solution.longestCommonPrefix(test1));
		System.out.println("2. the longest common prefix is: " + solution.longestCommonPrefix(test2));
		System.out.println("3. the longest common prefix is: " + solution.longestCommonPrefix(test3));
		System.out.println("4. the longest common prefix is: " + solution.longestCommonPrefix(test4));
		System.out.println("5. the longest common prefix is: " + solution.longestCommonPrefix(test5));
		System.out.println("6. the longest common prefix is: " + solution.longestCommonPrefix(test6));
		System.out.println("6. the longest common prefix is: " + solution.longestCommonPrefix(test7));
	}
}
