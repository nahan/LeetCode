
public class Solution {
	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	 * If the last word does not exist, return 0.
	 * Note: A word is defined as a character sequence consists of non-space characters only.
	 * For example,
	 * Given s = "Hello World",
	 * return 5.
	 */
	public int lengthOfLastWord(String s) {
		String[] wordArray = s.split(" +");
		if (wordArray.length <= 0) {
			return 0;
		} else {
			String last = wordArray[wordArray.length - 1];
			return last.length();
		}
    }
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = "Hello World";
		String s2 = "";
		String s3 = " ";
		String s4 = "Hello World.";
		String s5 = "Hello";
		String s6 = "World.";
		
		System.out.println(s1 + " -> " + solution.lengthOfLastWord(s1));
		System.out.println(s2 + " -> " + solution.lengthOfLastWord(s2));
		System.out.println(s3 + " -> " + solution.lengthOfLastWord(s3));
		System.out.println(s4 + " -> " + solution.lengthOfLastWord(s4));
		System.out.println(s5 + " -> " + solution.lengthOfLastWord(s5));
		System.out.println(s6 + " -> " + solution.lengthOfLastWord(s6));
		
		System.out.println("Ending");
	}
}
