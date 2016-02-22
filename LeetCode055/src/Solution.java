
public class Solution {
    public boolean canJump(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums == null || nums.length == 0? false: true;
        }
        int i = nums.length - 2;
        int pre = nums.length;
        int minJump = 1;
        while (i > 0) {
            if (nums[i] >= minJump) {
                minJump = 1;
                pre = i + 1;
            } else {
                minJump = pre - i;
            }
            i--;
        }
        return nums[i] >= minJump;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] a = {3,0,8,2,0,0,1};
//        int[] a = {2, 3, 1, 1, 4};
//        int[] a = {3, 2, 1, 0, 4};
        int[] a = {1,0,1,0};
        System.out.println(solution.canJump(a));
    }
}
