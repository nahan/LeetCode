
import java.util.Comparator;
import java.util.PriorityQueue;

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
class Compare implements Comparator<ListNode> {
	public int compare (ListNode node1, ListNode node2) {
		if (node1.val < node2.val) {
			return -1;
		}
		if (node1.val > node2.val) {
			return 1;
		}
		return 0;
	}
}
public class Solution {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		
		ListNode result = new ListNode(0);
		ListNode resultIndex = result;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(1, new Compare());
		for (int i = 0; i < lists.length; i ++) {
			if (lists[i] != null) {
				heap.add(lists[i]);
			}
		}
		while (heap.isEmpty() == false) {
			resultIndex.next = heap.poll();
			ListNode head = resultIndex.next.next;
			if (head != null) {
				heap.add(head);
			}
			resultIndex = resultIndex.next;
		}
		return result.next;
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
		ListNode[] test03 = {null, node03};
		
		ListNode node011 = new ListNode(0);
		ListNode node022 = new ListNode(3);
		ListNode node033 = new ListNode(6);
		ListNode node044 = new ListNode(9);
		
		node011.next = node022;
		node022.next = node033;
		node033.next = node044;
		
		ListNode node055 = new ListNode(1);
		ListNode node066 = new ListNode(4);
		ListNode node077 = new ListNode(7);
		ListNode node088 = new ListNode(10);
		
		node055.next = node066;
		node066.next = node077;
		node077.next = node088;
		
		ListNode node099 = new ListNode(2);
		ListNode node111 = new ListNode(5);
		ListNode node222 = new ListNode(8);
		ListNode node333 = new ListNode(11);
		
		node099.next = node111;
		node111.next = node222;
		node222.next = node333;
		ListNode[] test04 = {node011, node055, node099};
		
		solution.printList(node00);
		solution.printList(node01);
		solution.printList(node011);
		solution.printList(node055);
		solution.printList(node099);
		
		System.out.println("==============================================");
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(1, new Compare());
		pq.add(new ListNode(5));
		pq.add(new ListNode(4));
		pq.add(new ListNode(0));
		pq.add(new ListNode(2));
		pq.add(new ListNode(1));
		pq.add(new ListNode(100));
		System.out.println(pq.iterator().next().val);
		System.out.println("==============================================");
		
		System.out.println("++++++++++++++++++++++++++++++++++++++ entering test cases");
		System.out.print("expect: \" \" => ");
		solution.printList(solution.mergeKLists(test00));
		System.out.print("expect: \"0, \" => ");
		solution.printList(solution.mergeKLists(test01));
		System.out.print("expect: \"1, 2, \" => ");
		solution.printList(solution.mergeKLists(test02));
		System.out.print("expect: \"1, 2, \" => ");
		solution.printList(solution.mergeKLists(test03));
		System.out.print("expect: \"0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, \" => ");
		solution.printList(solution.mergeKLists(test04));
		System.out.println("-------------------------------------- leaving test cases");
	}
}
