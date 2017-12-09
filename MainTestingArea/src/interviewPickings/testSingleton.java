package interviewPickings;

enum MySingleton {
    INSTANCE;
    private int x = 12;

    public int getX() {
        return x;
    }

    public void increaseXWtih(int xNew) {
        this.x = this.x + xNew;
    }
}

public class testSingleton {

    public static void main(String[] args) {
        System.out.println(MySingleton.INSTANCE.getX());
        MySingleton.INSTANCE.increaseXWtih(1);
        System.out.println(MySingleton.INSTANCE.getX());
        MySingleton.INSTANCE.increaseXWtih(10);
        System.out.println(MySingleton.INSTANCE.getX());
        MySingleton.INSTANCE.increaseXWtih(100);
        System.out.println(MySingleton.INSTANCE.getX());
    }
}

