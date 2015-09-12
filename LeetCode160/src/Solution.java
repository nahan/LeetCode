
/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 -> a2
 *                     |
 *                     c1 -> c2 -> c3
 *                     |           
 * B:     b1 -> b2 -> b3
 * begin to intersect at node c1.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int length1 = this.getLength(headA);
        int length2 = this.getLength(headB);
        if (length1 > length2) {
            return this.getIntersectionNode(headB, headA);
        }
        int gap = length2 - length1;
        ListNode index1 = headA;
        ListNode index2 = headB;
        for (int i = 0; i < gap; i++) {
            index2 = index2.next;
        }
        while (index1 != null && index2 != null) {
            if (index1.val == index2.val) {
                return index1;
            }
            index1 = index1.next;
            index2 = index2.next;
        }
        return null;
    }
    public int getLength(ListNode node) {
        if (node != null) {
            return getLength(node.next) + 1;
        } else {
            return 0;
        }
    }
    public void print(ListNode node) {
        ListNode index = node;
        while (index != null) {
            System.out.print(index.val + " -> ");
            index = index.next;
        }
        System.out.println();
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
        ListNode node10 = new ListNode(10);
        ListNode node11 = new ListNode(11);
        
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        
        node07.next = node08;
        node08.next = node09;
        node09.next = node10;
        node10.next = node11;
        
        node11.next = node04;
        
        System.out.println(solution.getIntersectionNode(null, null));
        System.out.println(solution.getIntersectionNode(node00, null));
        System.out.println(solution.getIntersectionNode(null, node00));
        
        solution.print(node00);
        solution.print(node07);
        
        System.out.format("length is: %d\n", solution.getLength(node00));
        System.out.format("length is: %d\n", solution.getLength(node07));
        
        System.out.format("Expect: 4, Output: %d\n", solution.getIntersectionNode(node00, node07).val);
        System.out.format("Expect: 4, Output: %d\n", solution.getIntersectionNode(node07, node00).val);
        
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        node06.next = null;
        
        node07.next = node08;
        node08.next = node09;
        node09.next = node10;
        node10.next = node11;
        node11.next = null;
        
        System.out.println("Expect: null, Output: " + solution.getIntersectionNode(node07, node00));
        System.out.println("Expect: null, Output: " + solution.getIntersectionNode(node00, node07));
        
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        node06.next = null;
        
        node07.next = node08;
        node08.next = node09;
        node09.next = node10;
        node10.next = node11;
        node11.next = node00;
        
        System.out.format("Expect: 0, Output: %d\n", solution.getIntersectionNode(node00, node07).val);
        System.out.format("Expect: 0, Output: %d\n", solution.getIntersectionNode(node07, node00).val);
        
        node00.next = node01;
        node01.next = node02;
        node02.next = node03;
        node03.next = node04;
        node04.next = node05;
        node05.next = node06;
        node06.next = null;
        
        node07.next = node08;
        node08.next = node09;
        node09.next = node10;
        node10.next = node11;
        node11.next = node06;
        
        System.out.format("Expect: 6, Output: %d\n", solution.getIntersectionNode(node00, node07).val);
        System.out.format("Expect: 6, Output: %d\n", solution.getIntersectionNode(node07, node00).val);
    }
}
