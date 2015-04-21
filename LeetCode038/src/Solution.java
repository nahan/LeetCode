
import java.util.ArrayList;
import java.util.Stack;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class Solution {
	public String countAndSay(int n) {
		if (n <= 0) {
			return null;
		}
		if (n == 1) {
			return "1";
		}
		ArrayList<String> resultArray = new ArrayList<String>();
		int index = 0;
		resultArray.add(index, "1");
		while (index < n) {
			StringBuilder builder = new StringBuilder();
			Stack<Integer> stack = new Stack<Integer>();
			for (int i = resultArray.get(index).length() - 1; i >= 0; i --) {
				stack.push((int)resultArray.get(index).charAt(i) - 48);
			}
			while (!stack.isEmpty()) {
				int sum = 1;
				int top = stack.pop();
				while (!stack.isEmpty() && top == stack.peek()) {
					sum ++;
					top = stack.pop();
				}
				builder.append(sum);
				builder.append(top);
			}
			resultArray.add(builder.toString());
			if (index + 1 == n) {
				break;
			} else {
				index ++;
			}
		}
		return resultArray.get(n - 1);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int test1 = 1;
		int test2 = 2;
		int test3 = 3;
		int test4 = 4;
		int test5 = 5;
		int test6 = 0;
		int test7 = 10;
//		int test8 = 1234567890;
		
		System.out.println(test1 + " -> " + solution.countAndSay(test1));
		System.out.println(test2 + " -> " + solution.countAndSay(test2));
		System.out.println(test3 + " -> " + solution.countAndSay(test3));
		System.out.println(test4 + " -> " + solution.countAndSay(test4));
		System.out.println(test5 + " -> " + solution.countAndSay(test5));
		System.out.println(test6 + " -> " + solution.countAndSay(test6));
		System.out.println(test7 + " -> " + solution.countAndSay(test7));
//		System.out.println(test8 + " is read off as: " + solution.countAndSay(test8));
	}
}
