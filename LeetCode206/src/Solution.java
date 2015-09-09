/**
 * Reverse a singly linked list.
 * 
 * @author Han
 *
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode index = head;
        ListNode cur = head;
        ListNode pre = null;
        ListNode pos = head.next;
        while (index.next != null) {
            index = pos;
            cur.next = pre;
            pre = cur;
            pos = index.next;
            cur = index;
        }
        cur.next = pre;
        return cur;
    }
    public void print(ListNode node) {
        if (node != null) {
            System.out.print(node.val + " -> ");
            print(node.next);
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node00 = new ListNode(0);
        ListNode node01 = new ListNode(1);
        ListNode node02 = new ListNode(2);
        ListNode node03 = new ListNode(3);
        ListNode node04 = new ListNode(4);
        ListNode node05 = new ListNode(5);
        ListNode node06 = new ListNode(6);
        ListNode node07 = new ListNode(7);
        ListNode node08 = new ListNode(8);
        ListNode node09 = new ListNode(9);
        
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        node06.next = node07;
        node07.next = node08;
        node08.next = node09;
        
        solution.print(node00);
        System.out.println();
        ListNode result = solution.reverseList(node00);
        solution.print(result);
        System.out.println();
    }
}
