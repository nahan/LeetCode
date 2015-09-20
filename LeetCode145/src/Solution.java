import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<Integer>();
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            if (set.contains(node) == false) {
                this.pushChildren(node, stack);
                set.add(node);
            } else {
                result.add(node.val);
            }
        }
        return result;
    }
    public void pushChildren(TreeNode node, Stack<TreeNode> stack) {
        stack.push(node);
        if (node.right != null) {
            stack.push(node.right);
        }
        if (node.left != null) {
            stack.push(node.left);
        }
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
        System.out.println(solution.postorderTraversal(node03));
        
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;
        node2.left = node3;
        System.out.println(solution.postorderTraversal(node1));
    }
}
