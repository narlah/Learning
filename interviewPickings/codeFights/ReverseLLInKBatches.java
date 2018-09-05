package interviewPickings.codeFights;


public class ReverseLLInKBatches {
    public static void main(String[] args) {
        ReverseLLInKBatches merge = new ReverseLLInKBatches();
        merge.test();
    }

    private void test() {
        ListNode n1 = new ListNode<>(1);
        n1.next = new ListNode<>(2);
        n1.next.next = new ListNode<>(3);
        n1.next.next.next = new ListNode<>(4);
        n1.next.next.next.next = new ListNode<>(5);
        ListNode<Integer> res = reverseNodesInKGroups(n1, 2);
        System.out.print('[');
        while (res != null) {
            System.out.print(res.value + ",");
            res = res.next;
        }
        System.out.print(']');
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {
        if (k == 1)
            return l;
        int counter = 0;
        ListNode<Integer> res = new ListNode<>(0);
        res.next = l;
        ListNode<Integer> tmp = l;
        ListNode<Integer> prev = res;
        ListNode<Integer> countingTmp;
        while (tmp != null) {
            countingTmp = tmp;
            //count if we have enough for a full kset
            while (countingTmp != null && counter < k) {
                countingTmp = countingTmp.next;
                counter++;
            }//if not we leave it as it is
            if (counter < k)
                return res.next;
            else { //here we reverse the current selected set
                counter = 0;
                ListNode<Integer> tNext = tmp.next;
                ListNode<Integer> thirdFromTemp = null;
                for (int i = 0; i < k - 1; i++) {
                    thirdFromTemp = tNext.next;
                    tNext.next = tmp;
                    tmp = tNext;
                    tNext = thirdFromTemp;
                }
                countingTmp = prev.next;
                prev.next.next = thirdFromTemp;
                prev.next = tmp;
                prev = countingTmp;
                tmp = thirdFromTemp;
            }
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
}
