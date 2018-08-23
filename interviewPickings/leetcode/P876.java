package interviewPickings.leetcode;

public class P876 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode middleNode(ListNode head) {
        if (head.next == null) return head;
        ListNode first = head.next;
        ListNode second = head;
        do {
            second = second.next;
            if (first.next == null || first.next.next == null) break;
            first = first.next.next;
        } while (true);
        return second;
    }
    /*
    Editors choice :
      public ListNode middleNode(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
     */

}
