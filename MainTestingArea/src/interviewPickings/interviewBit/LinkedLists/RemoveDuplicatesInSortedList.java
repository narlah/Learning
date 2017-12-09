package interviewPickings.interviewBit.LinkedLists;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesInSortedList {


    public ListNode deleteDuplicates(ListNode a) {
        ListNode current = a;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(12, 13, 13, 14, 15, 15));
        ListNode root = new ListNode(arr.get(0));
        ListNode current = root;
        for (int i = 1; i < arr.size(); i++) {
            current.next = new ListNode(arr.get(i));
            current = current.next;
        }
        RemoveDuplicatesInSortedList rm = new RemoveDuplicatesInSortedList();
        rm.deleteDuplicates(root);
        ListNode print = root;
        while (print != null) {
            System.out.println(print.val);
            print = print.next;
        }
    }
}




