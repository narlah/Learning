public class testSingleton {

    public static void main(String[] args) {
        System.out.println(MySingleton.INSTANCE.getX());
        System.out.println(MySingleton.INSTANCE);
    }
}

enum MySingleton {
    INSTANCE;
    private int x = 12;

    public int getX() {
        return x;
    }
}

