package interviewPickings.hackerRank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CycleDetection {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int input = in.nextInt();
        in = new Scanner(System.in);
        String[] userProvided = new String[input];
        for (int i = 0; i < input; i++) {
            userProvided[i] = in.nextLine();
        }
        System.out.println(Arrays.toString(userProvided));

        Node root = createLinkedListWithCycle(input, userProvided);
        printLinkedListTestForCyclesInTwenty(root, input);
        detectCycle(root);
    }

    private static void printLinkedListTestForCyclesInTwenty(final Node root, int N) {
        Node tempElement = root;
        for (int i = 0; i < N *2; i++) {
            System.out.println(tempElement.getData());
            tempElement = tempElement.getNext();
        }
    }

    private static void detectCycle(Node root) {
        Node turt = root, hare = root;
        Node prev = root;
        while (turt.equals(hare)) {
            prev = turt;
            turt = turt.getNext();
            hare = hare.getNext().getNext();
        }
        System.out.println(prev.getData());
    }

    private static Node createLinkedListWithCycle(int input, String[] userProvided) {
        Node root = new Node(userProvided[0]);
        Node tempNode = root;
        HashMap<String, Node> map = new HashMap<>();
        map.put(userProvided[0], root);
        for (int i = 1; i < input; i++) {
            String str = userProvided[i];
            Node n;
            if (!map.containsKey(str))
                n = new Node(str);
            else {
                n = map.get(str);
                tempNode.setNext(n);
                break;
            }
            tempNode.setNext(n);
            tempNode = n;
            map.put(str, n);
        }
        return root;
    }
}

class Node {
    private String data;
    private Node next;

    public Node(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node node) {
        this.next = node;
    }
}
