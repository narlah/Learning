package learnStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingDouble;
import static java.util.stream.Collectors.toCollection;

public class StreamsAll {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 4, 8, 2, 3, 1, 2, 3, 5, 8, 8, 9, 10, 100, 16, 15, 78, 54};
        System.out.printf("result : %s\n%n", Arrays.stream(arr).distinct().sorted().peek(System.out::println).reduce(0, (left, right) -> left + right));
        System.out.printf("result : %s\n%n", Arrays.stream(arr).distinct().sorted().filter(i -> i < 10).peek(System.out::println).mapToDouble(Double::valueOf).map(i -> i * i).sum());

        System.out.printf("result : %s\n%n", Arrays.stream(arr).distinct().sorted().filter(i -> i < 10).mapToDouble(Double::valueOf).map(i -> i * i).boxed().collect(toCollection(ArrayList::new)));
        System.out.printf("result : %s\n%n", Arrays.stream(arr).distinct().sorted().filter(i -> i < 10).mapToDouble(Double::valueOf).map(i -> i * i).boxed().collect(summarizingDouble(Double::doubleValue)));

        System.out.printf("result : %s\n%n", Arrays.stream(arr).distinct().sorted().filter(i -> i < 10).mapToDouble(Double::valueOf).map(i -> i * i).boxed().collect(toCollection(ArrayList::new)));

        System.out.printf("result : %s\n%n", Arrays.stream(arr).limit(2).reduce(0, (j, i) -> j += i * 10));

        IntStream.range(12, 15).forEach(System.out::println);

        System.out.printf("result : %s\n%n", Arrays.stream(arr).boxed().collect(groupingBy(Function.identity())));


    }

}
