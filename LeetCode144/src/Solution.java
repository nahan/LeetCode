import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the preorder traversal of its nodes' values.
 * Note: Recursive solution is trivial, could you do it iteratively?
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode top = stack.pop();
            result.add(top.val);
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode node03 = new TreeNode(3);
        TreeNode node01 = new TreeNode(1);
        TreeNode node05 = new TreeNode(5);
        TreeNode node02 = new TreeNode(2);
        TreeNode node04 = new TreeNode(4);
        TreeNode node06 = new TreeNode(6);
        node03.left = node01;
        node03.right = node05;
        node01.right = node02;
        node05.left = node04;
        node05.right = node06;
        System.out.println(solution.preorderTraversal(node03));
    }
}
