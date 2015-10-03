package kosev;

public class ReverseLinkedListIter {
	public static ListNode reverse(ListNode root) {
		if (root == null || root.next == null)
			return root;
		ListNode rootNext = root.next;
		root.next = null;
		while (rootNext != null) {
			ListNode temp = rootNext.next;
			rootNext.next = root;
			root = rootNext;
			rootNext = temp;
		}
		return root;
	}

	public static void main(String[] args) {
		int[] array = { 2, 6, 9, 12, 14, 19, 5 };
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

		ListNode newRootDouble = reverse(newRoot);
		printList(newRootDouble, "Double Reversed");

		ListNode newRootNull = reverse(null);
		printList(newRootNull, "Empty one");

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
