package interviewPickings.interviewBit.LinkedLists;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    public void printList()
    {
        ListNode temp = this;
        while (temp != null)
        {
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
    }
}