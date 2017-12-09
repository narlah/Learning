package dataStructures.Stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MaxStack {
    private Stack<Element> stack = new Stack<>();

    public static void main(String[] args) {
        MaxStack maxStack = new MaxStack();
        maxStack.push(1);
        maxStack.push(2);
        maxStack.push(12);
        maxStack.push(3);
        maxStack.push(4);
        maxStack.push(55);
        maxStack.push(5);
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(maxStack.getMax());
                maxStack.pop();

            }
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty , do not try this at home!");
        }
    }

    public void push(int newElementValue) {
        Element newElement = new Element(newElementValue);
        if (stack.size() > 0) {
            Element oldElement = stack.peek();
            if (oldElement.currentMax < newElement.value) {
                newElement.currentMax = newElement.value;
            } else {
                newElement.currentMax = oldElement.currentMax;
            }
        }
        stack.push(newElement);
        System.out.println(newElement);
    }

    public Element pop() {
        return stack.pop();
    }

    public int getMax() {
        return stack.peek().currentMax;
    }
}

class Element {
    int value;
    int currentMax;

    Element(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Element{" +
                "value=" + value +
                ", currentMax=" + currentMax +
                '}';
    }

    public int getCurrentMax() {
        return currentMax;
    }

    public void setCurrentMax(int currentMax) {
        this.currentMax = currentMax;
    }


}
