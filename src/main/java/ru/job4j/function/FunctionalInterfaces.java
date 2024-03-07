package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        /* ---------------- BiConsumer -------------- */
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (number, string) -> map.put(number, string);
        int i = 1;
        for (String string : list) {
            biConsumer.accept(i++, string);
        }
        for (Integer key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }

        /* ---------------- BiPredicate -------------- */
        BiPredicate<Integer, String> condition = (number, string) -> number % 2 == 0 || map.get(number).length() == 4;
        for (Integer key : map.keySet()) {
            if (condition.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }

        /* ---------------- Supplier -------------- */
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();
        System.out.println(strings);

        /* ---------------- Consumer -------------- */
        Consumer<String> consumer = string -> System.out.println(string);

        /* ---------------- Function -------------- */
        Function<String, String> function = string -> string.toUpperCase();
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}
