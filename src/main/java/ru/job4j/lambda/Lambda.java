package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Yandex", "Sber", "Tinkoff", "Ozon");

        Comparator<String> comparatorSize = (left, right) -> Integer.compare(left.length(), right.length());
        Comparator<String> comparatorText = (left, right) -> left.compareTo(right);
        Comparator<String> comparatorDescSize = (left, right) -> Integer.compare(right.length(), left.length());

        System.out.println(strings);

        strings.sort(comparatorText);
        System.out.println("Sort by text: " + strings);

        strings.sort(comparatorSize);
        System.out.println("Sort by asc length size: " + strings);

        strings.sort(comparatorDescSize);
        System.out.println("Sort by desc length size: " + strings);

        String[] numbers = {
                "1. Task",
                "2. Task",
                "11. Task"
        };

        Comparator<String> numberString = (left, right) -> {
            int first = Integer.valueOf(left.substring(0, left.indexOf(".")));
            int second = Integer.valueOf(right.substring(0, right.indexOf(".")));
            return Integer.compare(first, second);
        };

        Comparator<Attachment> comparator = (left, right) -> Integer.compare(left.getSize(), right.getSize());

        Comparator<Attachment> debugComparator = (left, right) -> {
            System.out.println("compare - " + left.getSize() + " : " + right.getSize());
            return Integer.compare(left.getSize(), right.getSize());
        };
    }
}
