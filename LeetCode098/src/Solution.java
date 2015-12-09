/**
 * Validate Binary Search Tree.
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
    public boolean isValidBST(TreeNode root) {
        boolean flag = true;
        if (root != null && root.left != null) {
            if (root.val <= root.left.val || root.val <= this.lowest(root.left) || root.val <= this.highest(root.left)) {
                return false;
            } else {
                flag = flag && this.isValidBST(root.left);
            }
        }
        if (root != null && root.right != null) {
            if (root.val >= root.right.val || root.val >= this.highest(root.right) || root.val >= this.lowest(root.right)) {
                return false;
            } else {
                flag = flag && this.isValidBST(root.right);
            }
        }
        return flag;
    }
    public int lowest(TreeNode node) {
        if (node.left != null) {
            return lowest(node.left);
        } else {
            return node.val;
        }
    }
    public int highest(TreeNode node) {
        if (node.right != null) {
            return highest(node.right);
        } else {
            return node.val;
        }
    }
}
