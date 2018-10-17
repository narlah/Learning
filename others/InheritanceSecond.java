package others;

import java.io.IOException;

public class InheritanceSecond extends InheritanceSuper {

    public Double method(int b) throws StackOverflowError
        {return (double)--b;}

    public static void main(String[] args) throws IOException {
        InheritanceSuper i = new InheritanceSecond();
        System.out.println(i.method(10));
    }
}
