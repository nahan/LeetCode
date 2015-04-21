
import java.util.Hashtable;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2. 
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 *
 */
public class Solution {
	public int[] twoSum(int[] numbers, int target) {
		int[] result = new int[2];
		Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
		for (int index = 0; index < numbers.length; index ++) {
			hash.put(numbers[index], index);
		}
		
		for (int index = 0; index < numbers.length; index ++) {
			if (hash.containsKey(target - numbers[index]) && hash.get(target - numbers[index]) != index) {
				result[0] = index + 1;
				result[1] = hash.get(target - numbers[index]) + 1;
				break;
			}
		}
		return result;
	}
	public void printArray(int[] array) {
		if (array != null) {
			for (int item: array) {
				System.out.print(item + ", ");
			}
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array1 = {1, 2, 3, 4, 5};
		int[] array2 = {2, 7, 11, 15};
		int[] array3 = {3, 2, 4};
		int[] array4 = {0, 4, 3, 0};
		
		System.out.print("Input: 3 -> ");
		solution.printArray(array1);
		System.out.print("Output: ");
		solution.printArray(solution.twoSum(array1, 3));
		
		System.out.print("Input: 9 -> ");
		solution.printArray(array2);
		System.out.print("Output: ");
		solution.printArray(solution.twoSum(array2, 9));
		
		System.out.print("Input: 6 -> ");
		solution.printArray(array3);
		System.out.print("Output: ");
		solution.printArray(solution.twoSum(array3, 6));
		
		System.out.print("Input: 0 -> ");
		solution.printArray(array4);
		System.out.print("Output: ");
		solution.printArray(solution.twoSum(array4, 0));
	}
}
