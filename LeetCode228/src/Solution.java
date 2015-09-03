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
		if (nums == null || nums.length < 3) {
			if (nums != null && nums.length == 1) {
				result.add(String.valueOf(nums[0]));
			}
			if (nums != null && nums.length == 2) {
				if (nums[0] + 1 == nums[1]) {
					result.add(nums[0] + "->" + nums[1]);
				} else {
					result.add(String.valueOf(nums[0]));
					result.add(String.valueOf(nums[1]));
				}
			}
			return result;
		}
		int index = 1;
		int pre = nums[index - 1];
		int cur = nums[index];
		int pos = nums[index + 1];
		StringBuilder builder = new StringBuilder();
		builder.append(pre);
		while (index + 1 < nums.length) {
			if (pre + 1 == cur && cur + 1 != pos) {
				builder.append("->" + cur);
			} else if (pre + 1 != cur) {
				result.add(builder.toString());
				builder.delete(0, builder.length());
				builder.append(cur);
			}
			if (index + 1 == nums.length - 1) {
				if (cur + 1 == pos) {
					builder.append("->" + pos);
				} else {
					result.add(builder.toString());
					builder.delete(0, builder.length());
					builder.append(pos);
				}
			}
			pre = nums[index ++];
			if (index + 1 == nums.length) {
				break;
			} else {
				cur = nums[index];
				pos = nums[index + 1];
			}
		}
		result.add(builder.toString());
        return result;
    }
	public void printArray(int[] nums) {
		for (int i = 0; i < nums.length; i ++) {
			System.out.print(nums[i] + ", ");
		}
		System.out.println();
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
		
		int[] test05 = {0,1,2,4,5,7,9,10,12,14,15,16,27,28};
		solution.printArray(test05);
		System.out.println(solution.summaryRanges(test05));
		
		int[] test06 = {4,5,7,9};
		solution.printArray(test06);
		System.out.println(solution.summaryRanges(test06));
		
		int[] test07 = {9,10,12,14};
		solution.printArray(test07);
		System.out.println(solution.summaryRanges(test07));
		
		int[] test08 = {9,10,12,14,15,16,27,28};
		solution.printArray(test08);
		System.out.println(solution.summaryRanges(test08));
	}
}
