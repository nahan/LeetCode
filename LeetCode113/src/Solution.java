import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
 * return
		[
		   [5,4,11,2],
		   [5,8,4,5]
		]
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
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		return null;
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
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		TreeNode node01 = new TreeNode(5);
		TreeNode node02 = new TreeNode(4);
		TreeNode node03 = new TreeNode(8);
		TreeNode node04 = new TreeNode(11);
		TreeNode node05 = new TreeNode(13);
		TreeNode node06 = new TreeNode(4);
		TreeNode node07 = new TreeNode(7);
		TreeNode node08 = new TreeNode(2);
		TreeNode node09 = new TreeNode(5);
		TreeNode node10 = new TreeNode(1);
		
		node01.left = node02;
		node01.right = node03;
		
		node02.left = node04;
		
		node03.left = node05;
		node03.right = node06;
		
		node04.left = node07;
		node04.right = node08;
		
		node06.left = node09;
		node06.right = node10;
		
		solution.preOrder(node01);
		System.out.println();
		solution.inOrder(node01);
		System.out.println();
		
		System.out.println(solution.pathSum(node01, 22));
	}
}
