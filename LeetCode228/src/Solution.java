import java.util.ArrayList;
import java.util.List;


/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * For example, 
 * 
 * given [0,1,2,4,5,7], 
 * return ["0->2","4->5","7"].
 * 
 * @author Han
 *
 */
public class Solution {
	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<String>();
		if (nums == null || nums.length < 2) {
			if (nums != null && nums.length == 1) {
				result.add(String.valueOf(nums[0]));
			}
			return result;
		}
		
		int index = 1;
		int pre = nums[index - 1];
		int cur = nums[index];
		StringBuilder builder = new StringBuilder();
		builder.append(pre);
		
		while (index < nums.length) {
			pre = nums[index - 1];
			cur = nums[index];
			if (pre + 1 != cur) {
				builder.append("->" + pre);
				result.add(builder.toString());
				builder = new StringBuilder();
				builder.append(cur);
			}
			index ++;
		}
		result.add(builder.toString());
        return result;
    }
	public void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i ++) {
			System.out.print(nums[i] + ", ");
		}
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		Solution solution = new Solution();
		System.out.println(solution.summaryRanges(null));
		System.out.println(solution.summaryRanges(new int[0]));
		System.out.println(solution.summaryRanges(new int[1]));
		
		int[] test00 = {0, 1, 2, 4, 5, 7};
		solution.printArray(test00);
		System.out.println(solution.summaryRanges(test00));
		
		int[] test01 = {};
		solution.printArray(test01);
		System.out.println(solution.summaryRanges(test01));
		
		int[] test02 = {-1};
		solution.printArray(test02);
		System.out.println(solution.summaryRanges(test02));
		
		int[] test03 = {1, 2};
		solution.printArray(test03);
		System.out.println(solution.summaryRanges(test03));
		
		int[] test04 = {1, 3};
		solution.printArray(test04);
		System.out.println(solution.summaryRanges(test04));
	}
}
