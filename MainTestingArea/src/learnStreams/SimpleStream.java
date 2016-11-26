package learnStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleStream {


    public static void main(String[] args) {

        List<Person> persons =
                Arrays.asList(
                        new Person("Max", 18),
                        new Person("Peter", 23),
                        new Person("Pamela", 23),
                        new Person("David", 12));
        System.out.println(getStream(persons).filter(s -> s.age == 23).count());
        System.out.println(getStream(persons).allMatch(s -> Character.isUpperCase(s.name.charAt(0))));
        System.out.println(getStream(persons).filter(s -> s.name.startsWith("P")).collect(Collectors.toList()));
        System.out.println(getStream(persons).limit(2).collect(Collectors.toList()));
        System.out.println(getStream(persons).sorted().collect(Collectors.groupingBy(p -> p.age)));

    }

    private static Stream<Person> getStream(List<Person> persons) {
        return persons.stream();
    }
}

class Person implements Comparable {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Object o) {
        int oAge = ((Person) o).age;
        if (oAge > this.age) return -1;
        else if (oAge < this.age) return 1;
        return 0;
    }
}


//    List<String> myList =
//                Arrays.asList("a12", "a1", "a2", "b1", "c2", "c1");
//
//        myList
//                .parallelStream()
//                .filter(s -> s.startsWith("a"))
//                .map(String::toUpperCase)
//                .sorted().collect(Collectors.toList()).forEach(System.out::println);
//
////        IntStream.range(1, 12)
////                .forEach(System.out::println);
//
////        Stream.of("d2", "a2", "b1", "b3", "c")
////                .map(s -> {
////                    System.out.println("map: " + s);
////                    return s.toUpperCase();
////                })
////                .anyMatch(s -> {
////                    System.out.println("anyMatch: " + s);
////                    return s.startsWith("A");
////                });
//        Stream.of("d2", "a2", "b1", "b3", "c")
//                .filter(s -> {
//                    return s.startsWith("a");
//                })
//                .map(s -> {
//                    return s.toUpperCase();
//                })
//                .forEach(s -> System.out.println("forEach: " + s));

