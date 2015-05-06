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
		char[][] board = new char[10][];
		board[0] = new char[] {};
		board[1] = new char[] {};
		board[2] = new char[] {'a', 'b', 'c'};
		board[3] = new char[] {'d', 'e', 'f'};
		board[4] = new char[] {'g', 'h', 'i'};
		board[5] = new char[] {'j', 'k', 'l'};
		board[6] = new char[] {'m', 'n', 'o'};
		board[7] = new char[] {'p', 'q', 'r', 's'};
		board[8] = new char[] {'t', 'u', 'v'};
		board[9] = new char[] {'w', 'x', 'y', 'z'};
		
		printMatrix(board);
		
		return null;
	}
	public void printMatrix(char[][] matrix) {
		for (char[] item: matrix) {
			printArray(item);
		}
	}
	public void printArray(char[] array) {
		for (char item: array) {
			System.out.print(item + ", ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		String test00 = null;
		String test01 = "";
		String test02 = "1";
		String test03 = "2";
		String test04 = "23";
		String test05 = "234";
		String test06 = "23456789";
		
		System.out.println(solution.letterCombinations(test00));
		System.out.println(solution.letterCombinations(test01));
		System.out.println(solution.letterCombinations(test02));
		System.out.println(solution.letterCombinations(test03));
		System.out.println(solution.letterCombinations(test04));
		System.out.println(solution.letterCombinations(test05));
		System.out.println(solution.letterCombinations(test06));
		
	}
}
