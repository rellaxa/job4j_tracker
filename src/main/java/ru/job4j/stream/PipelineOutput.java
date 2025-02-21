package ru.job4j.stream;

import java.util.stream.Stream;

public class PipelineOutput {
    public static void main(String[] args) {
        Stream.of("one", "two", "three")
                .filter(x -> {
                    System.out.print(x);
                    return x.length() <= 3;
                })
                .map(x -> {
                    System.out.println(x);
                    return x.toUpperCase();
                })
                .forEach(System.out::println);

        System.out.println();
        System.out.println();
        Stream.of("one", "two", "three")
                .filter(x -> {
                    System.out.print(x);
                    return x.length() <= 3;
                })
                .map(x -> {
                    System.out.println(x);
                    return x.toUpperCase();
                })
                .sorted()
                .forEach(System.out::println);

        System.out.println();
        Stream.of("one", "one", "two", "three")
                .peek(System.out::println)
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        var stream = Stream.of("one", "one", "two", "three")
                .distinct();
        stream.forEach(System.out::println);
        stream.forEach(System.out::println);
    }
}
