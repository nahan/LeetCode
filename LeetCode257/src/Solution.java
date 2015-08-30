import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * 1 / \ 2 3 \ 5
 *
 * All root-to-leaf paths are: ["1->2->5", "1->3"]
 * 
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
		List<List<TreeNode>> nodeResult = new ArrayList<List<TreeNode>>();
		List<TreeNode> nodePath = new ArrayList<TreeNode>();
		this.buildPath(root, nodePath, nodeResult);
		for (List<TreeNode> item: nodeResult) {
			System.out.println(item.size());
		}
		result = this.toStringPath(result, nodeResult);
		return result;
	}

	public void buildPath(TreeNode node, List<TreeNode> path, List<List<TreeNode>> result) {
		path.add(node);
		if (node.left == null && node.right == null) {
			Iterator<TreeNode> iterator = path.iterator();
			List<TreeNode> temp = new ArrayList<TreeNode>();
			while (iterator.hasNext()) {
				temp.add(iterator.next());
			}
			result.add(temp);
		}
		if (node.left != null) {
			this.buildPath(node.left, path, result);
		}
		if (node.right != null) {
			this.buildPath(node.right, path, result);
		}
		if (path.size() > 1) {
			path.remove(path.size() - 1);
		}
	}
	
	public List<String> toStringPath(List<String> list, List<List<TreeNode>> nodes) {
		for (int index = 0; index < nodes.size(); index ++) {
			if (nodes.get(index).size() == 1) {
				list.add(Integer.toString(nodes.get(index).get(0).val));
			} else {
				list.add(this.addArrow(nodes.get(index)));
			}
		}
		System.out.println(list);
		return list;
	}
	
	public String addArrow(List<TreeNode> nodes) {
		StringBuilder builder = new StringBuilder();
		for (int index = 0; index < nodes.size(); index ++) {
			builder.append(nodes.get(index).val);
			if (index != nodes.size() - 1) {
				builder.append("->");
			}
		}
		return builder.toString();
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
