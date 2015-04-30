
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
/**
 * You are given two linked lists representing two non-negative numbers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return null;
	}
	public void printList(ListNode node) {
		if (node != null) {
			System.out.print(node.val);
			printList(node.next);
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		ListNode node00 = new ListNode(1);
		ListNode node01 = new ListNode(0);
		ListNode node02 = new ListNode(2);
		ListNode node03 = new ListNode(4);
		
		node00.next = node01;
		node01.next = node02;
		node02.next = node03;
		
		ListNode node04 = new ListNode(2);
		ListNode node05 = new ListNode(0);
		ListNode node06 = new ListNode(4);
		ListNode node07 = new ListNode(8);
		
		node04.next = node05;
		node05.next = node06;
		node06.next = node07;
		
		solution.printList(node00);
		System.out.println();
		solution.printList(node04);
		System.out.println();
		
		solution.printList(solution.addTwoNumbers(node00, node04));
	}
}
