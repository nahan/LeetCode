import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
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
class MinHeap {
	private ArrayList<ListNode> nodes;
	private int size = 0;
	public MinHeap(int length) {
		nodes = new ArrayList<ListNode>(length);
		for (int index = 0; index < length; index ++) {
			nodes.add(index, null);
		}
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean containsNodeAtIndex(int index) {
		return nodes.get(index) != null;
	}
	public void insertNodeAtIndex(int index, ListNode node) {
		size ++;
		nodes.set(index, node);
//		swim(size);
	}
	public ListNode getMin() {
		return nodes.get(0);
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
		ListNode result = null;
		ListNode resultIndex = result;
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>();
		for (int i = 0; i < lists.length; i ++) {
			
		}
		return result;
	}
	public boolean isEmpty(ListNode[] pq) {
		for (ListNode item: pq) {
			if (item != null) {
				return false;
			}
		}
		return true;
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
		pq.add(new ListNode(0));
		System.out.println(pq.iterator().next().val);
		
		ArrayList<ListNode> test = new ArrayList<ListNode>(3);
		for (int i = 0; i < 3; i ++) {
			test.add(null);
		}
		System.out.println("size is: " + test.size());
		test.set(1, new ListNode(0));
		System.out.println("size is: " + test.size());
		test.set(2, new ListNode(1));
		System.out.println("size is: " + test.size());
		test.set(2, new ListNode(2));
		System.out.println("size is: " + test.size());
		test.set(0, new ListNode(3));
		System.out.println("size is: " + test.size());
		Iterator<ListNode> it = test.iterator();
		while (it.hasNext()) {
			System.out.print(it.next().val + ", ");
		}
		
		
//		System.out.println("++++++++++++++++++++++++++++++++++++++ entering test cases");
//		System.out.print("expect: \" \" => ");
//		solution.printList(solution.mergeKLists(test00));
//		System.out.print("expect: \"0, \" => ");
//		solution.printList(solution.mergeKLists(test01));
//		System.out.print("expect: \"1, 2, \" => ");
//		solution.printList(solution.mergeKLists(test02));
//		System.out.print("expect: \"1, 2, \" => ");
//		solution.printList(solution.mergeKLists(test03));
//		System.out.print("expect: \"0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, \" => ");
//		solution.printList(solution.mergeKLists(test04));
//		System.out.println("-------------------------------------- leaving test cases");
	}
}
