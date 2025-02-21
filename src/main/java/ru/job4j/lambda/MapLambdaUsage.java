package ru.job4j.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MapLambdaUsage {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "name");
        map.put(2, "top");
        map.put(3, "user");
        map.put(4, "precision");
        map.put(5, "post");
        map.put(-1, "test");

        BiFunction<Integer, String, String> function = (key, value) -> value + "_" + key;
        map.replaceAll(function);

        map.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        System.out.println("----- computeIfPresent() -----");

        Map<Integer, String> secMap = new HashMap<>();
        secMap.put(1, "name");

        String result = secMap.computeIfPresent(1, function);

        System.out.println("Current value: " + result);
        secMap.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        System.out.println("----- computeIfAbsent() -----");

        Map<String, Integer> thirdMap = new HashMap<>();

        Function<String, Integer> secFunction = String::length;
        System.out.println("Result: " + thirdMap.computeIfAbsent("Petr", secFunction));
        System.out.println("Result: " + thirdMap.computeIfAbsent("Petr", key -> key.length() + 10));
        thirdMap.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));

        System.out.println("----- merge() -----");
        Map<String, Integer> forthMap = new HashMap<>();
        forthMap.put("Shoes", 200);

        BiFunction<Integer, Integer, Integer> thirdFunction = (oldValue, newValue) -> oldValue - newValue;
        int newPrice = forthMap.merge("Shoes", 50, thirdFunction);
        System.out.println("New price: " + newPrice);
        System.out.println("Price of shirt: " + forthMap.merge("Shirt", 100, thirdFunction));

        forthMap.forEach((key, value) -> System.out.println("Key: " + key + ", value: " + value));
    }
}
