import java.util.List;


/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		return null;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String test00 = null;
		String test01 = "";
		String test02 = "1";
		String test03 = "2";
		String test04 = "23";
		String test05 = "234";
		
		System.out.println(solution.letterCombinations(test00));
		System.out.println(solution.letterCombinations(test01));
		System.out.println(solution.letterCombinations(test02));
		System.out.println(solution.letterCombinations(test03));
		System.out.println(solution.letterCombinations(test04));
		System.out.println(solution.letterCombinations(test05));
		
	}
}
