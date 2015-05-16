import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses. For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */

/**
 * suppose we have a string whose length is less than 2k, 
 * and we know that string can be completed to a string with k pairs of matched parens.
 * How can we extend that string with an additional character
 * so that the resulting string can still be completed to a string with k pairs of matched parens?
 * 
 * There are two possibilities:
 * we add a left parens, or we add a right parens.
 * 
 * 1. If we add a left parens, and still want to complete the string to a string with k pairs of matched parens,
 * it must be that the number of left parens we need is greater than 0;
 * 
 * 2. If we add a right parens, and still want to complete the string to a string with k pairs of matched parens,
 * if must be that the number of left parens we need is less than the number of the needed right parens.
 * i.e., there are unmathced left parens in the string.
 */
public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		directedGenerateBalancedParenthsises(n, n, "", result);
		return result;
	}
	public void directedGenerateBalancedParenthsises(int leftParensNeeded, int rightParensNeeded, String validPrefix, List<String> result) {
		if (leftParensNeeded == 0 && rightParensNeeded == 0) {
			result.add(validPrefix);
			return;
		}
		if (leftParensNeeded > 0) {
			directedGenerateBalancedParenthsises(leftParensNeeded - 1, rightParensNeeded, validPrefix + "(", result);
		}
		if (leftParensNeeded < rightParensNeeded) {
			directedGenerateBalancedParenthsises(leftParensNeeded, rightParensNeeded - 1, validPrefix + ")", result);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generateParenthesis(4));

	}
}
