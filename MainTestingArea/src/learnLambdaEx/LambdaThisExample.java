package learnLambdaEx;

public class LambdaThisExample {
    private static int x = 16;
    private Runnable r = () -> {
        System.out.println(x);
        System.out.println(toString());

    };

    public String toString() {
        return "hello's custom toString()";
    }

    public static void main(String[] args) {
        LambdaThisExample l = new LambdaThisExample();
        l.r.run();
    }

}
