import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses. For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
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
	public List<String> generateParenthesis1(int n) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < n; i++) {
			if (result.isEmpty() == true) {
				result.add("()");
			} else {
				List<String> subResult = new ArrayList<String>();
				String currentParenthesis = null;
				for (String item : result) {
					currentParenthesis = item;
					addItems(subResult, addParenthesis(currentParenthesis)
							.iterator());
				}
				result.clear();
				addItems(result, subResult.iterator());
			}
		}
		return result;
	}

	public List<String> addParenthesis(String parenthesis) {
		List<String> result = new ArrayList<String>();
		result.add("()" + parenthesis);
		result.add(parenthesis + "()");
		result.add("(" + parenthesis + ")");
		return result;
	}

	public void addItems(List<String> list, Iterator<String> iterator) {
		while (iterator.hasNext()) {
			String item = iterator.next();
			if (list.contains(item) == false) {
				list.add(item);
			}
		}
	}

	public List<String> generateParenthesisBT(int n) {
		List<String> result = new ArrayList<String>();
		char[] parenthesis = new char[n * 2];
		
		for (int index = 1; index < n; index++) {
			parenthesis[0] = '(';
			for (int i = 1; i < parenthesis.length; i ++) {
				parenthesis[i] = ')';
			}
			System.out.println("here: " + index);
			System.out.println("before: " + charsToString(parenthesis));
			int time = 1;
			findValidPosition(index, parenthesis, result, time);
			System.out.println("after: " + charsToString(parenthesis));
		}
		return result;
	}
	public void findValidPosition(int index, char[] parenthesis, List<String> result, int time) {
		System.out.println(charsToString(parenthesis));
		if (index == parenthesis.length - 1) {
			System.out.println("yes, " + charsToString(parenthesis));
			result.add(charsToString(parenthesis));
			return;
		}
		for (int i = index; i < parenthesis.length - 1; i ++) {
			if (isValid(i, parenthesis, time) == true) {
				parenthesis[i] = '(';
				findValidPosition(i + 1, parenthesis, result, time + 1);
				parenthesis[i] = ')';
			}
		}
	}
	public boolean isValid(int index, char[] parenthesis, int time) {
		if (time > parenthesis.length / 2) {
			return false;
		}
		Stack<Character> temp = new Stack<Character>();
		temp.push(parenthesis[0]);
		for (int i = 1; i < index; i ++) {
			if (parenthesis[i] == '(') {
				temp.push(parenthesis[i]);
			} else {
				if (temp.empty() == true) {
					return false;
				} else {
					temp.pop();
				}
			}
		}
		return temp.contains(')') == false;
	}
	public String charsToString(char[] charList) {
		StringBuilder builder = new StringBuilder();
		for (char item: charList) {
			builder.append(item);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.generateParenthesis(4));

	}
}
