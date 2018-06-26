package interviewPickings.InterviewCake;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class LargestStack {
    private Stack<Element> stack = new Stack<>();
    private PriorityQueue<Element> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> -a.value));

    //And apparently there is better approach - just keep another stack with "current max on this level" ...
    //should have gotten that ...
    public static void main(String[] args) {
        LargestStack largestStack = new LargestStack();
        largestStack.push(12);
        largestStack.push(16);
        largestStack.push(6);
        largestStack.push(88);
        largestStack.push(15);
        largestStack.push(1);
        largestStack.push(1001);
        for (int i = 0; i < 100; i++) {
            if (!largestStack.empty()) {
                System.out.println("max " + largestStack.getMax());
                System.out.println("pop " + largestStack.pop());
            }
        }
    }

    private boolean empty() {
        return stack.empty();
    }

    private int pop() {
        Element e = stack.pop();
        priorityQueue.remove(e);
        return e.value;
    }

    private void push(int p) {
        Element e = new Element(p);
        stack.push(e);
        priorityQueue.add(e);
    }

    private int getMax() {
        return priorityQueue.peek().value;
    }

    class Element {
        Element(int value) {
            this.value = value;
        }

        int value;
    }
}
