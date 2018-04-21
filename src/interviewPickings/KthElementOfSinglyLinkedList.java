package interviewPickings;

import java.util.stream.IntStream;

public class KthElementOfSinglyLinkedList {
    private final int K = 61;
    private final int N = 100;


    public static void main(String[] args) {
        KthElementOfSinglyLinkedList kth = new KthElementOfSinglyLinkedList();
        Node<Integer> first = new Node<>(1);
        Node<Integer> current = first;
        for (int i : IntStream.rangeClosed(2, kth.N).toArray()) {
            current.next = new Node<>(i);
            current = current.next;
        }
        System.out.println(kth.findKthElementTwoPasses(first));
        System.out.println(kth.findKthElementMovingWindow(first));
        System.out.println(kth.findKthElementMovingWindowWithImprovements(first));
    }

    private int findKthElementMovingWindowWithImprovements(Node<Integer> root) {
        Node<Integer> headPointer = root;
        Node<Integer> trailingPointer;
        Node<Integer> middle = root;
        for (int i = 1; i < K; i++) {
            if (headPointer.next == null)
                System.out.println("Not enough elements in the list, < " + K + " !");
            headPointer = headPointer.next;
        }
        while (headPointer.next != null) {
            trailingPointer = middle;
            middle = headPointer;
            for (int i = 1; i <= K; i++) {
                headPointer = headPointer.next;
                if (headPointer.next == null) {
                    if (i == K) return middle.data;
                    for (int j = 2; j <= i; j++) {
                        trailingPointer = trailingPointer.next;
                    }
                    return trailingPointer.data;
                }

            }
        }
        return 0;
    }

    private int findKthElementMovingWindow(Node<Integer> root) {
        Node<Integer> headPointer = root;
        Node<Integer> trailingPointer = root;
        for (int i = 1; i <= K; i++) {
            if (headPointer.next == null)
                System.out.println("Not enough elements in the list, < " + K + " !");
            headPointer = headPointer.next;
        }
        while (headPointer.next != null) {
            headPointer = headPointer.next;
            trailingPointer = trailingPointer.next;
        }

        return trailingPointer.data;
    }

    private int findKthElementTwoPasses(Node<Integer> root) {
        Node<Integer> curr = root;
        int count = 1;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }
        curr = root;
        for (int ignored : IntStream.range(1, count - K).toArray()) {
            curr = curr.next;
        }
        return curr.data;
    }
}

class Node<T extends Comparable> {
    Node<T> next;
    T data;

    Node(T data) {
        this.data = data;
    }
}