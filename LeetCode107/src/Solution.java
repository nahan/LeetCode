import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        if (root == null) {
            return result;
        }
        ArrayList<TreeNode> array = new ArrayList<TreeNode>();
        ArrayList<TreeNode> buff = new ArrayList<TreeNode>();
        array.add(root);
        while (array.size() != 0) {
            ArrayList<Integer> item = new ArrayList<Integer>();
            while (array.size() != 0) {
                item.add(array.get(0).val);
                buff.add(array.get(0));
                array.remove(0);
            }
            while (buff.size() != 0) {
                if (buff.get(0).left != null) {
                    array.add(buff.get(0).left);
                }
                if (buff.get(0).right != null) {
                    array.add(buff.get(0).right);
                }
                buff.remove(0);
            }
            result.addFirst(item);
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        Solution solution = new Solution();
        TreeNode node00 = null;
        TreeNode node01 = new TreeNode(0);
        TreeNode node02 = new TreeNode(1);
        TreeNode node03 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        
        node01.left = node02;
        node01.right = node03;
        
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        
        System.out.println(solution.levelOrderBottom(node00));
        System.out.println(solution.levelOrderBottom(node01));
        System.out.println(solution.levelOrderBottom(node3));
    }
}
