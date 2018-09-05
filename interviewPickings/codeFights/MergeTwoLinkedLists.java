package interviewPickings.codeFights;


public class MergeTwoLinkedLists {
    public static void main(String[] args) {
        MergeTwoLinkedLists merge = new MergeTwoLinkedLists();
        merge.test();
    }

    private void test() {
        ListNode n1 = new ListNode<>(1);
        n1.next = new ListNode<>(2);
        n1.next.next = new ListNode<>(3);
        ListNode n2 = new ListNode(2);
        n2.next = new ListNode(5);
        ListNode<Integer> res = mergeTwoLinkedLists(n1, n2);
        System.out.print('[');
        while (res != null) {
            System.out.print(res.value + ",");
            res = res.next;
        }
        System.out.print(']');
    }

    ListNode<Integer> mergeTwoLinkedLists(ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> res = new ListNode<>(0);
        ListNode<Integer> tmp = res;
        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                tmp.next = l1;
                l1 = l1.next;
            } else {
                tmp.next = l2;
                l2 = l2.next;
            }
            tmp = tmp.next;
        }
        if (l1 != null) {
            tmp.next = l1;
        }
        if (l2 != null) {
            tmp.next = l2;
        }
        return res.next;
    }

    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> mergeTwoLinkedListsRabbani(ListNode<Integer> l1, ListNode<Integer> l2) { //genius ...
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.value < l2.value) {
            l1.next = mergeTwoLinkedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLinkedLists(l1, l2.next);
            return l2;
        }
    }

}
