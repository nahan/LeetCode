import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
public class Solution {
    /**************************** 95. Unique Binary Search Trees II ****************************/
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return this.generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = this.generateTrees(start, i - 1);
            List<TreeNode> rightSubTrees = this.generateTrees(i + 1, end);
            for (TreeNode left: leftSubTrees) {
                for (TreeNode right: rightSubTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
    /**************************** Main ****************************/
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.testGenerateTrees();
    }
    /**************************** Testing Methods ****************************/
    public void testGenerateTrees() {
        for (int i = 0; i < 11; i++) {
            System.out.println(this.generateTrees(i).size());
        }
    }
}
