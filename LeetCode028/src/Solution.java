
/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author Han
 *
 */

public class Solution {
	public int strStr(String haystack, String needle) {
		if (haystack == null || needle == null || needle.length() > haystack.length()) {
			return -1;
		}
		for (int index = 0; index < haystack.length(); index ++) {
			if (haystack.length() - index < needle.length()) {
				return -1;
			} else {
				if (haystack.substring(index, index + needle.length()).equals(needle)) {
					return index;
				}
			}
		}
		return needle.equals("") ? 0 : -1;
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Solution solution = new Solution();
		
		System.out.println(solution.strStr(null, null) + ", expect: -1.");
		System.out.println(solution.strStr(null, "test") + ", expect: -1.");
		System.out.println(solution.strStr("test", null) + ", expect: 0.");
		System.out.println(solution.strStr("abcde", "test") + ", expect: -1.");
		System.out.println(solution.strStr("abcde", "abcde") + ", expect: 0.");
		System.out.println(solution.strStr("testabcde", "abcde") + ", expect: 4.");
		System.out.println(solution.strStr("abcdefg", "abcd") + ", expect: 0.");
		System.out.println(solution.strStr("abcde", "abcdefg") + ", expect: -1.");
		System.out.println(solution.strStr("", "") + ", expect: 0.");
		
	}
}
