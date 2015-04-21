
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}
		ListNode result = l1.val < l2.val ? l1 : l2;
		if (l1.val < l2.val) {
			result = l1;
			result.next = mergeTwoLists(l1.next, l2);
		} else {
			result = l2;
			result.next = mergeTwoLists(l1, l2.next);
		}
		return result;
	}
	public void printList(ListNode list) {
		if (list == null) {
			return;
		}
		for (ListNode index = list; index != null; index = index.next) {
			System.out.print(index.val + " -> ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(8);
		ListNode node9 = new ListNode(9);
		
		node0.next = node2;
		node2.next = node4;
		node4.next = node6;
		node6.next = node8;
		
		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		node7.next = node9;
		
		ListNode result = solution.mergeTwoLists(node0, node1);
		solution.printList(result);
	}
}
