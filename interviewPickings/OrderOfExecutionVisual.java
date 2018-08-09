package interviewPickings;

public class OrderOfExecutionVisual {

    static {
        step(0);
    }

    public static int step_1 = step(1);
    public int step_6 = step(6);

    static {
        step(2);
    }
    OrderOfExecutionVisual() {
        step(8);
    }

    {
        step(7);
    }

    // Just for demonstration purposes:
    static int step(int step) {
        System.out.println("Step " + step);
        return step;
    }
}

class ExampleSubclass extends OrderOfExecutionVisual {

    {
        step(9);
    }

    public static int step_3 = step(3);
    public int step_10 = step(10);

    static {
        step(4);
    }

    private ExampleSubclass() {
        step(11);
    }

    public static void main(String[] args) {
        step(5);
        new ExampleSubclass();
        step(12);
    }
}
