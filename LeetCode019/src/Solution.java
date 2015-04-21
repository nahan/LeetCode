/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 *  Given linked list: 1->2->3->4->5, and n = 2.
 *  After removing the second node from the end, the linked list becomes 1->2->3->5.
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
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		int size = 0;
		ListNode index = head;
		while (index != null) {
			index = index.next;
			size ++;
		}
		if (n > size) {
			return null;
		}
		if (n == size) {
			head = head.next;
			return head;
		}
		if (size == 1) {
			head = null;
			return head;
		}
		ListNode pre = head;
		ListNode cur = pre.next;
		int i = 2;
		while (i != (size - n + 1)) {
			pre = cur;
			cur = cur.next;
			i ++;
		}
		pre.next = cur.next;
		return head;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		
		ListNode temp = node1;
		while (temp != null) {
			System.out.print(temp.val + " -> ");
			temp = temp.next;
		}
		System.out.println();
		
		ListNode result = solution.removeNthFromEnd(node1, 1);
		if (result == null) {
			System.out.println("cannot remove.");
		} else {
			System.out.println("remove last 1: " + result.val);
		}
	}
}
