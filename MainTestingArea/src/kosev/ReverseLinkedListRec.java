package kosev;

public class ReverseLinkedListRec {
    public static ListNode reverse(ListNode list) {
        if (list == null)
            return null; // first question

        if (list.next == null)
            return list; // second question

        // so we grab the second element (which will be the last after we
        // reverse it
        ListNode secondElem = list.next;

        // bug fix - need to unlink list from the rest or you will get a cycle
        list.next = null;

        // then we reverse everything from the second element on
        ListNode reverseRest = reverse(secondElem);

        // then we join the two lists
        secondElem.next = list;

        return reverseRest;
    }

    public static void main(String[] args) {
        int[] array = {2, 6, 9, 12, 14, 19, 5};
        ListNode root = new ListNode(21, null);
        ListNode current = root;
        for (int a : array) {
            ListNode newOne = new ListNode(a, null);
            current.next = newOne;
            current = newOne;
        }
        printList(root, "Initial Condition");
        ListNode newRoot = reverse(root);
        printList(newRoot, "Reversed");

    }

    public static void printList(ListNode root, String msg) {
        if (root == null) {
            System.out.println(String.format("%1$20s", "Empty list ") + " : " + msg);
            return;
        }
        System.out.print(String.format("%1$20s", msg) + " : ");
        while (root != null) {
            System.out.print(root.a + " ");
            root = root.next;
        }
        System.out.println();
    }
}
