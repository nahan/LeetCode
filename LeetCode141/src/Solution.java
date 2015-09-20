/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * @author Han
 *
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode one = head;
        ListNode two = head;
        while (one != null && two != null) {
            one = one.next;
            if (two.next != null) {
                two = two.next.next;
            } else {
                return false;
            }
            if (one == two) {
                return true;
            }
        }
        return false;
    }
}
