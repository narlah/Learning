package interviewPickings.codeFights;

public class RearrangeLastNInLL {
    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        ListNode first = l, second = l;
        if (first == null || n == 0)
            return l;
        for (int i = 0; i < n; i++) {
            if (first.next == null) return l;
            first = first.next;
        }
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        ListNode newRoot = second.next;
        first.next = l;
        second.next = null;
        return newRoot;
    }

}
