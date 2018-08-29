package interviewPickings;

import java.io.Serializable;
import java.util.ArrayList;

public class GenericsExtendsCheck {
    public static void main(String[] args) {
        ArrayList<? extends Serializable> data = new ArrayList<>();
        X x = new X();
        data.add(x) ;
    }

}


class X implements Serializable {
    int y;
}
