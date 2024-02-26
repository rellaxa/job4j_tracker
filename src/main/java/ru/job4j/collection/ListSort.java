package ru.job4j.collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        String petr = "Petr";
        String ivan = "Ivan";
        int resultString = petr.compareTo(ivan);
        System.out.println(resultString);

        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);
    }
}
