package interviewPickings.hackerRank;

public class DoubleCheckedSingleton {


    private static volatile DoubleCheckedSingleton instance;
    public String str;

    private DoubleCheckedSingleton() {
    }

    public static DoubleCheckedSingleton getSingleInstance() {
        if (instance == null) {
            synchronized (DoubleCheckedSingleton.class) {
                if (instance == null)
                    instance = new DoubleCheckedSingleton();
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(DoubleCheckedSingleton.getSingleInstance());
    }
}