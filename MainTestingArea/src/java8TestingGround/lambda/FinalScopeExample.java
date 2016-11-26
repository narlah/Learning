package java8TestingGround.lambda;

public class FinalScopeExample {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("z");
        Runnable r = () -> System.out.println(sb);
        sb.append("x");
        sb.append("y");
        r.run();

    }

}
