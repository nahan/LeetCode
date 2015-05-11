import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Given n pairs of parentheses, 
 * write a function to generate all combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 */
public class Solution {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < n; i ++) {
			if (result.isEmpty() == true) {
				result.add("()");
			} else {
				List<String> subResult = new ArrayList<String>();
				String currentParenthesis = null;
				for (String item: result) {
					currentParenthesis = item;
					addItems(subResult, addParenthesis(currentParenthesis).iterator());
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
	public static void main(String[] args) {
		Solution solution = new Solution();
		for (int i = 0; i < 11; i ++) {
			System.out.println(solution.generateParenthesis(i));
		}
		
	}
}
