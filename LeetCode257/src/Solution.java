import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 *       1
 *     /   \
 *    2     3
 *     \
 *      5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 * @author Han
 *
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
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<String>();
		if (root == null) {
			return result;
		}
		
		this.printLeafValue(root);
		System.out.println();
		
		List<TreeNode> nodeList = new ArrayList<TreeNode>();
		getPaths(root, nodeList);
		for (TreeNode item: nodeList) {
			if (item.equals(root)) {
				result.add(String.valueOf(item.val));
			} else {
				result.set(result.size() - 1, result.get(result.size() - 1) + "->" + String.valueOf(item.val));
			}
		}
		return result;
	}
	public void getPaths(TreeNode node, List<TreeNode> list) {
		if (node.left != null) {
			list.add(node);
			getPaths(node.left, list);
		}
		if (node.right != null) {
			list.add(node);
			getPaths(node.right, list);
		}
		if (node.left == null && node.right == null) {
			list.add(node);
		}
	}
	
	public void printLeafValue(TreeNode node) {
		if (node.left != null) {
			System.out.print(node.val + ", ");
			printLeafValue(node.left);
		}
		if (node.right != null) {
			System.out.print(node.val + ", ");
			printLeafValue(node.right);
		}
		
		if (node.left == null && node.right == null) {
			System.out.print(node.val + ", ");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		Solution solution = new Solution();
		TreeNode root = new TreeNode(1);
		TreeNode node00 = new TreeNode(2);
		TreeNode node01 = new TreeNode(3);
		TreeNode node02 = new TreeNode(5);
		TreeNode node03 = new TreeNode(6);
		
		root.left = node00;
		root.right = node01;
		node00.right = node03;
		node00.left = node02;
		
		System.out.println(solution.binaryTreePaths(root));
	}
}
