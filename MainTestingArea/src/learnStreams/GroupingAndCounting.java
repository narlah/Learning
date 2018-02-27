package learnStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;


public class GroupingAndCounting {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(1, 2, 3, 1, 1, 2));

        Map<Integer, Long> counted = list.stream().collect(groupingBy(identity(), counting()));
        System.out.println(counted);

        //another way to to it
        Map<Integer, List<Integer>> collect = list.stream().collect(Collectors.groupingBy(o -> o));
        System.out.println(collect);
        collect.entrySet().forEach(e -> System.out.println(e.getKey() + " >> " + e.getValue().size()));
    }

}
