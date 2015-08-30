
/**
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * 
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
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
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
	
	public void printList(ListNode node) {
		if (node != null) {
			System.out.print(node.val + " -> ");
			this.printList(node.next);
		}
	}
	public static void main(String[] args) {
		System.out.println("Hello World!");
		
		ListNode node0 = new ListNode(0);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		node0.next = node1;
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		
		node5.next = node6;
		
		ListNode node7 = new ListNode(7);
		
		Solution solution = new Solution();
		
		solution.printList(node0);
		System.out.println();
		solution.printList(node5);
		System.out.println();
		solution.printList(node7);
		System.out.println();
	}
}
