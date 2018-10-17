package interviewPickings.codeFights;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingDishes {
    public static void main(String[] args) {
        GroupingDishes gr = new GroupingDishes();
        String[][] arr = {{"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}};
        System.out.println(Arrays.deepToString(gr.groupingDishes(arr)));
    }

    String[][] groupingDishes(String[][] dishes) {
        HashMap<String, ArrayList<String>> mapD = new HashMap<>();
        for (String[] dishLine : dishes) {
            for (int i = 1; i < dishLine.length; i++) {
                if (!mapD.containsKey(dishLine[i])) {
                    mapD.put(dishLine[i], new ArrayList<>(Collections.singleton(dishLine[0])));
                } else {
                    ArrayList a = mapD.get(dishLine[i]);
                    a.add(dishLine[0]);
                    mapD.put(dishLine[i], a);
                }
            }
        }
        ArrayList<String[]> res = new ArrayList<>();
        mapD.entrySet().stream().filter(entry -> entry.getValue().size() > 1).
                map(entry ->
                {
                    Collections.sort(entry.getValue());
                    entry.getValue().add(0, entry.getKey());
                    return entry.getValue().toArray(new String[entry.getValue().size()]);
                }).forEach(res::add);
        Collections.sort(res, Comparator.comparing(a -> a[0]));
        return res.toArray(new String[res.size()][]);
    }

    String[][] groupingDishesOfficial(String[][] dishes) {
        //https://app.codesignal.com/interview-practice/task/xrFgR63cw7Nch4vXo/solutions/etktiesx69B9dF3rZ
        return Arrays.stream(dishes)
                .flatMap(d -> Arrays.stream(d).skip(1).map(i -> new AbstractMap.SimpleEntry(i, d[0])))
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey, TreeMap::new, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> Stream.concat(Stream.of(e.getKey()), e.getValue().stream().sorted()).toArray(String[]::new))
                .toArray(String[][]::new);
    }

}