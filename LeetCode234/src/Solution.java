
/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
	public boolean isPalindrome(ListNode head) {
		return false;
    }
	public void print(ListNode node) {
		if (node != null) {
			System.out.print(node.val + " -> ");
			this.print(node.next);
			System.out.print(node.val + " -> ");
		}
	}
	public void reversePrint(ListNode node) {
		if (node.next != null) {
			this.reversePrint(node.next);
		}
		System.out.print(node.val + " -> ");
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		ListNode node00 = new ListNode(0);
		ListNode node01 = new ListNode(1);
		ListNode node02 = new ListNode(2);
		ListNode node03 = new ListNode(3);
		ListNode node04 = new ListNode(4);
		ListNode node05 = new ListNode(5);
		
		node00.next = node01;
		node01.next = node02;
		node02.next = node03;
		node03.next = node04;
		node04.next = node05;
		
		solution.print(node00);
		System.out.println();
		//solution.reversePrint(node00);
		System.out.println();
		
		System.out.println(solution.isPalindrome(null));
		System.out.println(solution.isPalindrome(node00));
	}
}
