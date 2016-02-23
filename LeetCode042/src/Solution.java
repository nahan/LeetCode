
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int sum = 0;
        int level = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                level = Math.max(level, height[left]);
                sum += level - height[left];
                left += 1;
            } else {
                level = Math.max(level, height[right]);
                sum += level - height[right];
                right -= 1;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a0 = null;
        int[] a1 = {};
        int[] a2 = {1};
        int[] a3 = {1, 2};
        int[] a4 = {1, 2, 3};
        int[] a5 = {3, 2, 1};
        int[] a6 = {3, 1, 2};
        int[] a7 = {2, 1, 3};
        int[] a8 = {1, 3, 2};
        int[] a9 = {2, 3, 1};
        int[] a10 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("expected: 0, result: " + solution.trap(a0));
        System.out.println("expected: 0, result: " + solution.trap(a1));
        System.out.println("expected: 0, result: " + solution.trap(a2));
        System.out.println("expected: 0, result: " + solution.trap(a3));
        System.out.println("expected: 0, result: " + solution.trap(a4));
        System.out.println("expected: 0, result: " + solution.trap(a5));
        System.out.println("expected: 1, result: " + solution.trap(a6));
        System.out.println("expected: 1, result: " + solution.trap(a7));
        System.out.println("expected: 0, result: " + solution.trap(a8));
        System.out.println("expected: 0, result: " + solution.trap(a9));
        System.out.println("expected: 6, result: " + solution.trap(a10));
    }
}
