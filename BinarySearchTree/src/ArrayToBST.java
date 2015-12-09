
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return nums == null? null: this.sortedArrayToBSTAux(nums, 0, nums.length - 1);
    }
    public TreeNode sortedArrayToBSTAux(int[] nums, int start, int end) {
        TreeNode node = null;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            node = new TreeNode(nums[mid]);
            node.left = this.sortedArrayToBSTAux(nums, start, mid - 1);
            node.right = this.sortedArrayToBSTAux(nums, mid + 1, end);
        }
        return node;
    }
}
