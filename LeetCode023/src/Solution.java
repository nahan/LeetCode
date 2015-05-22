/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		return null;
	}
	public void printList(ListNode node) {
		if (node != null) {
			System.out.print(node.val + ", ");
			printList(node.next);
		} else {
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		ListNode[] test00 = null;
		
		ListNode node00 = new ListNode(0);
		ListNode[] test01 = {node00};
		
		ListNode node01 = new ListNode(1);
		ListNode node02 = new ListNode(2);
		node01.next = node02;
		ListNode[] test02 = {node01};
		
		ListNode node03 = new ListNode(1);
		ListNode node04 = new ListNode(2);
		node03.next = node04;
		ListNode[] test03 = {node03, node04};
		
		ListNode node011 = new ListNode(0);
		ListNode node022 = new ListNode(3);
		ListNode node033 = new ListNode(6);
		ListNode node044 = new ListNode(9);
		
		node011.next = node022;
		node022.next = node033;
		node033.next = node044;
		ListNode[] test04 = {node011, node022, node033, node044};
		
		ListNode node055 = new ListNode(1);
		ListNode node066 = new ListNode(4);
		ListNode node077 = new ListNode(7);
		ListNode node088 = new ListNode(10);
		
		node055.next = node066;
		node066.next = node077;
		node077.next = node088;
		ListNode[] test05 = {node055, node066, node077, node088};
		
		ListNode node099 = new ListNode(2);
		ListNode node111 = new ListNode(5);
		ListNode node222 = new ListNode(8);
		ListNode node333 = new ListNode(11);
		
		node099.next = node111;
		node111.next = node222;
		node222.next = node333;
		ListNode[] test06 = {node099, node111, node222, node333};
		
		solution.printList(node00);
		solution.printList(node01);
		solution.printList(node011);
		solution.printList(node055);
		solution.printList(node099);
		
		solution.printList(solution.mergeKLists(test00));
		solution.printList(solution.mergeKLists(test01));
		solution.printList(solution.mergeKLists(test02));
		solution.printList(solution.mergeKLists(test03));
		solution.printList(solution.mergeKLists(test04));
		solution.printList(solution.mergeKLists(test05));
		solution.printList(solution.mergeKLists(test06));
	}
}
