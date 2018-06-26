package interviewPickings.testDome;

import java.util.LinkedList;

public class TrainComposition {
    LinkedList<Integer> composition = new LinkedList<>();

    public void attachWagonFromLeft(int wagonId) {
        composition.addFirst(wagonId);
    }

    public void attachWagonFromRight(int wagonId) {
        composition.addLast(wagonId);
    }

    public int detachWagonFromLeft() {
       return composition.removeFirst();
    }

    public int detachWagonFromRight() {
        return composition.removeLast();
    }

    public static void main(String[] args) {
        TrainComposition tree = new TrainComposition();
        tree.attachWagonFromLeft(7);
        tree.attachWagonFromLeft(13);
        System.out.println(tree.detachWagonFromRight()); // 7
        System.out.println(tree.detachWagonFromLeft()); // 13
    }
}