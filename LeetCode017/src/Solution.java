import java.util.ArrayList;
import java.util.HashMap;
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
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() < 2 || (digits.length() == 2 && (digits.contains("0") || digits.contains("1")))) {
			return result;
		}
		
		HashMap<Character, String> boardMap = new HashMap<Character, String>();
		boardMap.put('2', "abc");
		boardMap.put('3', "def");
		boardMap.put('4', "ghi");
		boardMap.put('5', "jkl");
		boardMap.put('6', "mno");
		boardMap.put('7', "pqrs");
		boardMap.put('8', "tuv");
		boardMap.put('9', "wxyz");
		
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
		
//		printMatrix(board);
		
		int resultsNum = 1;
		for (int i = 0; i < digits.length(); i ++) {
			if (digits.charAt(i) == '0' || digits.charAt(i) == '1') {
				continue;
			}
			resultsNum *= board[(int)digits.charAt(i) - 48].length;
		}
		System.out.println("number of results should be: " + resultsNum + ", ");
		
		int digitsIndex = 0;
		while (digits.charAt(digitsIndex) =='0' || digits.charAt(digitsIndex) == '1') {
			digitsIndex ++;
		}
//		System.out.println((int)digits.charAt(digitsIndex) - 48);
		for (int i = 0; i < board[(int)digits.charAt(digitsIndex) - 48].length; i ++) {
			System.out.println(board[(int)digits.charAt(digitsIndex) - 48][i]);
			
		}
		
		for (int i = 0; i < digits.length() - 1; i ++) {
			if (digits.charAt(i) == '0' || digits.charAt(i) == '1') {
				continue;
			}
			
		}
		
		return result;
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
		String test04 = "12";
		String test05 = "123";
		String test06 = "23";
		String test07 = "234";
		String test08 = "23456789";
		
//		System.out.println(solution.letterCombinations(test00));
//		System.out.println(solution.letterCombinations(test01));
//		System.out.println(solution.letterCombinations(test02));
//		System.out.println(solution.letterCombinations(test03));
//		System.out.println(solution.letterCombinations(test04));
//		System.out.println(solution.letterCombinations(test05));
		System.out.println(solution.letterCombinations(test06));
//		System.out.println(solution.letterCombinations(test07));
//		System.out.println(solution.letterCombinations(test08));
		
	}
}
