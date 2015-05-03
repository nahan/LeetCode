
/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 */
public class Solution {
	public int maxArea(int[] height) {
		if (height == null || height.length < 2 || (height.length == 2 && (height[0] == 0 || height[1] == 0))) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < height.length - 1; i ++) {
			for (int j = i + 1; j < height.length; j ++) {
				int area = getArea(i, height[i], j, height[j]);
				max = Math.max(max, area);
			}
		}
		return max;
	}
	
	public int maxArea1(int[] height) {
		if (height == null || height.length < 2 || (height.length == 2 && (height[0] == 0 || height[1] == 0))) {
			return 0;
		}
		int max = 0;
		int front = 0;
		int tail = 1;
		while (tail < height.length && front < tail) {
			int area = getArea(front, height[front], tail, height[tail]);
			max = Math.max(max, area);
			if (tail - front == 1) {
				tail ++;
			} else if (tail - front == 2) {
				front ++;
			}
		}
		front = 0;
		tail = height.length - 1;
		while (front < height.length - 2) {
			int area = getArea(front, height[front], tail, height[tail]);
			max = Math.max(max, area);
			front ++;
		}
		return max;
	}
	public int getArea(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * Math.min(y1, y2);
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test00 = null;
		int[] test01 = {};
		int[] test02 = {1};
		int[] test03 = {0, 9};
		int[] test04 = {1, 3};
		int[] test05 = {15000,14999,14998,14997,14996,14995,14994,14993,14992,14991,14990,14989,14988,14987,14986,14985,14984,14983};
		System.out.println("Max Area: " + solution.maxArea(test00));
		System.out.println("Max Area: " + solution.maxArea(test01));
		System.out.println("Max Area: " + solution.maxArea(test02));
		System.out.println("Max Area: " + solution.maxArea(test03));
		System.out.println("Max Area: " + solution.maxArea(test04));
		System.out.println("Max Area: " + solution.maxArea(test05));
		
		System.out.println("//////////////////////////////");
		
		System.out.println("Max Area: " + solution.maxArea1(test00));
		System.out.println("Max Area: " + solution.maxArea1(test01));
		System.out.println("Max Area: " + solution.maxArea1(test02));
		System.out.println("Max Area: " + solution.maxArea1(test03));
		System.out.println("Max Area: " + solution.maxArea1(test04));
		System.out.println("Max Area: " + solution.maxArea1(test05));
	}
}
