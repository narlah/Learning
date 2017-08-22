package dataStructures.Stack;

import java.util.Stack;

public class MaxStack {
    Stack<Element> stack = new Stack<>();

    void push(int newElementValue) {
        Element n = new Element(newElementValue);
        if (stack.size() > 0){

            Element old = stack.peek();
            if (old.value < n.value) {
                n.currentMax = n.value;
            } else {
                n.currentMax = old.value;
            }
        }
        stack.push(n);
    }

    public Element pop() {
        return stack.pop();
    }

    public int getMax() {
        return stack.peek().currentMax;
    }

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(3);
        maxStack.push(4);
        maxStack.push(5);
        System.out.println(maxStack.getMax());
        maxStack.pop();
        System.out.println(maxStack.getMax());
        maxStack.pop();
        System.out.println(maxStack.getMax());
        maxStack.pop();
        System.out.println(maxStack.getMax());
        maxStack.pop();


    }
}

class Element {
    public Element(int value) {
        this.value = value;
    }

    int value;
    int currentMax;
}
