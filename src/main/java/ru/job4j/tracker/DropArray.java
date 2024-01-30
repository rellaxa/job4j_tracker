package ru.job4j.tracker;

import java.util.Arrays;

public class DropArray {
    public static void main(String[] args) {
        String[] names = {"Petr", null, "Ivan", "Evgen", null};
        String[] result = new String[names.length];
        int size = 0;
        for (int index = 0; index < names.length; index++) {
            String name = names[index];
            if (name != null) {
                result[size] = name;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        for (int index = 0; index < result.length; index++) {
            System.out.println(result[index]);
        }
        System.out.println();
        String[] newNames = {"Petr", null, "Ivan", "Stepan", "Fedor"};
        System.arraycopy(newNames, 2, newNames, 1, 3);
        System.out.println(Arrays.toString(newNames));
    }
}
