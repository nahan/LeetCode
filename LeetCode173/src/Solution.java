import java.util.LinkedList;
import java.util.List;

/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: 
 * next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree.
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
class BSTIterator {
    private List<Integer> list;
    public BSTIterator(TreeNode root) {
        list = new LinkedList<Integer>();
        this.inOrder(list, root);
    }
    private void inOrder(List<Integer> list, TreeNode node) {
        if (node != null) {
            if (node.left != null) {
                this.inOrder(list, node.left);
            }
            list.add(node.val);
            if (node.right != null) {
                this.inOrder(list, node.right);
            }
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !list.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        return list.remove(0);
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
public class Solution {
    
}
