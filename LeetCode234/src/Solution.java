
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
		if (head == null || head.next == null) {
			return true;
		}
		
		boolean flag = true;
		int size = getListSize(head);
		
		ListNode first = head;
		ListNode preMid = this.getPreMid(size, head);
		ListNode mid = null;
		ListNode posMid = null;
		
		if (size % 2 == 0) {
			posMid = preMid.next; 
			preMid.next = null;
		} else {
			mid = preMid.next;
			posMid = mid.next;
			preMid.next = null;
			mid.next = null;
		}
		
		ListNode second = this.reverseList(posMid);
		
		ListNode firstIndex = first;
		ListNode secondIndex = second;
		while (firstIndex != null && secondIndex != null) {
			if (firstIndex.val != secondIndex.val) {
				flag = false;
				break;
			}
			firstIndex = firstIndex.next;
			secondIndex = secondIndex.next;
		}
		
		posMid = this.reverseList(second);
		if (mid != null) {
			mid.next = posMid;
			preMid.next = mid;
		} else {
			preMid.next = posMid;
		}
		
		return flag;
    }
	public int getListSize(ListNode head) {
		if (head != null) {
			return this.getListSize(head.next) + 1;
		} else {
			return 0;
		}
	}
	public ListNode getPreMid(int size, ListNode head) {
		int index = 0;
		ListNode pointer = head;
		while (index != size / 2 - 1) {
			pointer = pointer.next;
			index ++;
		}
		return pointer;
	}
	public ListNode reverseList(ListNode head) {
		ListNode pre = head;
		ListNode cur = head;
		ListNode pos = head.next;
		
		pre.next = null;
		while (pos != null) {
			cur = pos;
			pos = pos.next;
			cur.next = pre;
			pre = cur;
		}
		return cur;
	}
	public void print(ListNode node) {
		if (node != null) {
			System.out.print(node.val + " -> ");
			this.print(node.next);
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
		ListNode node04 = new ListNode(2);
		ListNode node05 = new ListNode(1);
		
		node00.next = node01;
		node01.next = node02;
		node02.next = node03;
		node03.next = node04;
		node04.next = node05;
		node05.next = new ListNode(0);
		
		solution.print(node00);
		System.out.println();
//		solution.reversePrint(node00);
//		System.out.println();
		
		System.out.println(solution.isPalindrome(null));
		System.out.println(solution.isPalindrome(node00));
		
		solution.print(node00);
		System.out.println();
//		solution.reversePrint(node00);
//		System.out.println();
	}
}
