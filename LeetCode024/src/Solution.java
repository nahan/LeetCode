
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. 
 * You may not modify the values in the list, only nodes itself can be changed.
 */
public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode pre = head;
		ListNode cur = head;
		ListNode result = head.next;
		ListNode tempNode = cur.next;
		cur.next = tempNode.next;
		tempNode.next = cur;
		pre = cur;
		cur = cur.next;
		while (cur != null) {
			tempNode = cur.next;
			if (tempNode == null) {
				break;
			}
			cur.next = tempNode.next;
			tempNode.next = cur;
			pre.next = tempNode;
			
			pre = cur;
			cur = cur.next;
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
		//node8.next = node1;
		node1.next = node3;
		node3.next = node5;
		node5.next = node7;
		node7.next = node9;
		
		solution.printList(solution.swapPairs(node0));
		//solution.printList(solution.swapPairs(node1));
	}
}
