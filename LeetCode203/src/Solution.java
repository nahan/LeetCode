
/**
 * Remove all elements from a linked list of integers that have value val.
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
public class Solution {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		ListNode current = head;
		ListNode previous = current;
		while (current != null) {
			if (head.val == val) {
				head = head.next;
			}
			if (current.val == val) {
				previous.next = current.next;
			} else {
				previous = current;
			}
			current = current.next;
		}
		return head;
	}
	public void printList(ListNode head) {
		for (ListNode index = head; index != null; index = index.next) {
			System.out.print(index.val + " -> ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		// test null.
		System.out.println("Case 1. -> 0 ++++++++++++++++++++++++");
		solution.printList(null);
		solution.printList(solution.removeElements(null, 0));
		
		// test one node on head.
		System.out.println("Case 2. -> 0 ++++++++++++++++++++++++");
		ListNode node01 = new ListNode(0);
		solution.printList(node01);
		solution.printList(solution.removeElements(node01, 0));
		
		// test two nodes on head.
		System.out.println("Case 3. -> 0 ++++++++++++++++++++++++");
		ListNode node02 = new ListNode(0);
		node02.next = new ListNode(1);
		solution.printList(node02);
		solution.printList(solution.removeElements(node02, 0));
		
		// test three nodes on tail.
		System.out.println("Case 4. -> 2 ++++++++++++++++++++++++");
		ListNode node03 = new ListNode(0);
		node03.next = new ListNode(1);
		node03.next.next = new ListNode(2);
		solution.printList(node03);
		solution.printList(solution.removeElements(node03, 2));
		
		// test four nodes on both head and tail.
		System.out.println("Case 5. -> 0 ++++++++++++++++++++++++");
		ListNode node04 = new ListNode(0);
		node04.next = new ListNode(1);
		node04.next.next = new ListNode(2);
		node04.next.next.next = new ListNode(0);
		solution.printList(node04);
		solution.printList(solution.removeElements(node04, 0));
		
		// test four nodes on middles.
		System.out.println("Case 6. -> 1 ++++++++++++++++++++++++");
		ListNode node05 = new ListNode(0);
		node05.next = new ListNode(1);
		node05.next.next = new ListNode(1);
		node05.next.next.next = new ListNode(3);
		solution.printList(node05);
		solution.printList(solution.removeElements(node05, 1));
		
		// test four nodes on both head and middle.
		System.out.println("Case 7. -> 0 ++++++++++++++++++++++++");
		ListNode node06 = new ListNode(0);
		node06.next = new ListNode(0);
		node06.next.next = new ListNode(1);
		node06.next.next.next = new ListNode(3);
		solution.printList(node06);
		solution.printList(solution.removeElements(node06, 0));
		
	}
}
