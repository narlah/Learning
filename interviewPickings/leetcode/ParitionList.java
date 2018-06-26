package interviewPickings.leetcode;

import interviewPickings.interviewBit.LinkedLists.ListNode;

public class ParitionList {
    public static void main(String[] args) {
        ParitionList pList = new ParitionList();
        //Given 1->4->3->2->5->2 and x = 3,
        //return 1->2->2->4->3->5.
        ListNode root = new ListNode(1);
        root.next = new ListNode(4);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(2);

        ListNode temp = pList.partition(root, 3);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallerThanXRoot = new ListNode(-1);
        ListNode smallerThanXLast = smallerThanXRoot;

        ListNode biggerThanXRoot = new ListNode(-1);
        ListNode biggerThanXLast = biggerThanXRoot;

        ListNode tmp = head;
        while (tmp != null) {
            if (tmp.val < x) {
                smallerThanXLast.next = tmp;
                smallerThanXLast = smallerThanXLast.next;
            } else {
                biggerThanXLast.next = tmp;
                biggerThanXLast = biggerThanXLast.next;
            }
            tmp = tmp.next;
        }
        smallerThanXLast.next = null;
        if (smallerThanXRoot.next != null && biggerThanXRoot.next != null) {
            smallerThanXLast.next = biggerThanXRoot.next;
            biggerThanXLast.next = null;
        }
        return smallerThanXRoot.next != null ? smallerThanXRoot.next : biggerThanXRoot.next;
    }
}

