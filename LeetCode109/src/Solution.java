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
        if (head == null) {
            return null;
        }
        ListNode previous = null;
        ListNode middle = head;
        ListNode tail = head;
        while (tail != null && tail.next != null) {
            previous = middle;
            middle = middle.next;
            tail = tail.next.next;
        }
        TreeNode root = new TreeNode(middle.val);
        if (previous != null) {
            previous.next = null;
        } else {
            head = null;
        }
        root.left = this.sortedListToBST(head);
        root.right = this.sortedListToBST(middle.next);
        return root;
    }
}
