
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
	public TreeNode sortedArrayToBST(int[] num) {
		if (num == null || num.length == 0) {
			return null;
		}
		int mid = num.length / 2;
		TreeNode root = new TreeNode(num[mid]);
		root.left = sortedArrayToBST(num, 0, mid - 1);
		root.right = sortedArrayToBST(num, mid + 1, num.length - 1);
		return root;
	}
	public TreeNode sortedArrayToBST(int[] num, int startAt, int endAt) {
		if (num == null || num.length == 0 || endAt < startAt) {
			return null;
		}
		int mid = startAt + (endAt - startAt + 1) / 2;
		TreeNode node = new TreeNode(num[mid]);
		node.left = sortedArrayToBST(num, startAt, mid - 1);
		node.right = sortedArrayToBST(num, mid + 1, endAt);
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
