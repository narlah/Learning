package archive;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

class ImportStatic {
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<Integer>();
        x.add(11);
        x.add(new Integer(42));
        x.add(new Integer("17"));
        x.add(Integer.parseInt("812"));
        sort(x);
        System.out.println(x);
    }
}