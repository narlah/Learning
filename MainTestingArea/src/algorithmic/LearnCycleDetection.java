package algorithmic;

public class LearnCycleDetection {
    private static final int N = 20;

    public static void main(String[] args) {
        Node root = createLinkedListWithCycle();
        printLinkedListTestForCyclesInTwenty(root);
        detectCycleBrent(root);
        detectCycleFloyd(root);
    }

    // *************************************************************************************************
    private static void detectCycleFloyd(Node root) {
        // Main phase of algorithm: finding a repetition x_i = x_2i
        // The hare moves twice as quickly as the tortoise and
        // the distance between them increases by 1 at each step.
        // Eventually they will both be inside the cycle and then,
        // at some point, the distance between them will be
        // divisible by the period λ.
        Node tortoise = root.getNext(); // x0) is the element/node next to x0.
        Node hare = root.getNext().getNext();
        while (tortoise != hare) {
            tortoise = tortoise.getNext();
            hare = hare.getNext().getNext();
        }

        // At this point the tortoise position, ν, which is also equal
        // to the distance between hare and tortoise, is divisible by
        // the period λ. So hare moving in circle one step at a time,
        // and tortoise (reset to x0) moving towards the circle, will
        // intersect at the beginning of the circle. Because the
        // distance between them is constant at 2ν, a multiple of λ,
        // they will agree as soon as the tortoise reaches index μ.

        // Find the position μ of first repetition.
        int mu = 0;
        tortoise = root;
        while (tortoise != hare) {
            tortoise = tortoise.getNext();
            hare = hare.getNext(); // Hare and tortoise move at same speed
            mu += 1;
        }
        // Find the length of the shortest cycle starting from x_μ
        // The hare moves one step at a time while tortoise is still.
        // lam is incremented until λ is found.
        int lam = 1;
        hare = tortoise.getNext();
        while (tortoise != hare) {
            hare = hare.getNext();
            lam += 1;
        }
        System.out.printf("FLOYD : Cycle found at position %d and is long %d\n", mu, lam);
    }

    // *************************************************************************************************
    private static void detectCycleBrent(Node root) {
        // main phase: search successive powers of two
        int power = 1, lam = 1;
        Node tortoise = root;
        Node hare = root.getNext(); // x0) is the element/node next to x0.
        while (tortoise != hare) {
            if (power == lam) {// time to start a new power of two?
                tortoise = hare;
                power *= 2;
                lam = 0;
            }
            hare = hare.getNext();
            lam += 1;
        }

        // Find the position of the first repetition of length λ
        int mu = 0;
        tortoise = hare = root;
        for (int i = 0; i < lam; i++) {
            hare = hare.getNext();
        }
        // The distance between the hare and tortoise is now λ.

        // Next, the hare and tortoise move at same speed till they agree
        while (tortoise != hare) {
            tortoise = tortoise.getNext();
            hare = hare.getNext();
            mu += 1;
        }
        System.out.printf("BRENT : Cycle found at position %d and is long %d\n", mu, lam);
    }

    private static void printLinkedListTestForCyclesInTwenty(final Node root) {
        Node tempElement = root;
        for (int i = 0; i < N * 3; i++) {
            System.out.println(tempElement.getData());
            tempElement = tempElement.getNext();
        }
    }

    private static Node createLinkedListWithCycle() {
        Node root = new Node(0);
        Node tempNode = root;
        Node tenthNode = root;
        for (int i = 1; i <= N; i++) {
            Node n = new Node(i);
            tempNode.setNext(n);
            tempNode = n;
            if (i == N / 2)
                tenthNode = n;
        }
        tempNode.setNext(tenthNode);
        return root;
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}