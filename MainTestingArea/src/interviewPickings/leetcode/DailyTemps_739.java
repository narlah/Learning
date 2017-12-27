package interviewPickings.leetcode;

import interviewPickings.interviewBit.LinkedLists.ListNode;

import java.util.Arrays;
import java.util.HashMap;

public class DailyTemps_739 {
    //ListNode head;
    //HashMap<Integer, ListNode> map;

    public static void main(String[] args) {
        DailyTemps_739 dl = new DailyTemps_739();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73}; //should [1, 1, 4, 2, 1, 1, 0, 0]
        System.out.println(Arrays.toString(dl.dailyTemperatures(temperatures)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        int[] next = new int[101];
        Arrays.fill(next, Integer.MAX_VALUE);
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int warmerIndex = Integer.MAX_VALUE;
            for (int j = temperatures[i] + 1; j < 101; j++)
                if (next[j] < warmerIndex)
                    warmerIndex = next[j];
            if (warmerIndex < Integer.MAX_VALUE)
                ans[i] = warmerIndex - i;
            next[temperatures[i]] = i;
        }

        return ans;
    }

//    private void testAddToLinkedList() {
//        head = new ListNode(12);
//        head.next = new ListNode(25);
//        addToLinkedList(14);
//        addToLinkedList(14);
//        addToLinkedList(36);
//        addToLinkedList(100);
//        addToLinkedList(14);
//        addToLinkedList(12);
//        head.printList();
//
//        System.out.println("->");
//        System.out.println(Arrays.asList(map));
//        head = null;
//        map = null;
//    }
//
//    void addToLinkedList(int valToInsert) {
//        ListNode newSmallest = new ListNode(valToInsert);
//
//        if (head == null || head.val > valToInsert) {
//            newSmallest.next = head;
//            map.put(valToInsert, newSmallest);
//            head = newSmallest;
//        } else if (head.val == valToInsert)
//            return;
//        else {
//            ListNode current = head;
//            while (current.next != null &&
//                    current.next.val <= valToInsert) {
//                if (current.next.val == valToInsert) return;
//                current = current.next;
//            }
//            newSmallest.next = current.next;
//            current.next = newSmallest;
//            map.put(valToInsert, newSmallest);
//        }
//    }
}
