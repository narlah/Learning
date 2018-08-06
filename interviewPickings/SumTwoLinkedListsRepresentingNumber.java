package interviewPickings;

public class SumTwoLinkedListsRepresentingNumber {
    class node {
        int val;
        node next;

        public node(int val) {
            this.val = val;
        }
    }

    // Function to print linked list
    void printList(String msg, node head) {
        StringBuilder strB = new StringBuilder();
        strB.append(msg);
        int size = 0;
        while (head.next != null) {
            strB.append(head.val).append("->");
            head = head.next;
            size++;
        }
        strB.append(head.val + "      size : " + (size + 1) + "\n");
        System.out.println(strB.toString());
    }

    node head1, head2, result;
    int carry;

    node createList(int[] arr) {
        node root = new node(arr[0]);
        node tmpRoot = root;
        for (int i = 1; i < arr.length; i++) {
            node newNode = new node(arr[i]);
            tmpRoot.next = newNode;
            tmpRoot = newNode;
        }
        return root;
    }

    int getsize(node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }


    // Driver program to test above functions
    public static void main(String args[]) {
        SumTwoLinkedListsRepresentingNumber list = new SumTwoLinkedListsRepresentingNumber();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        // Expected result : 1 0 1 7
        //int arr1[] = {9, 9, 9};
        //int arr2[] = {1, 8};

        // Expected result : 1 4 0 5
        int arr1[] = {5, 6, 3};
        int arr2[] = {8, 4, 2};

        list.head1 = list.createList(arr1);
        list.printList("List 1 : ", list.head1);
        list.head2 = list.createList(arr2);
        list.printList("List 2 : ", list.head2);

        list.addlists();
        list.printList("Result : ", list.result);
    }

    private void addlists() {
        int size1 = getsize(head1);
        int size2 = getsize(head2);

        node bigger = head1, smaller = head2;
        //arrange them bigger and smaller
        if (size2 > size1) {
            bigger = head2;
            smaller = head1;
        }
        //diff will be 0 in case of equal lists
        int diff = Math.abs(size2 - size1);
        recSum(bigger, smaller, diff);
        //addLastCarry - at the end if we have a positive carry we have to add it
        if (carry > 0) {
            node tmpResult = new node(carry);
            tmpResult.next = result;
            result = tmpResult;
        }
    }

    private void recSum(node node1, node node2, int diff) {
        if (node1 == null) //bigger list is over we return
            return;
        int tmpNode2Val = 0; //in case we have a node2 we will store and use it here
        if (diff > 0)
            recSum(node1.next, node2, diff - 1);
        else {
            recSum(node1.next, node2.next, diff - 1);
            tmpNode2Val = node2.val;
        }
        int val = node1.val + tmpNode2Val + carry;
        carry = 0;
        if (val >= 10) {
            carry = val / 10;
            val = val % 10;
        }
        node resultTmp = new node(val);
        resultTmp.next = result;
        result = resultTmp;
    }
}
