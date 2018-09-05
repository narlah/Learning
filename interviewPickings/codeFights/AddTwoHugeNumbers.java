package interviewPickings.codeFights;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;

public class AddTwoHugeNumbers {
    public static void main(String[] args) {

        AddTwoHugeNumbers aa = new AddTwoHugeNumbers();
        //[9876, 5432, 1999] and b = [1, 8001]
        aa.test();
    }

    private void test() {
        ListNode n1 = new ListNode<>(9876);
        n1.next = new ListNode<>(5432);
        n1.next.next = new ListNode<>(1999);
        ListNode n2 = new ListNode(1);
        n2.next = new ListNode(8001);
        ListNode<Integer> res = addTwoHugeNumbers(n1, n2);
        System.out.print('[');
        while (res != null) {
            System.out.print(res.value + ",");
            res = res.next;
        }
        System.out.print(']');

    }

    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        BigInteger aBig = new BigInteger(extract(a));
        BigInteger bBig = new BigInteger(extract(b));
        String res = aBig.add(bBig).toString();
        int len = res.length();
        ArrayList<String> resArr = new ArrayList<>();
        for (int i = len; i > 0; i -= 4)
            resArr.add(res.substring(Math.max(0, i - 4), i)); // .split("(?<=\\G....)");
        ListNode resL = new ListNode(0);
        ListNode tmp = resL;
        Collections.reverse(resArr);
        for (String el : resArr) {
            tmp.next = new ListNode(Integer.valueOf(el.replaceFirst("^0+(?!$)", "")));
            tmp = tmp.next;
        }
        return resL.next;

    }

    private String extract(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(String.format("%04d", node.value));
            node = node.next;
        }
        return sb.toString();
    }

    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }
}
