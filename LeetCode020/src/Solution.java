import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {
	public boolean isValid(String s) {
		if (s == null || s.equals("") || s.length() % 2 != 0) {
			return false;
		}
		boolean flag = false;
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		while (index < s.length()) {
			switch (s.charAt(index)) {
			case '(':
				stack.push(s.charAt(index));
				break;
			case '[':
				stack.push(s.charAt(index));
				break;
			case '{':
				stack.push(s.charAt(index));
				break;
			case ')':
				if (stack.size() != 0 && stack.peek() == '(') {
					stack.pop();
				} else {
					stack.push(s.charAt(index));
				}
				break;
			case ']':
				if (stack.size() != 0 && stack.peek() == '[') {
					stack.pop();
				} else {
					stack.push(s.charAt(index));
				}
				break;
			case '}':
				if (stack.size() != 0 && stack.peek() == '{') {
					stack.pop();
				} else {
					stack.push(s.charAt(index));
				}
				break;
			default:
					break;
			}
			index ++;
		}
		if (stack.size() == 0) {
			flag = true;
		}
		return flag;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String s1 = null;
		String s2 = "";
		String s3 = " ";
		String s4 = "()";
		String s5 = "()[]{}";
		String s6 = "(]";
		String s7 = "([)]";
		String s8 = "([])";
		String s9 = ")}{({))[{{[}";
		
		System.out.println(s1 + " is valid: " + solution.isValid(s1));
		System.out.println(s2 + " is valid: " + solution.isValid(s2));
		System.out.println(s3 + " is valid: " + solution.isValid(s3));
		System.out.println(s4 + " is valid: " + solution.isValid(s4));
		System.out.println(s5 + " is valid: " + solution.isValid(s5));
		System.out.println(s6 + " is valid: " + solution.isValid(s6));
		System.out.println(s7 + " is valid: " + solution.isValid(s7));
		System.out.println(s8 + " is valid: " + solution.isValid(s8));
		System.out.println(s9 + " is valid: " + solution.isValid(s9));
		
	}
}
