class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
public class Solution {
	/**
	 * Given a sorted linked list, delete all duplicates such that each element appear only once.
	 * For example,
	 * Given 1->1->2, return 1->2.
	 * Given 1->1->2->3->3, return 1->2->3.
	 */
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode index = head;
		while (index != null) {
			while (index.next != null && index.val == index.next.val) {
				index.next = index.next.next;
			}
			index = index.next;
		}
		return head;
	}
	public void printList(ListNode head) {
		if (head == null) {
			return;
		}
		ListNode index = head;
		while (index != null) {
			System.out.print(index.val + "->");
			index = index.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		System.out.println("#1: ");
		ListNode node1 = new ListNode(1);
		solution.printList(node1);
		solution.deleteDuplicates(node1);
		solution.printList(node1);
		
		System.out.println("#2: ");
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		node2.next = node3;
		solution.printList(node2);
		solution.deleteDuplicates(node2);
		solution.printList(node2);
		
		System.out.println("#3: ");
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(1);
		ListNode node6 = new ListNode(1);
		node4.next = node5;
		node5.next = node6;
		solution.printList(node4);
		solution.deleteDuplicates(node4);
		solution.printList(node4);
		
		System.out.println("#4: ");
		ListNode node7 = new ListNode(7);
		ListNode node8 = new ListNode(7);
		node7.next = node8;
		solution.printList(node7);
		solution.deleteDuplicates(node7);
		solution.printList(node7);
		
		System.out.println("#5: ");
		ListNode node9 = new ListNode(9);
		ListNode node10 = new ListNode(10);
		ListNode node11 = new ListNode(10);
		node9.next = node10;
		node10.next = node11;
		solution.printList(node9);
		solution.deleteDuplicates(node9);
		solution.printList(node9);
		
		System.out.println("#6: ");
		ListNode node12 = new ListNode(1);
		ListNode node13 = new ListNode(1);
		ListNode node14 = new ListNode(2);
		node12.next = node13;
		node13.next = node14;
		solution.printList(node12);
		solution.deleteDuplicates(node12);
		solution.printList(node12);
		
		System.out.println("Ending");
			
	}
}
