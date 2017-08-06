package archive;

enum testSingleton {
    INSTANCE;
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        this.counter = counter + 1;
    }

    testSingleton() {
        System.out.println("Here");
    }
}

public class MyEnumSingleton {
    public static void main(String[] args) {
        System.out.println(testSingleton.INSTANCE);
        System.out.println(testSingleton.INSTANCE);

        testSingleton.INSTANCE.incrementCounter();
        testSingleton.INSTANCE.incrementCounter();
        testSingleton.INSTANCE.incrementCounter();
        testSingleton.INSTANCE.incrementCounter();
        testSingleton.INSTANCE.incrementCounter();
        testSingleton.INSTANCE.incrementCounter();
        System.out.println(testSingleton.INSTANCE.getCounter());
    }
}

