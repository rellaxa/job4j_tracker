package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> comparatorSize = (left, right) -> Integer.compare(left.length(), right.length());

        List<String> strings = Arrays.asList("Yandex", "Sber", "Tinkoff", "Ozon");
        System.out.println(strings);

        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        strings.sort(comparatorText);
        System.out.println(strings);

        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());
        strings.sort(comparatorDescSize);
        System.out.println(strings);
    }
}
