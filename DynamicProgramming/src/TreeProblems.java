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
public class TreeProblems {
    /**************************** 96. Unique Binary Search Trees ****************************/
    public int numTrees(int n) {
        if (n < 2) {
            return 1;
        }
        int[] catalanNum = new int[n + 1];
        catalanNum[0] = 1;
        catalanNum[1] = 1;
        for (int i = 2; i < catalanNum.length; i++) {
            for (int j = 1; j <= i; j++) {
                catalanNum[i] += catalanNum[j - 1] * catalanNum[i - j];
            }
        }
        return catalanNum[n];
    }
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
        TreeProblems solution = new TreeProblems();
//        solution.testNumTrees();
        solution.testGenerateTrees();
    }
    /**************************** Testing Methods ****************************/
    public void testNumTrees() {
        String output = "input: %d, expected: %d, result: %d\n";
        int[] expected = {1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862};
        for (int i = 0; i < expected.length; i++) {
            System.out.format(output, i, expected[i], this.numTrees(i));
        }
    }
    public void testGenerateTrees() {
        for (int i = 0; i < 11; i++) {
            this.print(this.generateTrees(i).size());
        }
    }
    /**************************** Printing Methods ****************************/
    public void print(int n) {
        System.out.println(n);
    }
    public void print(char ch) {
        System.out.println(ch);
    }
    public void print(String s) {
        System.out.println(s);
    }
    public void print(int[] array) {
        if (array == null) {
            return;
        }
        for (int item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(char[] array) {
        if (array == null) {
            return;
        }
        for (char item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(boolean[] array) {
        if (array == null) {
            return;
        }
        for (boolean item: array) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
    public void print(List<List<Integer>> list) {
        System.out.println(list);
    }
    public void printList(List<String> list) {
        System.out.println(list);
    }
    public void printTrees(List<TreeNode> list) {
        for (TreeNode item: list) {
            this.print(item);
        }
    }
    public void print(TreeNode root) {
        System.out.println("******************* Starting *******************");
        System.out.println("pre-order: ");
        this.preOrder(root);
        System.out.println("\nin-order: ");
        this.inOrder(root);
        System.out.println("\npost-order: ");
        this.postOrder(root);
        System.out.println();
        System.out.println("******************* Ending *******************\n");
    }
    public void preOrder(TreeNode node) {
        System.out.print(node.val + ", ");
        if (node.left != null) {
            this.preOrder(node.left);
        }
        if (node.right != null) {
            this.preOrder(node.right);
        }
    }
    public void inOrder(TreeNode node) {
        if (node.left != null) {
            this.inOrder(node.left);
        }
        System.out.print(node.val + ", ");
        if (node.right != null) {
            this.inOrder(node.right);
        }
    }
    public void postOrder(TreeNode node) {
        if (node.left != null) {
            this.postOrder(node.left);
        }
        if (node.right != null) {
            this.postOrder(node.right);
        }
        System.out.print(node.val + ", ");
    }
}
