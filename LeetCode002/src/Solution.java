import java.util.Iterator;
import java.util.Stack;


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
		if (l1 == null && l2 == null) {
			return null;
		}
		ListNode result = null;
		if (l1 == null || l2 == null) {
			ListNode first = l1 == null ? l2 : l1;
			result = new ListNode(first.val);
		} else {
			result = new ListNode(l1.val + l2.val);
		}
		
		if (l1 == null) {
			add(null, l2.next, result);
		} else if (l2 == null) {
			add(l1.next, null, result);
		} else {
			add(l1.next, l2.next, result);
		}
		
		normalize(result);
		if (isAllZero(result) == true) {
			result.next = null;
			return result;
		} else {
			result = removeZero(result);
			return result;
		}
	}
	public void add(ListNode l1, ListNode l2, ListNode result) {
		if (l1 == null && l2 != null) {
			result.next = new ListNode(l2.val);
			add(null, l2.next, result.next);
		}
		if (l1 != null && l2 == null) {
			result.next = new ListNode(l1.val);
			add(l1.next, null, result.next);
		}
		if (l1 != null && l2 != null) {
			result.next = new ListNode(l1.val + l2.val);
			add(l1.next, l2.next, result.next);
		}
	}
	public void normalize(ListNode node) {
		if (node != null) {
			if (node.val >= 10) {
				node.val = node.val % 10;
				
				if (node.next == null) {
					node.next = new ListNode(1);
				} else {
					node.next.val += 1;
				}
			}
			normalize(node.next);
		}
	}
	public ListNode removeZero(ListNode node) {
		Stack<ListNode> stack = new Stack<ListNode>();
		ListNode index = node;
		while (index != null) {
			stack.push(index);
			index = index.next;
		}
		ListNode top = stack.peek();
		while (top.val == 0) {
			stack.pop();
			top = stack.peek();
		}
		Iterator<ListNode> iterator = stack.iterator();
		node = iterator.next();
		node.next = null;
		index = node;
		while (iterator.hasNext()) {
			index.next = iterator.next();
			index = index.next;
			index.next = null;
		}
		return node;
	}
	public boolean isAllZero(ListNode node) {
		ListNode index = node;
		while (index != null) {
			if (index.val != 0) {
				return false;
			}
			index = index.next;
		}
		return true;
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
		ListNode node02 = new ListNode(0);
		ListNode node03 = new ListNode(0);
		
		node00.next = node01;
		node01.next = node02;
		node02.next = node03;
		
		ListNode node04 = new ListNode(9);
		ListNode node05 = new ListNode(0);
		ListNode node06 = new ListNode(0);
		ListNode node07 = new ListNode(0);
		
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
