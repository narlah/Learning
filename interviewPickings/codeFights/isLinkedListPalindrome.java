package interviewPickings.codeFights;


public class isLinkedListPalindrome {
    public static void main(String[] args) {
        isLinkedListPalindrome is = new isLinkedListPalindrome();
        int[] arr = new int[]{1, 1000000000, -1000000000, -1000000000, 1000000000, 1};
        ListNode<Integer> root = new ListNode<>(arr[0]);
        ListNode<Integer> tmp = root;
        for (int i = 1; i < arr.length; i++) {
            tmp.next = new ListNode<>(arr[i]);
            tmp = tmp.next;
        }
        System.out.println(is.isListPalindrome(root));
    }


    //
    boolean isListPalindrome(ListNode<Integer> root) {
        if (root == null)
            return true;
        int count = 1;
        ListNode<Integer> tmp = root;
        while (tmp.next != null) {
            tmp = tmp.next;
            count++;
        }
        if (count <= 1)
            return true;

        ListNode<Integer> tmpNode = root.next;
        for (int i = 1; i < count / 2; i++) {
            tmpNode = tmpNode.next;
        }
        if (count % 2 != 0) tmpNode = tmpNode.next;
        ListNode reverseNewPoint = reverse(tmpNode);
        boolean flag = true;
        ListNode<Integer> startOne = root, startTwo = reverseNewPoint;
        for (int i = 0; i < count / 2; i++) {
            if (!startOne.value.equals(startTwo.value)) {
                flag = false;
                break;
            }
            startOne = startOne.next;
            startTwo = startTwo.next;
        }
        reverse(reverseNewPoint);
        return flag;
    }

    public ListNode reverse(ListNode root) {
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

    public void printList(ListNode root, String msg) {
        if (root == null) {
            System.out.println(String.format("%1$20s", "Empty list ") + " : " + msg);
            return;
        }
        System.out.print(String.format("%1$20s", msg) + " : ");
        while (root != null) {
            System.out.print(root.value + " ");
            root = root.next;
        }
        System.out.println();
    }
}

// Definition for singly-linked list:
class ListNode<T> {
    ListNode(T x) {
        value = x;
    }

    T value;
    ListNode<T> next;
}