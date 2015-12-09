
/**
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 */
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
public class Solution {
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
	public void preOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.val + ", ");
		if (root.left != null) {
			preOrder(root.left);
		}
		if (root.right != null) {
			preOrder(root.right);
		}
	}
	public void inOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			inOrder(root.left);
		}
		System.out.print(root.val + ", ");
		if (root.right != null) {
			inOrder(root.right);
		}
	}
	public void leftPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			leftPrint(root.left);
		}
		System.out.print(root.val + " -> ");
	}
	public void rightPrint(TreeNode root) {
		if (root == null) {
			return;
		}
		if (root.right != null) {
			rightPrint(root.right);
		}
		System.out.print(root.val + " -> ");
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		TreeNode node01 = new TreeNode(1);
		TreeNode node02 = new TreeNode(2);
		TreeNode node03 = new TreeNode(3);
		node02.left = node01;
		node02.right = node03;
		
		solution.preOrder(node02);
		System.out.println();
		solution.inOrder(node02);
		System.out.println();
		
		int[] array01 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		TreeNode node04 = solution.sortedArrayToBST(array01);
		
		solution.preOrder(node04);
		System.out.println();
		solution.inOrder(node04);
		System.out.println();
		solution.leftPrint(node04);
		System.out.println();
		solution.rightPrint(node04);
		System.out.println();
		
		int[] array02 = null;
		TreeNode node05 = solution.sortedArrayToBST(array02);
		solution.preOrder(node05);
		System.out.println();
		solution.inOrder(node05);
		System.out.println();
	}
}
