package tools;

import java.util.Map;
import java.util.StringJoiner;

public class MapTools {
    public static void printMap(Map example) {
        StringJoiner joiner = new StringJoiner(", ");
        System.out.println("{");
        for (Object name : example.keySet()) {

            String key = name.toString();
            String value = example.get(name).toString();
            joiner.add(" [ k: " + key + ", v: " + value + " ] ");
        }
        System.out.println(joiner.toString());
        System.out.println("}");
    }
}
