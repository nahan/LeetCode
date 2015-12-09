
public class TreeNode {
    public int value;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
    public TreeNode(int value, TreeNode right, TreeNode left) {
        this.value = value;
        this.right = right;
        this.left = left;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public TreeNode getLeft() {
        return left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }
}
