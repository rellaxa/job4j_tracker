package ru.job4j.api;

import java.util.List;

public class TakeWhile {
    public static void main(String[] args) {
        List.of(1, 2, 3, 4).stream()
                .takeWhile(value -> value < 3)
                .forEach(System.out::println);
    }
}
