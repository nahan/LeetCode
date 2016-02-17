class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode lastOdd = head;
        ListNode lastEven = head.next;
        ListNode newOdd = lastEven.next;
        while (newOdd != null) {
            lastEven.next = newOdd.next;
            newOdd.next = lastOdd.next;
            lastOdd.next = newOdd;
            lastOdd = newOdd;
            lastEven = lastEven.next;
            if (lastEven == null) {
                newOdd = lastEven;
            } else {
                newOdd = lastEven.next;
            }
        }
        return head;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.oddEvenList(null);
    }
}
