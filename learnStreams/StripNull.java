package learnStreams;

import java.util.ArrayList;
import java.util.Arrays;

public class StripNull {
    public static void main(String[] args) {
        ArrayList strings = new ArrayList(Arrays.asList(null, "www", null, "something", "com", null));
        strings.forEach(p -> System.out.print(p + " "));
        System.out.println();
        strings.stream().filter(p -> p != null).forEach(p -> System.out.print(p + " "));
    }
}
