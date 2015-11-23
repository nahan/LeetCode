/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * @author Han
 *
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode item = head;
        while (item != null) {
            length++;
            item = item.next;
        }
        item = head;
        int[] num = new int[length];
        length = 0;
        while (item != null) {
            num[length] = item.val;
            item = item.next;
            length++;
        }
        return this.sortedArrayToBST(num);
    }
    public TreeNode sortedArrayToBST(int[] num) {
        if (num == null || num.length == 0) {
            return null;
        }
        int mid = num.length / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, 0, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, num.length - 1);
        return root;
    }
    public TreeNode sortedArrayToBST(int[] num, int startAt, int endAt) {
        if (num == null || num.length == 0 || endAt < startAt) {
            return null;
        }
        int mid = startAt + (endAt - startAt + 1) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = sortedArrayToBST(num, startAt, mid - 1);
        node.right = sortedArrayToBST(num, mid + 1, endAt);
        return node;
    }
}
