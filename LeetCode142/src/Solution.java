/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
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
    public ListNode detectCycle(ListNode head) {
        ListNode onePace = head;
        ListNode twoPaces = head;
        while (onePace != null && twoPaces != null && twoPaces.next != null) {
            onePace = onePace.next;
            twoPaces = twoPaces.next.next;
            if (onePace == twoPaces) {
                onePace = head;
                while (onePace != twoPaces) {
                    onePace = onePace.next;
                    twoPaces = twoPaces.next;
                }
                return onePace;
            }
        }
        return null;
    }
    public ListNode detectCycle0(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            ListNode index = cur;
            while (index != null) {
                index = index.next;
                if (index == cur) {
                    return index;
                }
            }
            cur = cur.next;
        }
        return null;
    }
    public static void main(String[] args) {
        ListNode node00 = new ListNode(3);
        ListNode node01 = new ListNode(2);
        ListNode node02 = new ListNode(0);
        ListNode node03 = new ListNode(-4);
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node01;
        Solution solution = new Solution();
        ListNode result = solution.detectCycle(node00);
        if (result != null) {
            System.out.println(result.val);
        } else {
            System.out.println("null");
        }
    }
}
