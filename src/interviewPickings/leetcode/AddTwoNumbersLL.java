package interviewPickings.leetcode;

import interviewPickings.interviewBit.LinkedLists.ListNode;

public class AddTwoNumbersLL {

    public ListNode addTwoNumbers(ListNode l1R, ListNode l2R) {
        int carry = 0;
        ListNode resultingListRoot = new ListNode(0);
        ListNode resultingListCurrent = resultingListRoot;
        ListNode f = l1R, s = l2R;
        while (f != null || s != null) {
            int x = (f != null) ? f.val : 0;
            int y = (s != null) ? s.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            resultingListCurrent.next = new ListNode(sum % 10);
            resultingListCurrent = resultingListCurrent.next;
            if (f != null) f = f.next;
            if (s != null) s = s.next;
        }
        if (carry > 0) {
            resultingListCurrent.next = new ListNode(carry);
        }
        return resultingListRoot.next;

    }


    public ListNode addTwoNumbersAbomination(ListNode l1, ListNode l2) {
        ListNode biggerListRoot = l1, smallerListRoot = l2;
        int biggerSize = getSizeOfLL(l1);
        int smallerSize = getSizeOfLL(l2);

        if (biggerSize < smallerSize) {
            biggerListRoot = l2;
            smallerListRoot = l1;
            int tmp = biggerSize;
            biggerSize = smallerSize;
            smallerSize = tmp;

        }
        ListNode biggerListCurrent = biggerListRoot;
        ListNode smallerListCurrent = smallerListRoot;
        ListNode resultingListRoot = new ListNode(0);
        ListNode resultingListCurrent = resultingListRoot;
        boolean carry = false;

        while (biggerSize > 0) {
            int sum = biggerListCurrent.val;
            biggerListCurrent = biggerListCurrent.next;
            if (smallerSize > 0) {
                sum += smallerListCurrent.val;
                smallerListCurrent = smallerListCurrent.next;
                smallerSize--;
            }
            biggerSize--;
            if (carry) sum++;
            if (sum >= 10) {
                sum = sum - 10;
                carry = true;
            } else
                carry = false;
            resultingListCurrent.next = new ListNode(sum);
            resultingListCurrent = resultingListCurrent.next;

        }
        if (carry) resultingListCurrent.next = new ListNode(1);
        return resultingListRoot.next;
    }

    private int getSizeOfLL(ListNode root) {
        ListNode current = root;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public static void main(String[] args) {
        AddTwoNumbersLL atn = new AddTwoNumbersLL();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(8);


        ListNode l2 = new ListNode(1);

        ListNode res = atn.addTwoNumbers(l1, l2);
        StringBuilder stb = new StringBuilder();
        do {
            stb.append(res.val);
            res = res.next;
            if (res == null) break;
            stb.append(" , ");
        } while (true);
        System.out.print('[' + stb.toString() + ']');

    }
}

